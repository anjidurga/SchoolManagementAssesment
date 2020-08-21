package com.liferay.schoolmng.school.search;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.IndexWriterHelper;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.schoolmng.school.model.SchoolData;
import com.liferay.schoolmng.school.service.SchoolDataLocalService;

import java.util.Locale;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * School Data Indexer
 *
 * @author Anjaneya
 *
 */
@Component(
		immediate = true, service = Indexer.class
	)
public class SchoolDataIndexer extends BaseIndexer<SchoolData> {

	public SchoolDataIndexer() {
		setDefaultSelectedFieldNames(Field.COMPANY_ID, Field.ENTRY_CLASS_NAME, Field.ENTRY_CLASS_PK, Field.UID,
			Field.DESCRIPTION);
		setFilterSearch(true);
		setPermissionAware(true);
	}

	@Override
	public String getClassName() {
		return _CLASS_NAME;
	}

	@Override
	protected void doDelete(SchoolData schoolData) throws Exception {
		deleteDocument(schoolData.getCompanyId(), schoolData.getSchoolId());
	}

	@Override
	protected Document doGetDocument(SchoolData schoolData) throws Exception {
		
		if(_log.isTraceEnabled()) {
			_log.trace("Start : Indexing School Data");
		}
		Document document = getBaseModelDocument(_CLASS_NAME, schoolData);

		document.addText(Field.TITLE, schoolData.getSchoolName());
		document.addText(_CITY_NAME, schoolData.getCity());
		document.addText(_SCHOOL_TYPE, schoolData.getSchoolType());
		document.addNumber(_NO_OF_STUDENTS, schoolData.getNoOfStudents());
		document.addNumber(_RATING, schoolData.getRating());

		return document;
	}

	@Override
	protected Summary doGetSummary(Document document, Locale locale, String snippet, PortletRequest portletRequest,
			PortletResponse portletResponse) throws Exception {

		String prefix = Field.SNIPPET + StringPool.UNDERLINE;

		String title = document.get(prefix + Field.TITLE, Field.TITLE);
		String content = document.get(_CITY_NAME);

		Summary summary = new Summary(title, content);

		summary.setMaxContentLength(200);

		return summary;
	}

	@Override
	@SuppressWarnings("deprecation")
	protected void doPostProcessSearchQuery(
			Indexer<?> indexer, BooleanQuery searchQuery,
			SearchContext searchContext)
		throws Exception {

		String schoolName = (String)searchContext.getAttribute(_SCHOOL_NAME);
		String cityName = (String)searchContext.getAttribute(_CITY_NAME);
		String schoolType = (String)searchContext.getAttribute(_SCHOOL_TYPE);
		String noOfStudent = (String)searchContext.getAttribute(
			_NO_OF_STUDENTS);
		String rating = (String)searchContext.getAttribute(_RATING);

		/**
		 * WildcardQuery wildcardQuery=new WildcardQueryImpl(new QueryTermImpl("title",
		 * StringPool.STAR.concat("TPIS").concat(StringPool.STAR)));
		 * searchQuery.add(wildcardQuery, BooleanClauseOccur.MUST);
		 */
		
		if(_log.isTraceEnabled()) {
			_log.trace("Start : Forming query and sending for indexer");
		}
		if(_log.isDebugEnabled()) {
			_log.debug(" Query param is >> school Name= [" + schoolName + " ] City name= ["
					+ cityName + " ] schoolType = [" + schoolType + " ] noOfStudent = [" + noOfStudent + " ] rating = [ " + rating + "]");

		}
		
		if (Validator.isNotNull(schoolName)) {
			searchQuery.addRequiredTerm(Field.TITLE, schoolName);
		}

		if (Validator.isNotNull(cityName)) {
			searchQuery.addRequiredTerm(_CITY_NAME, cityName);
		}

		if (Validator.isNotNull(schoolType)) {
			searchQuery.addRequiredTerm(_SCHOOL_TYPE, schoolType);
		}

		if (Validator.isNotNull(noOfStudent)) {
			searchQuery.addRequiredTerm(_NO_OF_STUDENTS, noOfStudent);
		}

		if (Validator.isNotNull(rating)) {
			searchQuery.addRequiredTerm(_RATING, rating);
		}

		super.doPostProcessSearchQuery(indexer, searchQuery, searchContext);
	}

	@Override
	protected void doReindex(SchoolData schoolData) throws Exception {
		Document document = getDocument(schoolData);

		_indexWriterHelper.updateDocument(getSearchEngineId(), schoolData.getCompanyId(), document,
			isCommitImmediately());
	}

	@Override
	protected void doReindex(String className, long classPK) throws Exception {
		SchoolData schoolData = _schooldataLocalService.getSchoolData(classPK);

		doReindex(schoolData);
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {
		long companyId = GetterUtil.getLong(ids[0]);
		reindexSchoolDatas(companyId);
	}

	protected void reindexSchoolDatas(long companyId) throws PortalException {
		final IndexableActionableDynamicQuery indexableActionableDynamicQuery = _schooldataLocalService
			.getIndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setCompanyId(companyId);

		// Actionable query

		indexableActionableDynamicQuery
				.setPerformActionMethod(
				new ActionableDynamicQuery.PerformActionMethod<SchoolData>() {

					@Override
					public void performAction(SchoolData assignment) {
						try {
							Document document = getDocument(assignment);

							indexableActionableDynamicQuery.addDocuments(
								document);
						} catch (PortalException pe) {
							if (_log.isWarnEnabled()) {
								_log.warn(
									"Unable to index assignment " + assignment.getSchoolId(),
									pe);
							}
						}
					}

				});

		indexableActionableDynamicQuery.setSearchEngineId(getSearchEngineId());
		indexableActionableDynamicQuery.performActions();
	}

	@Reference
	protected IndexWriterHelper _indexWriterHelper;

	private static final String _CITY_NAME = "cityName";

	private static final String _CLASS_NAME = SchoolData.class.getName();

	private static final String _NO_OF_STUDENTS = "noOfStudents";

	private static final String _RATING = "rating";

	private static final String _SCHOOL_NAME = "schoolName";

	private static final String _SCHOOL_TYPE = "schoolType";

	private static final Log _log = LogFactoryUtil.getLog(SchoolData.class);

	@Reference
	private SchoolDataLocalService _schooldataLocalService;

}