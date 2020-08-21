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
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

import com.liferay.schoolmng.school.service.SchoolDataServiceUtil;

/**
 * Provides the HTTP utility for the
 * {@link SchoolDataServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * {@link HttpPrincipal} parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Anjaneya
 * @see SchoolDataServiceSoap
 * @see HttpPrincipal
 * @see SchoolDataServiceUtil
 * @generated
 */
@ProviderType
public class SchoolDataServiceHttp {
	public static com.liferay.schoolmng.school.model.SchoolData addSchoolData(
		HttpPrincipal httpPrincipal, long groupId, String schoolName,
		String schoolType, String cityName, int noOfStudents, int rating,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(SchoolDataServiceUtil.class,
					"addSchoolData", _addSchoolDataParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(methodKey, groupId,
					schoolName, schoolType, cityName, noOfStudents, rating,
					serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (com.liferay.schoolmng.school.model.SchoolData)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static com.liferay.schoolmng.school.model.SchoolData deleteAssignment(
		HttpPrincipal httpPrincipal, long groupId, long schoolId)
		throws com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(SchoolDataServiceUtil.class,
					"deleteAssignment", _deleteAssignmentParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(methodKey, groupId,
					schoolId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (com.liferay.schoolmng.school.model.SchoolData)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static com.liferay.schoolmng.school.model.SchoolData updateSchoolData(
		HttpPrincipal httpPrincipal, long groupId, long schoolId,
		String schoolName, String schoolType, String cityName,
		int noOfStudents, int rating,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(SchoolDataServiceUtil.class,
					"updateSchoolData", _updateSchoolDataParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(methodKey, groupId,
					schoolId, schoolName, schoolType, cityName, noOfStudents,
					rating, serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (com.liferay.schoolmng.school.model.SchoolData)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(SchoolDataServiceHttp.class);
	private static final Class<?>[] _addSchoolDataParameterTypes0 = new Class[] {
			long.class, String.class, String.class, String.class, int.class,
			int.class, com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _deleteAssignmentParameterTypes1 = new Class[] {
			long.class, long.class
		};
	private static final Class<?>[] _updateSchoolDataParameterTypes2 = new Class[] {
			long.class, long.class, String.class, String.class, String.class,
			int.class, int.class,
			com.liferay.portal.kernel.service.ServiceContext.class
		};
}