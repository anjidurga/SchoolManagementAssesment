package com.liferay.schoolmng.content.setup.upgrade;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.upgrade.registry.UpgradeStepRegistrator;
import com.liferay.schoolmng.content.setup.upgrade.v1_0_0.AddSiteTemplateSites;
import com.liferay.schoolmng.content.setup.upgrade.v1_0_0.CreateRoleAndDefinePermission;
import com.liferay.schoolmng.content.setup.upgrade.v1_0_0.CreateSiteFromSiteTemplate;

import org.osgi.service.component.annotations.Component;

/**
 * Upgrade process to setup school management data.
 *
 * @author Anjaneya
 *
 */
@Component(immediate = true, service = UpgradeStepRegistrator.class)
public class SchoolManagementSetupUpgrade implements UpgradeStepRegistrator {

	@Override
	public void register(Registry registry) {
		
		if(_log.isInfoEnabled()) {		
		_log.info("Started School upgrade process.");
		}

		registry.register("0.0.0", "1.0.0", new AddSiteTemplateSites());

		
		registry.register(
				"1.0.0", "1.0.1",
				new CreateRoleAndDefinePermission("school_mng_admin"));

				
		registry.register(
				"1.0.1", "1.0.2",
				new CreateSiteFromSiteTemplate("School Management"));
		
		

		if (_log.isInfoEnabled()) {
			_log.info(
				"School Management data has been imported successfully.");
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(
		SchoolManagementSetupUpgrade.class);

}