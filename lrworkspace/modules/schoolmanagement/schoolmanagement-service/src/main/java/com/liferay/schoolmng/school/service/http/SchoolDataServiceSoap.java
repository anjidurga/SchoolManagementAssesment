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

package com.liferay.schoolmng.school.service.http;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.liferay.schoolmng.school.service.SchoolDataServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link SchoolDataServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.liferay.schoolmng.school.model.SchoolDataSoap}.
 * If the method in the service utility returns a
 * {@link com.liferay.schoolmng.school.model.SchoolData}, that is translated to a
 * {@link com.liferay.schoolmng.school.model.SchoolDataSoap}. Methods that SOAP cannot
 * safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Anjaneya
 * @see SchoolDataServiceHttp
 * @see com.liferay.schoolmng.school.model.SchoolDataSoap
 * @see SchoolDataServiceUtil
 * @generated
 */
@ProviderType
public class SchoolDataServiceSoap {
	/**
	* Permission check and then Add Schooldata
	*/
	public static com.liferay.schoolmng.school.model.SchoolDataSoap addSchoolData(
		long groupId, String schoolName, String schoolType, String cityName,
		int noOfStudents, int rating,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			com.liferay.schoolmng.school.model.SchoolData returnValue = SchoolDataServiceUtil.addSchoolData(groupId,
					schoolName, schoolType, cityName, noOfStudents, rating,
					serviceContext);

			return com.liferay.schoolmng.school.model.SchoolDataSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	/**
	* Permission check and then delete Schooldata
	*/
	public static com.liferay.schoolmng.school.model.SchoolDataSoap deleteAssignment(
		long groupId, long schoolId) throws RemoteException {
		try {
			com.liferay.schoolmng.school.model.SchoolData returnValue = SchoolDataServiceUtil.deleteAssignment(groupId,
					schoolId);

			return com.liferay.schoolmng.school.model.SchoolDataSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
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
	public static com.liferay.schoolmng.school.model.SchoolDataSoap updateSchoolData(
		long groupId, long schoolId, String schoolName, String schoolType,
		String cityName, int noOfStudents, int rating,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			com.liferay.schoolmng.school.model.SchoolData returnValue = SchoolDataServiceUtil.updateSchoolData(groupId,
					schoolId, schoolName, schoolType, cityName, noOfStudents,
					rating, serviceContext);

			return com.liferay.schoolmng.school.model.SchoolDataSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(SchoolDataServiceSoap.class);
}