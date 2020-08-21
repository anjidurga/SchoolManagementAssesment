
package com.liferay.schoolmng.school.web.portlet.actions;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.schoolmng.school.exception.NoSuchSchoolDataException;
import com.liferay.schoolmng.school.model.SchoolData;
import com.liferay.schoolmng.school.service.SchoolDataLocalService;
import com.liferay.schoolmng.school.web.constants.MVCCommandNames;
import com.liferay.schoolmng.school.web.constants.SchoolPortletKeys;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * MVC Command for showing edit assignment view.
 *
 * @author Anjaneya
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + SchoolPortletKeys.SCHOOL_PORTLET_NAME,
		"mvc.command.name=" + MVCCommandNames.EDIT_SCHOOLDATA
	},
	service = MVCRenderCommand.class
)
public class EditSchoolDataMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws PortletException {

		if(_log.isTraceEnabled()) {
			 _log.trace("Entered render : get data for edit School Data");
		}
		SchoolData assignment = null;

		long schoolId = ParamUtil.getLong(renderRequest, "schoolId", 0);
		String cmd = ParamUtil.getString(renderRequest, "cmd", "edit");
		String jsp = null;
		
		if(_log.isDebugEnabled()) {
			 _log.debug("Edit schoolId = [ "+schoolId + " ]" +
					" cmd = [ "+cmd +" ]" );
		}

		if (schoolId > 0) {
			try {
				assignment = _schoolDataLocalService.getSchoolData(schoolId);
			} catch (NoSuchSchoolDataException nssde) {
				_log.error(nssde.getLocalizedMessage());
				if (_log.isTraceEnabled()) {
					_log.trace(nssde);
				}
			} catch (PortalException pe) {
				_log.error(pe.getLocalizedMessage());
				if (_log.isTraceEnabled()) {
					_log.trace(pe);
				}
			}
		}

		ThemeDisplay themeDisplay =
			(ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		// Set assignment to the request attributes

		renderRequest.setAttribute("schoolData", assignment);
		renderRequest.setAttribute("schoolDataClass", SchoolData.class);
		
		
		jsp = "/school/" + cmd + "_school.jsp";
		
		if(_log.isDebugEnabled()) {
			 _log.debug("Redirected to jsp = "+jsp);
		}
		
		if(_log.isTraceEnabled()) {
			 _log.trace("End render : get data for edit School Data");
		}
		
		return jsp;
	}

	private static final Log _log =
		LogFactoryUtil.getLog(EditSchoolDataMVCRenderCommand.class);

	@Reference
	private SchoolDataLocalService _schoolDataLocalService;

}