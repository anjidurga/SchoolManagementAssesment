
package com.liferay.schoolmng.school.service.permission;

import com.liferay.portal.kernel.security.auth.AuthException;
import com.liferay.portal.kernel.security.permission.BaseModelPermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.schoolmng.school.model.SchoolData;

/**
 * SchoolData permission checker interface.
 *
 * @author liferay
 *
 */
public interface SchoolDataPermissionChecker
	extends BaseModelPermissionChecker {

	public static final String ADD_SCHOOLDATA = "ADD_SCHOOLDATA";

	public static final String EDIT_SCHOOLDATA = "EDIT_SCHOOLDATA";

	public static final String RESOURCE_NAME = SchoolData.class.getName();

	public static final String TOP_LEVEL_RESOURCE =
			SchoolData.class.getName().substring(
			0, SchoolData.class.getName().lastIndexOf("."));

	public void check(
			PermissionChecker permissionChecker, long groupId, long schoolId,
			String actionId)
		throws AuthException;

	public void checkTopLevel(
			PermissionChecker permissionChecker, long groupId, String actionId)
		throws AuthException;

	public boolean contains(
		PermissionChecker permissionChecker, long groupId, long schoolId,
		String actionId);

	public boolean containsTopLevel(
		PermissionChecker permissionChecker, long groupId, String actionId);

}