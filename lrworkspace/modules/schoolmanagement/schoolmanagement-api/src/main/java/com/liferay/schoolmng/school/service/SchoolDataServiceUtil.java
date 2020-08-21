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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for SchoolData. This utility wraps
 * {@link com.liferay.schoolmng.school.service.impl.SchoolDataServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Anjaneya
 * @see SchoolDataService
 * @see com.liferay.schoolmng.school.service.base.SchoolDataServiceBaseImpl
 * @see com.liferay.schoolmng.school.service.impl.SchoolDataServiceImpl
 * @generated
 */
@ProviderType
public class SchoolDataServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.schoolmng.school.service.impl.SchoolDataServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Permission check and then Add Schooldata
	*/
	public static com.liferay.schoolmng.school.model.SchoolData addSchoolData(
		long groupId, String schoolName, String schoolType, String cityName,
		int noOfStudents, int rating,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .addSchoolData(groupId, schoolName, schoolType, cityName,
			noOfStudents, rating, serviceContext);
	}

	/**
	* Permission check and then delete Schooldata
	*/
	public static com.liferay.schoolmng.school.model.SchoolData deleteAssignment(
		long groupId, long schoolId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteAssignment(groupId, schoolId);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
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
	public static com.liferay.schoolmng.school.model.SchoolData updateSchoolData(
		long groupId, long schoolId, String schoolName, String schoolType,
		String cityName, int noOfStudents, int rating,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .updateSchoolData(groupId, schoolId, schoolName, schoolType,
			cityName, noOfStudents, rating, serviceContext);
	}

	public static SchoolDataService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<SchoolDataService, SchoolDataService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(SchoolDataService.class);

		ServiceTracker<SchoolDataService, SchoolDataService> serviceTracker = new ServiceTracker<SchoolDataService, SchoolDataService>(bundle.getBundleContext(),
				SchoolDataService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}