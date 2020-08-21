package com.scl.management.content.setup.upgrade.v1_0_0;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.RoleConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.service.ResourcePermissionLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.schoolmng.content.setup.upgrade.SchoolManagementSetupUpgrade;
import com.liferay.schoolmng.content.setup.util.ContentSetupUtil;
import com.liferay.schoolmng.school.model.SchoolData;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Reference;

/**
 * Upgrade process to create Role and Assign Define permission.
 *
 * @author Anjaneya
 *
 */
public class CreateRoleAndDefinePermission extends UpgradeProcess {

	public CreateRoleAndDefinePermission(String name) {
		this._roleName = name;
	}

	@Override
	protected void doUpgrade() throws Exception {
		Locale defaultLocale = Locale.US;

		int scope = ResourceConstants.SCOPE_COMPANY;

		Map<Locale, String> titleMap = new HashMap<>();
		titleMap.put(defaultLocale, _roleName);

		Map<Locale, String> descriptionMap = new HashMap<>();

		ServiceContext serviceContext = new ServiceContext();

		int type = RoleConstants.TYPE_REGULAR;

		long companyId = PortalUtil.getDefaultCompanyId();

		User admin = ContentSetupUtil.getUserAdmin(companyId);

		try {
			Role _role = RoleLocalServiceUtil.addRole(admin.getUserId(), null, 0, _roleName, titleMap, descriptionMap, type, null,
				serviceContext);

			if (_log.isInfoEnabled()) {
				_log.info(
					"Role name [ "+_role.getName() + " ] has been created");
			}

			String primaryKey = String.valueOf(_role.getCompanyId());

			ResourcePermissionLocalServiceUtil.setResourcePermissions(companyId,
					SchoolData.class.getName().substring(
					0,
					SchoolData.class.getName().lastIndexOf(".")), scope, primaryKey, _role.getRoleId(), resource_actions);

			ResourcePermissionLocalServiceUtil.setResourcePermissions(companyId,
					SchoolData.class.getName(), scope, primaryKey,
					_role.getRoleId(), resource_model_actions);

			if (_log.isInfoEnabled()) {
				_log.info(
					"Define permission has been assigned for role [ "+_role.getName() + " ]");
			}

		} catch (PortalException e) {
			_log.error(e);
		}
	}

	String[] resource_actions = {"ADD_SCHOOLDATA"};
	String[] resource_model_actions = {ActionKeys.VIEW, ActionKeys.UPDATE};

	private static final Log _log = LogFactoryUtil.getLog(
		SchoolManagementSetupUpgrade.class);

	

	private String _roleName;

}