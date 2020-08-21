package com.liferay.schoolmng.school.web.asset;

import com.liferay.asset.kernel.model.AssetRenderer;
import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.asset.kernel.model.BaseAssetRendererFactory;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.LiferayPortletURL;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.ResourceBundleLoader;
import com.liferay.schoolmng.school.model.SchoolData;
import com.liferay.schoolmng.school.service.SchoolDataLocalService;
import com.liferay.schoolmng.school.service.permission.SchoolDataPermissionChecker;
import com.liferay.schoolmng.school.web.constants.MVCCommandNames;
import com.liferay.schoolmng.school.web.constants.SchoolPortletKeys;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.WindowState;
import javax.portlet.WindowStateException;

import javax.servlet.ServletContext;

import org.omg.PortableInterceptor.ACTIVE;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * School Data Asset Render factory.
 *
 * @author Anjaneya
 *
 */
@Component(
		immediate = true,
		property = "javax.portlet.name="+ SchoolPortletKeys.SCHOOL_PORTLET_NAME,
		service = AssetRendererFactory.class
		)
public class SchoolDataAssetRendererFactory
	extends BaseAssetRendererFactory<SchoolData> {

	public SchoolDataAssetRendererFactory() {
		setClassName(SchoolData.class.getName());
		setCategorizable(true);
		setLinkable(true);
		setPortletId(SchoolPortletKeys.SCHOOL_PORTLET_NAME);
		setSearchable(true);
		setSelectable(true);
	}

	@Override
	public AssetRenderer<SchoolData> getAssetRenderer(long classPK, int type)
		throws PortalException {

		SchoolData schoolData = _schoolDataService.getSchoolData(classPK);

		SchoolDataAssetRenderer schoolDataassetRenders = new SchoolDataAssetRenderer(schoolData,
			_schoolDataPermissionChecker);

		schoolDataassetRenders.setAssetRendererType(type);
		schoolDataassetRenders.setServletContext(_servletContext);

		return schoolDataassetRenders;
	}

	@Override
	public String getClassName() {
		return SchoolData.class.getName();
	}

	@Override
	public String getType() {
		return TYPE;
	}

	@Override
	public PortletURL getURLAdd(LiferayPortletRequest liferayPortletRequest,
			LiferayPortletResponse liferayPortletResponse, long classTypeId) {

		PortletURL portletURL = _portal.getControlPanelPortletURL(liferayPortletRequest,
				getGroup(liferayPortletRequest),
				SchoolPortletKeys.SCHOOL_PORTLET_NAME, 0, 0,
				PortletRequest.RENDER_PHASE);
		
		portletURL.setParameter(
			"mvcRenderCommandName", MVCCommandNames.EDIT_SCHOOLDATA);
			
		if(_log.isTraceEnabled()) {
		  _log.trace("Add URL is = "+portletURL.toString());
		}

		return portletURL;
	}

	@Override
	public PortletURL getURLView(
		LiferayPortletResponse liferayPortletResponse,
		WindowState windowState) {

		LiferayPortletURL liferayPortletURL = liferayPortletResponse
				.createLiferayPortletURL(
					SchoolPortletKeys.SCHOOL_PORTLET_NAME,
					PortletRequest.RENDER_PHASE);

		try {
			liferayPortletURL.setWindowState(windowState);
		} catch (WindowStateException wse) {
		}

		return liferayPortletURL;
	}

	@Override
	public boolean hasAddPermission(
			PermissionChecker permissionChecker, long groupId, long classTypeId)
		throws Exception {

		boolean hasAddSchoolData = _schoolDataPermissionChecker.containsTopLevel(permissionChecker, groupId,
			SchoolDataPermissionChecker.ADD_SCHOOLDATA);
			
			if(_log.isTraceEnabled()) {
		  		_log.debug("Has Add permission for School Data = [ "+hasAddSchoolData +" ]");
			}
			
			return hasAddSchoolData;
	}
	

	@Reference(
		target = "(bundle.symbolic.name=com.liferay.schoolmng.school.web)",
		unbind = "-"
	)
	public void setResourceBundleLoader(
		ResourceBundleLoader resourceBundleLoader) {

		this._resourceBundleLoader = resourceBundleLoader;
	}

	@Reference(
		target = "(osgi.web.symbolicname=com.liferay.schoolmng.school.web)",
		unbind = "-"
	)
	public void setServletContext(ServletContext servletContext) {
		this._servletContext = servletContext;
	}

	@Reference(unbind = "-")
	protected void setLeaveService(SchoolDataLocalService schoolDataService) {
		this._schoolDataService = schoolDataService;
	}

	private static final Log _log = LogFactoryUtil.getLog(
		SchoolDataAssetRenderer.class);

	@Reference
	private Portal _portal;	

	@Reference
	private SchoolDataPermissionChecker _schoolDataPermissionChecker;
	
	private ResourceBundleLoader _resourceBundleLoader;
	
	public static final String TYPE = "schoolData";

	private SchoolDataLocalService _schoolDataService;
	private ServletContext _servletContext;

}