package com.scl.management.content.setup.util;

import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.LayoutSetPrototype;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.LayoutSetPrototypeLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class LayoutSetPrototypeUtil {

	public static LayoutSetPrototype addLayoutSetPrototype(
			long companyId, String uuid, String name, String description)
		throws PortalException {

		LayoutSetPrototype siteTemplate = null;

		boolean active = true;
		boolean layoutsUpdateable = false;
		User creatorUser = ContentSetupUtil.getUserAdmin(companyId);

		Map<Locale, String> nameMap = Collections.singletonMap(
			LocaleUtil.getDefault(), name);

		Map<Locale, String> descriptionMap = Collections.singletonMap(
			LocaleUtil.getDefault(), description);

		ServiceContext serviceContext = new ServiceContext();

		serviceContext.setAttribute("addDefaultLayout", Boolean.FALSE);

		if (validate(name, uuid)) {
			try {
				siteTemplate =
					LayoutSetPrototypeLocalServiceUtil.addLayoutSetPrototype(
						creatorUser.getUserId(), companyId, nameMap,
						descriptionMap, active, layoutsUpdateable,
						serviceContext);
			}
			catch (PortalException pe) {
				throw new PortalException(
					String.format(
						"Unable to add layoutSetPrototype with name=%s", name),
					pe);
			}
		}

		if (_log.isInfoEnabled()) {
			_log.info(
				String.format(
					"Created empty LayoutSetPrototype=%s with groupId=%s", name,
					siteTemplate.getGroupId()));
		}

		return siteTemplate;
	}

	public static LayoutSetPrototype fetchLayoutSetPrototype(
		String layoutSetPrototypeName) {

		DynamicQuery dynamicQuery =
			LayoutSetPrototypeLocalServiceUtil.dynamicQuery();

		Criterion nameCriterion = RestrictionsFactoryUtil.like(
			"name", "%" + layoutSetPrototypeName + "%");

		dynamicQuery.add(nameCriterion);

		List<LayoutSetPrototype> layoutSetPrototypes =
			LayoutSetPrototypeLocalServiceUtil.dynamicQuery(dynamicQuery);

		if ((layoutSetPrototypes != null) && !layoutSetPrototypes.isEmpty()) {
			return layoutSetPrototypes.get(0);
		}

		return null;
	}

	/**
	 * Import SiteTemplate
	 *
	 * @param layoutSetPrototypeName
	 * @param fileName
	 */
	public static long importLayoutSetPrototypeLAR(
			String layoutSetPrototypeName, String fileName)
		throws Exception {

		long companyId = PortalUtil.getDefaultCompanyId();

		LayoutSetPrototype layoutSetPrototype = fetchLayoutSetPrototype(
			layoutSetPrototypeName);

		if (Validator.isNotNull(layoutSetPrototype)) {
			if (_log.isInfoEnabled()) {
				_log.info(
					String.format(
						"layoutSetPrototype exists with name=%s and " +
							"fileName=%s, LayoutSetPrototype already exists.",
						layoutSetPrototypeName, fileName));
			}
		}
		else {
			layoutSetPrototype = addLayoutSetPrototype(
				companyId, PortalUUIDUtil.generate(), layoutSetPrototypeName,
				StringPool.BLANK);
		}

		long templateGroupId = layoutSetPrototype.getGroupId();

		LARImporter.importLayoutLAR(templateGroupId, fileName);

		if (_log.isInfoEnabled()) {
			_log.info(
				String.format(
					"Successfully imported LayoutLAR for " +
						"LayoutSetPrototype=%s with groupId=%s",
					layoutSetPrototypeName, templateGroupId));
		}

		return templateGroupId;
	}

	protected static boolean validate(
		String siteTemplateName, String siteTemplateUuid) {

		if (Validator.isBlank(siteTemplateName)) {
			if (_log.isInfoEnabled()) {
				_log.info("Site template name is blank.");
			}

			return false;
		}
		else if (Validator.isBlank(siteTemplateUuid)) {
			if (_log.isInfoEnabled()) {
				_log.info("Site template uuid is blank.");
			}

			return false;
		}

		return true;
	}

	private static final Log _log = LogFactoryUtil.getLog(
		LayoutSetPrototypeUtil.class);

}