package com.liferay.schoolmng.school.service.permission.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.auth.AuthException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.schoolmng.school.service.permission.SchoolDataPermissionChecker;

import org.osgi.service.component.annotations.Component;

/**
 * SchoolData permission checker implementation.
 *
 * @author Anjaneya
 *
 */
@Component(
		immediate = true,
		property = "model.class.name=com.liferay.schoolmng.school.model.SchoolData",
		service = SchoolDataPermissionChecker.class
	)
public class SchoolDataPermissionCheckerImpl
	implements SchoolDataPermissionChecker {

	@Override
	public void check(
			PermissionChecker permissionChecker, long groupId, long schoolId,
			String actionId)
		throws AuthException {
		if (!contains(permissionChecker, groupId, schoolId, actionId)) {
			throw new AuthException();
		}
	}

	@Override
	public void checkBaseModel(
			PermissionChecker permissionChecker, long groupId, long primaryKey,
			String actionId)
		throws PortalException {

		check(permissionChecker, groupId, primaryKey, actionId);
	}

	@Override
	public void checkTopLevel(
			PermissionChecker permissionChecker, long groupId, String actionId)
		throws AuthException {

		if (!containsTopLevel(permissionChecker, groupId, actionId)) {
			throw new AuthException();
		}
	}

	@Override
	public boolean contains(
		PermissionChecker permissionChecker, long groupId, long schoolId,
		String actionId) {

		return (permissionChecker.hasPermission(groupId, RESOURCE_NAME, schoolId, actionId));
	}

	@Override
	public boolean containsTopLevel(
		PermissionChecker permissionChecker, long groupId, String actionId) {

		return (permissionChecker.hasPermission(groupId, TOP_LEVEL_RESOURCE, groupId, actionId));
	}

}