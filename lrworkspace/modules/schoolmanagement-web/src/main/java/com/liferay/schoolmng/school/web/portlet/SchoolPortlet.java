package com.liferay.schoolmng.school.web.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.schoolmng.school.web.constants.SchoolPortletKeys;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * Portlet class for School Management
 *
 * @author Anjaneya
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.schoolmanagement",
		"javax.portlet.display-name=school-web-portlet",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + SchoolPortletKeys.SCHOOL_PORTLET_NAME,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class SchoolPortlet extends MVCPortlet {
	
}