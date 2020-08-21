/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.schoolmng.school.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.spring.extender.service.ServiceReference;
import com.liferay.schoolmng.school.model.SchoolData;
import com.liferay.schoolmng.school.service.base.SchoolDataServiceBaseImpl;
import com.liferay.schoolmng.school.service.permission.SchoolDataPermissionChecker;

/**
 * The implementation of the school data remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.schoolmng.school.service.SchoolDataService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Anjaneya
 * @see SchoolDataServiceBaseImpl
 * @see com.liferay.schoolmng.school.service.SchoolDataServiceUtil
 */
public class SchoolDataServiceImpl extends SchoolDataServiceBaseImpl {

	/**
	 * Permission check and then Add Schooldata
	 */
	public SchoolData addSchoolData(long groupId, String schoolName, String schoolType, String cityName,
			int noOfStudents, int rating,
			ServiceContext serviceContext) throws PortalException {

		// Check permissions

		_log.info(
			"SB Entered  : addSchoolData GroupId =" + serviceContext.getScopeGroupId());

		_schoolDataPermissionChecker.checkTopLevel(getPermissionChecker(), serviceContext.getScopeGroupId(),
			SchoolDataPermissionChecker.ADD_SCHOOLDATA);

		return schoolDataLocalService.addSchoolData(groupId, schoolName, schoolType, cityName, noOfStudents, rating,
			serviceContext);
	}

	/**
	 * Permission check and then delete Schooldata
	 */
	public SchoolData deleteAssignment(long groupId, long schoolId)
		throws PortalException {

		// Check permissions.

		_schoolDataPermissionChecker.check(
			getPermissionChecker(), groupId, schoolId, ActionKeys.UPDATE);

		return schoolDataLocalService.deleteSchoolData(schoolId);
	}

	/**
	 * Permission check and then update Schooldata
	 *
	 * @param groupId
	 * @param schoolId
	 * @param schoolName
	 * @param schoolType
	 * @param cityName
	 * @param noOfStudents
	 * @param rating
	 * @param serviceContext
	 * @return
	 * @throws PortalException
	 */
	public SchoolData updateSchoolData(long groupId, long schoolId, String schoolName, String schoolType,
			String cityName, int noOfStudents, int rating,
			ServiceContext serviceContext) throws PortalException {

		// Check permissions

		boolean isEditPer = _schoolDataPermissionChecker.contains(getPermissionChecker(), groupId, schoolId,
			ActionKeys.UPDATE);

		System.out.println("isEditPer service >>>>>> " + isEditPer);
		_schoolDataPermissionChecker.check(
			getPermissionChecker(), groupId, schoolId, ActionKeys.UPDATE);

		return schoolDataLocalService.updateSchoolData(groupId, schoolId, schoolName, schoolType, cityName,
			noOfStudents, rating, serviceContext);
	}

	private static final Log _log = LogFactoryUtil.getLog(
		SchoolDataLocalServiceImpl.class);

	@ServiceReference(type = SchoolDataPermissionChecker.class)
	private SchoolDataPermissionChecker _schoolDataPermissionChecker;

}