package com.liferay.schoolmng.content.setup.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.RoleConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;

import java.util.List;

public class ContentSetupUtil {

	public static User getUserAdmin(long companyId) {
		Role adminRole = RoleLocalServiceUtil.fetchRole(
			companyId, RoleConstants.ADMINISTRATOR);

		if (adminRole == null) {
			_log.error("No Such role exits : " + RoleConstants.ADMINISTRATOR);

			return null;
		}

		List<User> users = UserLocalServiceUtil.getRoleUsers(
			adminRole.getRoleId());

		User admin = users.get(0);

		return admin;
	}

	private static final Log _log = LogFactoryUtil.getLog(
		ContentSetupUtil.class);

}