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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.liferay.schoolmng.school.exception.NoSuchSchoolDataException;
import com.liferay.schoolmng.school.model.SchoolData;

/**
 * The persistence interface for the school data service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Anjaneya
 * @see com.liferay.schoolmng.school.service.persistence.impl.SchoolDataPersistenceImpl
 * @see SchoolDataUtil
 * @generated
 */
@ProviderType
public interface SchoolDataPersistence extends BasePersistence<SchoolData> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SchoolDataUtil} to access the school data persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the school datas where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching school datas
	*/
	public java.util.List<SchoolData> findByUuid(String uuid);

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
	public java.util.List<SchoolData> findByUuid(String uuid, int start, int end);

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
	public java.util.List<SchoolData> findByUuid(String uuid, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<SchoolData> orderByComparator);

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
	public java.util.List<SchoolData> findByUuid(String uuid, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<SchoolData> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first school data in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching school data
	* @throws NoSuchSchoolDataException if a matching school data could not be found
	*/
	public SchoolData findByUuid_First(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<SchoolData> orderByComparator)
		throws NoSuchSchoolDataException;

	/**
	* Returns the first school data in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching school data, or <code>null</code> if a matching school data could not be found
	*/
	public SchoolData fetchByUuid_First(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<SchoolData> orderByComparator);

	/**
	* Returns the last school data in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching school data
	* @throws NoSuchSchoolDataException if a matching school data could not be found
	*/
	public SchoolData findByUuid_Last(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<SchoolData> orderByComparator)
		throws NoSuchSchoolDataException;

	/**
	* Returns the last school data in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching school data, or <code>null</code> if a matching school data could not be found
	*/
	public SchoolData fetchByUuid_Last(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<SchoolData> orderByComparator);

	/**
	* Returns the school datas before and after the current school data in the ordered set where uuid = &#63;.
	*
	* @param schoolId the primary key of the current school data
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next school data
	* @throws NoSuchSchoolDataException if a school data with the primary key could not be found
	*/
	public SchoolData[] findByUuid_PrevAndNext(long schoolId, String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<SchoolData> orderByComparator)
		throws NoSuchSchoolDataException;

	/**
	* Removes all the school datas where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(String uuid);

	/**
	* Returns the number of school datas where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching school datas
	*/
	public int countByUuid(String uuid);

	/**
	* Returns the school data where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchSchoolDataException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching school data
	* @throws NoSuchSchoolDataException if a matching school data could not be found
	*/
	public SchoolData findByUUID_G(String uuid, long groupId)
		throws NoSuchSchoolDataException;

	/**
	* Returns the school data where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching school data, or <code>null</code> if a matching school data could not be found
	*/
	public SchoolData fetchByUUID_G(String uuid, long groupId);

	/**
	* Returns the school data where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching school data, or <code>null</code> if a matching school data could not be found
	*/
	public SchoolData fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache);

	/**
	* Removes the school data where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the school data that was removed
	*/
	public SchoolData removeByUUID_G(String uuid, long groupId)
		throws NoSuchSchoolDataException;

	/**
	* Returns the number of school datas where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching school datas
	*/
	public int countByUUID_G(String uuid, long groupId);

	/**
	* Returns all the school datas where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching school datas
	*/
	public java.util.List<SchoolData> findByUuid_C(String uuid, long companyId);

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
	public java.util.List<SchoolData> findByUuid_C(String uuid, long companyId,
		int start, int end);

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
	public java.util.List<SchoolData> findByUuid_C(String uuid, long companyId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SchoolData> orderByComparator);

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
	public java.util.List<SchoolData> findByUuid_C(String uuid, long companyId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SchoolData> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first school data in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching school data
	* @throws NoSuchSchoolDataException if a matching school data could not be found
	*/
	public SchoolData findByUuid_C_First(String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<SchoolData> orderByComparator)
		throws NoSuchSchoolDataException;

	/**
	* Returns the first school data in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching school data, or <code>null</code> if a matching school data could not be found
	*/
	public SchoolData fetchByUuid_C_First(String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<SchoolData> orderByComparator);

	/**
	* Returns the last school data in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching school data
	* @throws NoSuchSchoolDataException if a matching school data could not be found
	*/
	public SchoolData findByUuid_C_Last(String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<SchoolData> orderByComparator)
		throws NoSuchSchoolDataException;

	/**
	* Returns the last school data in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching school data, or <code>null</code> if a matching school data could not be found
	*/
	public SchoolData fetchByUuid_C_Last(String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<SchoolData> orderByComparator);

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
	public SchoolData[] findByUuid_C_PrevAndNext(long schoolId, String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<SchoolData> orderByComparator)
		throws NoSuchSchoolDataException;

	/**
	* Removes all the school datas where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public void removeByUuid_C(String uuid, long companyId);

	/**
	* Returns the number of school datas where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching school datas
	*/
	public int countByUuid_C(String uuid, long companyId);

	/**
	* Caches the school data in the entity cache if it is enabled.
	*
	* @param schoolData the school data
	*/
	public void cacheResult(SchoolData schoolData);

	/**
	* Caches the school datas in the entity cache if it is enabled.
	*
	* @param schoolDatas the school datas
	*/
	public void cacheResult(java.util.List<SchoolData> schoolDatas);

	/**
	* Creates a new school data with the primary key. Does not add the school data to the database.
	*
	* @param schoolId the primary key for the new school data
	* @return the new school data
	*/
	public SchoolData create(long schoolId);

	/**
	* Removes the school data with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param schoolId the primary key of the school data
	* @return the school data that was removed
	* @throws NoSuchSchoolDataException if a school data with the primary key could not be found
	*/
	public SchoolData remove(long schoolId) throws NoSuchSchoolDataException;

	public SchoolData updateImpl(SchoolData schoolData);

	/**
	* Returns the school data with the primary key or throws a {@link NoSuchSchoolDataException} if it could not be found.
	*
	* @param schoolId the primary key of the school data
	* @return the school data
	* @throws NoSuchSchoolDataException if a school data with the primary key could not be found
	*/
	public SchoolData findByPrimaryKey(long schoolId)
		throws NoSuchSchoolDataException;

	/**
	* Returns the school data with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param schoolId the primary key of the school data
	* @return the school data, or <code>null</code> if a school data with the primary key could not be found
	*/
	public SchoolData fetchByPrimaryKey(long schoolId);

	@Override
	public java.util.Map<java.io.Serializable, SchoolData> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the school datas.
	*
	* @return the school datas
	*/
	public java.util.List<SchoolData> findAll();

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
	public java.util.List<SchoolData> findAll(int start, int end);

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
	public java.util.List<SchoolData> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SchoolData> orderByComparator);

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
	public java.util.List<SchoolData> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SchoolData> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the school datas from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of school datas.
	*
	* @return the number of school datas
	*/
	public int countAll();

	@Override
	public java.util.Set<String> getBadColumnNames();
}