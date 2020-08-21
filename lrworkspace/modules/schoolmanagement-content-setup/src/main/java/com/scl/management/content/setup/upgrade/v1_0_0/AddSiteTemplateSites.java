package com.scl.management.content.setup.upgrade.v1_0_0;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.schoolmng.content.setup.constants.FileNameConstants;
import com.liferay.schoolmng.content.setup.upgrade.SchoolManagementSetupUpgrade;
import com.liferay.schoolmng.content.setup.util.LayoutSetPrototypeUtil;

/**
 * To import site template lar.
 *
 * @author Anjaneya
 *
 */
public class AddSiteTemplateSites extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		if (_log.isInfoEnabled()) {
			_log.info("Executing AddSiteTemplateSites Upgrade process");
		}

		LayoutSetPrototypeUtil.importLayoutSetPrototypeLAR(
				FileNameConstants.SITE_TEMPLATE_NAME_SCHOOL_MANAGEMENT,
			FileNameConstants.SCCHOOL_MGMT_PORTAL_SITE_TEMPLATE);
	}

	private static final Log _log = LogFactoryUtil.getLog(
		SchoolManagementSetupUpgrade.class);

}