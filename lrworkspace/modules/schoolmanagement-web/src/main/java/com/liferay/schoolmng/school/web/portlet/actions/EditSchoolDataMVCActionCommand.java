
package com.liferay.schoolmng.school.web.portlet.actions;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.schoolmng.school.exception.SchoolDataValidationException;
import com.liferay.schoolmng.school.model.SchoolData;
import com.liferay.schoolmng.school.service.SchoolDataService;
import com.liferay.schoolmng.school.web.constants.MVCCommandNames;
import com.liferay.schoolmng.school.web.constants.SchoolPortletKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * MVC Action Command for editing School Data .
 *
 * @author Anjaneya
 *
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + SchoolPortletKeys.SCHOOL_PORTLET_NAME,
		"mvc.command.name=" + MVCCommandNames.EDIT_SCHOOLDATA
	},
	service = MVCActionCommand.class
)
public class EditSchoolDataMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {
		
		if(_log.isTraceEnabled()) {
			 _log.trace("Entered doProcessAction : Edit School Data");
		}
		
		ThemeDisplay themeDisplay =
			(ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(
				SchoolData.class.getName(), actionRequest);

		// Get parameters from the request.
		
		long schoolId = ParamUtil.getLong(actionRequest, "schoolId");
		
		if(_log.isDebugEnabled()) {
			 _log.trace("schoolId while editing = ["+ schoolId +"]");
		}
		
		try {
			_schooldataService.updateSchoolData(themeDisplay.getScopeGroupId(), schoolId,
					ParamUtil.getString(actionRequest, "schoolName"),
					ParamUtil.getString(actionRequest, "schoolType"),
					ParamUtil.getString(actionRequest, "city"),
					ParamUtil.getInteger(actionRequest, "noOfStudents"),
					ParamUtil.getInteger(actionRequest, "rating"),
					serviceContext);

			// Set success message.

			SessionMessages.add(actionRequest, "schoodataUpdated");

			// Hide default success message.

			hideDefaultSuccessMessage(actionRequest);

		    sendRedirect(actionRequest, actionResponse);
			
			
		} catch (SchoolDataValidationException e) {

			_log.error(e.getLocalizedMessage());
			
			if(_log.isTraceEnabled()) {
				_log.trace(e);				
			}
			

			e.getErrors().forEach(key -> SessionErrors.add(actionRequest, key));

			actionResponse.setRenderParameter(
				"mvcRenderCommandName", MVCCommandNames.EDIT_SCHOOLDATA);

		} catch (PortalException pe) {

			_log.error(pe.getLocalizedMessage());
			
			if(_log.isTraceEnabled()) {
				_log.trace(pe);				
			}

			// Set error message.

			SessionErrors.add(actionRequest, "error.schooldata-service-error");

			actionResponse.setRenderParameter(
				"mvcRenderCommandName", MVCCommandNames.EDIT_SCHOOLDATA);
		}
		
		if(_log.isTraceEnabled()) {
			 _log.trace("End doProcessAction : Edit School Data");
		}

	}

	@Reference
	protected SchoolDataService _schooldataService;

	private static final Log _log =
		LogFactoryUtil.getLog(EditSchoolDataMVCActionCommand.class);

}