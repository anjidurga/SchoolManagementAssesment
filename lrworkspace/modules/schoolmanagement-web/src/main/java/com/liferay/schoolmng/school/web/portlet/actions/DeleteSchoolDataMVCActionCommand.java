
package com.liferay.schoolmng.school.web.portlet.actions;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.schoolmng.school.service.SchoolDataLocalService;
import com.liferay.schoolmng.school.web.constants.MVCCommandNames;
import com.liferay.schoolmng.school.web.constants.SchoolPortletKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * MVC Action Command for deleting School Data.
 *
 * @author Anjaneya
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + SchoolPortletKeys.SCHOOL_PORTLET_NAME,
		"mvc.command.name=" + MVCCommandNames.DELETE_SCHOOLDATA
	},
	service = MVCActionCommand.class
)
public class DeleteSchoolDataMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		if(_log.isTraceEnabled()) {
			 _log.trace("Entered doProcessAction : Delete School Data");
		}
		
		long schoolId = ParamUtil.getLong(actionRequest, "schoolId");
		
		if (_log.isDebugEnabled()) {
			_log.debug("schoolId =[ " + schoolId +"]");
		}
		_schooldataLocalService.deleteSchoolData(schoolId);
		
		if(_log.isTraceEnabled()) {
			 _log.trace("End doProcessAction : Delete School Data");
		}
	}

	@Reference
	protected SchoolDataLocalService _schooldataLocalService;

	private static final Log _log =
		LogFactoryUtil.getLog(DeleteSchoolDataMVCActionCommand.class);

}