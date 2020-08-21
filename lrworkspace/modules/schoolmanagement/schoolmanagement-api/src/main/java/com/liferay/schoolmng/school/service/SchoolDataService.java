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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.BaseService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.spring.osgi.OSGiBeanProperties;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Transactional;

import com.liferay.schoolmng.school.model.SchoolData;

/**
 * Provides the remote service interface for SchoolData. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Anjaneya
 * @see SchoolDataServiceUtil
 * @see com.liferay.schoolmng.school.service.base.SchoolDataServiceBaseImpl
 * @see com.liferay.schoolmng.school.service.impl.SchoolDataServiceImpl
 * @generated
 */
@AccessControlled
@JSONWebService
@OSGiBeanProperties(property =  {
	"json.web.service.context.name=schoolmng", "json.web.service.context.path=SchoolData"}, service = SchoolDataService.class)
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface SchoolDataService extends BaseService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SchoolDataServiceUtil} to access the school data remote service. Add custom service methods to {@link com.liferay.schoolmng.school.service.impl.SchoolDataServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Permission check and then Add Schooldata
	*/
	public SchoolData addSchoolData(long groupId, String schoolName,
		String schoolType, String cityName, int noOfStudents, int rating,
		ServiceContext serviceContext) throws PortalException;

	/**
	* Permission check and then delete Schooldata
	*/
	public SchoolData deleteAssignment(long groupId, long schoolId)
		throws PortalException;

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public String getOSGiServiceIdentifier();

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
	public SchoolData updateSchoolData(long groupId, long schoolId,
		String schoolName, String schoolType, String cityName,
		int noOfStudents, int rating, ServiceContext serviceContext)
		throws PortalException;
}