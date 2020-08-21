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

package com.liferay.schoolmng.school.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SchoolDataService}.
 *
 * @author Anjaneya
 * @see SchoolDataService
 * @generated
 */
@ProviderType
public class SchoolDataServiceWrapper implements SchoolDataService,
	ServiceWrapper<SchoolDataService> {
	public SchoolDataServiceWrapper(SchoolDataService schoolDataService) {
		_schoolDataService = schoolDataService;
	}

	/**
	* Permission check and then Add Schooldata
	*/
	@Override
	public com.liferay.schoolmng.school.model.SchoolData addSchoolData(
		long groupId, String schoolName, String schoolType, String cityName,
		int noOfStudents, int rating,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _schoolDataService.addSchoolData(groupId, schoolName,
			schoolType, cityName, noOfStudents, rating, serviceContext);
	}

	/**
	* Permission check and then delete Schooldata
	*/
	@Override
	public com.liferay.schoolmng.school.model.SchoolData deleteAssignment(
		long groupId, long schoolId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _schoolDataService.deleteAssignment(groupId, schoolId);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _schoolDataService.getOSGiServiceIdentifier();
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
	@Override
	public com.liferay.schoolmng.school.model.SchoolData updateSchoolData(
		long groupId, long schoolId, String schoolName, String schoolType,
		String cityName, int noOfStudents, int rating,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _schoolDataService.updateSchoolData(groupId, schoolId,
			schoolName, schoolType, cityName, noOfStudents, rating,
			serviceContext);
	}

	@Override
	public SchoolDataService getWrappedService() {
		return _schoolDataService;
	}

	@Override
	public void setWrappedService(SchoolDataService schoolDataService) {
		_schoolDataService = schoolDataService;
	}

	private SchoolDataService _schoolDataService;
}