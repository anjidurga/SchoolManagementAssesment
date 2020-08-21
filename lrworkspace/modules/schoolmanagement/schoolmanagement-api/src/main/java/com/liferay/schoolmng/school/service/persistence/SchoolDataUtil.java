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

package com.liferay.schoolmng.school.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.liferay.schoolmng.school.model.SchoolData;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the school data service. This utility wraps {@link com.liferay.schoolmng.school.service.persistence.impl.SchoolDataPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Anjaneya
 * @see SchoolDataPersistence
 * @see com.liferay.schoolmng.school.service.persistence.impl.SchoolDataPersistenceImpl
 * @generated
 */
@ProviderType
public class SchoolDataUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(SchoolData schoolData) {
		getPersistence().clearCache(schoolData);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<SchoolData> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SchoolData> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SchoolData> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<SchoolData> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static SchoolData update(SchoolData schoolData) {
		return getPersistence().update(schoolData);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static SchoolData update(SchoolData schoolData,
		ServiceContext serviceContext) {
		return getPersistence().update(schoolData, serviceContext);
	}

	/**
	* Returns all the school datas where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching school datas
	*/
	public static List<SchoolData> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the school datas where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SchoolDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of school datas
	* @param end the upper bound of the range of school datas (not inclusive)
	* @return the range of matching school datas
	*/
	public static List<SchoolData> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the school datas where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SchoolDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of school datas
	* @param end the upper bound of the range of school datas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching school datas
	*/
	public static List<SchoolData> findByUuid(String uuid, int start, int end,
		OrderByComparator<SchoolData> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the school datas where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SchoolDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of school datas
	* @param end the upper bound of the range of school datas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching school datas
	*/
	public static List<SchoolData> findByUuid(String uuid, int start, int end,
		OrderByComparator<SchoolData> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first school data in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching school data
	* @throws NoSuchSchoolDataException if a matching school data could not be found
	*/
	public static SchoolData findByUuid_First(String uuid,
		OrderByComparator<SchoolData> orderByComparator)
		throws com.liferay.schoolmng.school.exception.NoSuchSchoolDataException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first school data in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching school data, or <code>null</code> if a matching school data could not be found
	*/
	public static SchoolData fetchByUuid_First(String uuid,
		OrderByComparator<SchoolData> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last school data in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching school data
	* @throws NoSuchSchoolDataException if a matching school data could not be found
	*/
	public static SchoolData findByUuid_Last(String uuid,
		OrderByComparator<SchoolData> orderByComparator)
		throws com.liferay.schoolmng.school.exception.NoSuchSchoolDataException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last school data in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching school data, or <code>null</code> if a matching school data could not be found
	*/
	public static SchoolData fetchByUuid_Last(String uuid,
		OrderByComparator<SchoolData> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the school datas before and after the current school data in the ordered set where uuid = &#63;.
	*
	* @param schoolId the primary key of the current school data
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next school data
	* @throws NoSuchSchoolDataException if a school data with the primary key could not be found
	*/
	public static SchoolData[] findByUuid_PrevAndNext(long schoolId,
		String uuid, OrderByComparator<SchoolData> orderByComparator)
		throws com.liferay.schoolmng.school.exception.NoSuchSchoolDataException {
		return getPersistence()
				   .findByUuid_PrevAndNext(schoolId, uuid, orderByComparator);
	}

	/**
	* Removes all the school datas where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of school datas where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching school datas
	*/
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the school data where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchSchoolDataException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching school data
	* @throws NoSuchSchoolDataException if a matching school data could not be found
	*/
	public static SchoolData findByUUID_G(String uuid, long groupId)
		throws com.liferay.schoolmng.school.exception.NoSuchSchoolDataException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the school data where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching school data, or <code>null</code> if a matching school data could not be found
	*/
	public static SchoolData fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the school data where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching school data, or <code>null</code> if a matching school data could not be found
	*/
	public static SchoolData fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the school data where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the school data that was removed
	*/
	public static SchoolData removeByUUID_G(String uuid, long groupId)
		throws com.liferay.schoolmng.school.exception.NoSuchSchoolDataException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of school datas where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching school datas
	*/
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the school datas where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching school datas
	*/
	public static List<SchoolData> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the school datas where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SchoolDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of school datas
	* @param end the upper bound of the range of school datas (not inclusive)
	* @return the range of matching school datas
	*/
	public static List<SchoolData> findByUuid_C(String uuid, long companyId,
		int start, int end) {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the school datas where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SchoolDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of school datas
	* @param end the upper bound of the range of school datas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching school datas
	*/
	public static List<SchoolData> findByUuid_C(String uuid, long companyId,
		int start, int end, OrderByComparator<SchoolData> orderByComparator) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the school datas where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SchoolDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of school datas
	* @param end the upper bound of the range of school datas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching school datas
	*/
	public static List<SchoolData> findByUuid_C(String uuid, long companyId,
		int start, int end, OrderByComparator<SchoolData> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first school data in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching school data
	* @throws NoSuchSchoolDataException if a matching school data could not be found
	*/
	public static SchoolData findByUuid_C_First(String uuid, long companyId,
		OrderByComparator<SchoolData> orderByComparator)
		throws com.liferay.schoolmng.school.exception.NoSuchSchoolDataException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first school data in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching school data, or <code>null</code> if a matching school data could not be found
	*/
	public static SchoolData fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator<SchoolData> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last school data in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching school data
	* @throws NoSuchSchoolDataException if a matching school data could not be found
	*/
	public static SchoolData findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<SchoolData> orderByComparator)
		throws com.liferay.schoolmng.school.exception.NoSuchSchoolDataException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last school data in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching school data, or <code>null</code> if a matching school data could not be found
	*/
	public static SchoolData fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<SchoolData> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the school datas before and after the current school data in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param schoolId the primary key of the current school data
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next school data
	* @throws NoSuchSchoolDataException if a school data with the primary key could not be found
	*/
	public static SchoolData[] findByUuid_C_PrevAndNext(long schoolId,
		String uuid, long companyId,
		OrderByComparator<SchoolData> orderByComparator)
		throws com.liferay.schoolmng.school.exception.NoSuchSchoolDataException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(schoolId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the school datas where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of school datas where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching school datas
	*/
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Caches the school data in the entity cache if it is enabled.
	*
	* @param schoolData the school data
	*/
	public static void cacheResult(SchoolData schoolData) {
		getPersistence().cacheResult(schoolData);
	}

	/**
	* Caches the school datas in the entity cache if it is enabled.
	*
	* @param schoolDatas the school datas
	*/
	public static void cacheResult(List<SchoolData> schoolDatas) {
		getPersistence().cacheResult(schoolDatas);
	}

	/**
	* Creates a new school data with the primary key. Does not add the school data to the database.
	*
	* @param schoolId the primary key for the new school data
	* @return the new school data
	*/
	public static SchoolData create(long schoolId) {
		return getPersistence().create(schoolId);
	}

	/**
	* Removes the school data with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param schoolId the primary key of the school data
	* @return the school data that was removed
	* @throws NoSuchSchoolDataException if a school data with the primary key could not be found
	*/
	public static SchoolData remove(long schoolId)
		throws com.liferay.schoolmng.school.exception.NoSuchSchoolDataException {
		return getPersistence().remove(schoolId);
	}

	public static SchoolData updateImpl(SchoolData schoolData) {
		return getPersistence().updateImpl(schoolData);
	}

	/**
	* Returns the school data with the primary key or throws a {@link NoSuchSchoolDataException} if it could not be found.
	*
	* @param schoolId the primary key of the school data
	* @return the school data
	* @throws NoSuchSchoolDataException if a school data with the primary key could not be found
	*/
	public static SchoolData findByPrimaryKey(long schoolId)
		throws com.liferay.schoolmng.school.exception.NoSuchSchoolDataException {
		return getPersistence().findByPrimaryKey(schoolId);
	}

	/**
	* Returns the school data with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param schoolId the primary key of the school data
	* @return the school data, or <code>null</code> if a school data with the primary key could not be found
	*/
	public static SchoolData fetchByPrimaryKey(long schoolId) {
		return getPersistence().fetchByPrimaryKey(schoolId);
	}

	public static java.util.Map<java.io.Serializable, SchoolData> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the school datas.
	*
	* @return the school datas
	*/
	public static List<SchoolData> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the school datas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SchoolDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of school datas
	* @param end the upper bound of the range of school datas (not inclusive)
	* @return the range of school datas
	*/
	public static List<SchoolData> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the school datas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SchoolDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of school datas
	* @param end the upper bound of the range of school datas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of school datas
	*/
	public static List<SchoolData> findAll(int start, int end,
		OrderByComparator<SchoolData> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the school datas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SchoolDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of school datas
	* @param end the upper bound of the range of school datas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of school datas
	*/
	public static List<SchoolData> findAll(int start, int end,
		OrderByComparator<SchoolData> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the school datas from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of school datas.
	*
	* @return the number of school datas
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static SchoolDataPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<SchoolDataPersistence, SchoolDataPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(SchoolDataPersistence.class);

		ServiceTracker<SchoolDataPersistence, SchoolDataPersistence> serviceTracker =
			new ServiceTracker<SchoolDataPersistence, SchoolDataPersistence>(bundle.getBundleContext(),
				SchoolDataPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}