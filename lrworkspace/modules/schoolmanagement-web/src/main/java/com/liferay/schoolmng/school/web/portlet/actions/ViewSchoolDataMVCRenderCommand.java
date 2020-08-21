
package com.liferay.schoolmng.school.web.portlet.actions;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.schoolmng.school.service.SchoolDataLocalService;
import com.liferay.schoolmng.school.web.constants.MVCCommandNames;
import com.liferay.schoolmng.school.web.constants.SchoolPortletKeys;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * MVC command for displaying the School Data.
 *
 * @author Anjaneya
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + SchoolPortletKeys.SCHOOL_PORTLET_NAME,		
		"mvc.command.name=" + MVCCommandNames.VIEW_SCHOOLDATA
	},
	service = MVCRenderCommand.class
)
public class ViewSchoolDataMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws PortletException {

		if(_log.isTraceEnabled()) {
			 _log.trace("Entered render : view School Data");
		}
		System.out.println("Entere render method...");
		return "/view.jsp";
	}
	
	private static final Log _log =
			LogFactoryUtil.getLog(EditSchoolDataMVCRenderCommand.class);
	
	@Reference
	protected SchoolDataLocalService _schooldataLocalService;

	@Reference
	private Portal _portal;

}