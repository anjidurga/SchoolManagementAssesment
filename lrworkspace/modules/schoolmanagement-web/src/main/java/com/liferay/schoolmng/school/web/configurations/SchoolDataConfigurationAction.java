package com.liferay.schoolmng.school.web.configurations;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.schoolmng.school.web.constants.SchoolPortletKeys;

import java.io.IOException;

import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Modified;

/**
 * Portlet Preference
 *
 * @author Anjaneya
 *
 */
@Component(
		configurationPid = "com.liferay.schoolmng.school.schoolPortletConfigurations",
		configurationPolicy = ConfigurationPolicy.OPTIONAL, immediate = true,
		property = "javax.portlet.name=" + SchoolPortletKeys.SCHOOL_PORTLET_NAME,
		service = ConfigurationAction.class
)
public class SchoolDataConfigurationAction extends DefaultConfigurationAction {

	@Override
	public void include(PortletConfig portletConfig, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {

		httpServletRequest.setAttribute(
			SchoolDataConfiguration.class.getName(),
			_assetsStatisticsDataConfiguration);
		super.include(portletConfig, httpServletRequest, httpServletResponse);
	}

	@Override
	public void processAction(
			PortletConfig portletConfig, ActionRequest actionRequest,
			ActionResponse actionResponse)
		throws Exception {

		setPreference(
			actionRequest, "selectedAssets",
			ParamUtil.getString(actionRequest, "values"));
		setPreference(
			actionRequest, "selectedDateFormat",
			ParamUtil.getString(actionRequest, "dateFormat"));
		super.processAction(portletConfig, actionRequest, actionResponse);
	}

	@Override
	public void serveResource(
			ResourceRequest resourceRequest, ResourceResponse resourceResponse)
		throws IOException, PortletException {

		super.serveResource(resourceRequest, resourceResponse);
	}

	@Activate
	@Modified
	protected void activate(Map<Object, Object> properties) {
		_assetsStatisticsDataConfiguration =
			ConfigurableUtil.createConfigurable(
				SchoolDataConfiguration.class, properties);
	}

	private volatile SchoolDataConfiguration _assetsStatisticsDataConfiguration;

}