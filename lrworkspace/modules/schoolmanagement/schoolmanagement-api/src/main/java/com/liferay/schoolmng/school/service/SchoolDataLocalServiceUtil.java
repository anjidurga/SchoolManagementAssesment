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
 * Provides the local service utility for SchoolData. This utility wraps
 * {@link com.liferay.schoolmng.school.service.impl.SchoolDataLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Anjaneya
 * @see SchoolDataLocalService
 * @see com.liferay.schoolmng.school.service.base.SchoolDataLocalServiceBaseImpl
 * @see com.liferay.schoolmng.school.service.impl.SchoolDataLocalServiceImpl
 * @generated
 */
@ProviderType
public class SchoolDataLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.schoolmng.school.service.impl.SchoolDataLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* add SchoolData and Index
	*
	* @param groupId
	* @param schoolName
	* @param cityName
	* @param noOfStudents
	* @param rating
	* @param serviceContext
	* @return
	* @throws PortalException
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
	* Adds the school data to the database. Also notifies the appropriate model listeners.
	*
	* @param schoolData the school data
	* @return the school data that was added
	*/
	public static com.liferay.schoolmng.school.model.SchoolData addSchoolData(
		com.liferay.schoolmng.school.model.SchoolData schoolData) {
		return getService().addSchoolData(schoolData);
	}

	/**
	* Creates a new school data with the primary key. Does not add the school data to the database.
	*
	* @param schoolId the primary key for the new school data
	* @return the new school data
	*/
	public static com.liferay.schoolmng.school.model.SchoolData createSchoolData(
		long schoolId) {
		return getService().createSchoolData(schoolId);
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	/**
	* Deletes the school data with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param schoolId the primary key of the school data
	* @return the school data that was removed
	* @throws PortalException if a school data with the primary key could not be found
	*/
	public static com.liferay.schoolmng.school.model.SchoolData deleteSchoolData(
		long schoolId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteSchoolData(schoolId);
	}

	/**
	* Deletes the school data from the database. Also notifies the appropriate model listeners.
	*
	* @param schoolData the school data
	* @return the school data that was removed
	* @throws PortalException
	*/
	public static com.liferay.schoolmng.school.model.SchoolData deleteSchoolData(
		com.liferay.schoolmng.school.model.SchoolData schoolData)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteSchoolData(schoolData);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.schoolmng.school.model.impl.SchoolDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.schoolmng.school.model.impl.SchoolDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.liferay.schoolmng.school.model.SchoolData fetchSchoolData(
		long schoolId) {
		return getService().fetchSchoolData(schoolId);
	}

	/**
	* Returns the school data matching the UUID and group.
	*
	* @param uuid the school data's UUID
	* @param groupId the primary key of the group
	* @return the matching school data, or <code>null</code> if a matching school data could not be found
	*/
	public static com.liferay.schoolmng.school.model.SchoolData fetchSchoolDataByUuidAndGroupId(
		String uuid, long groupId) {
		return getService().fetchSchoolDataByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the school data with the primary key.
	*
	* @param schoolId the primary key of the school data
	* @return the school data
	* @throws PortalException if a school data with the primary key could not be found
	*/
	public static com.liferay.schoolmng.school.model.SchoolData getSchoolData(
		long schoolId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getSchoolData(schoolId);
	}

	/**
	* Returns the school data matching the UUID and group.
	*
	* @param uuid the school data's UUID
	* @param groupId the primary key of the group
	* @return the matching school data
	* @throws PortalException if a matching school data could not be found
	*/
	public static com.liferay.schoolmng.school.model.SchoolData getSchoolDataByUuidAndGroupId(
		String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getSchoolDataByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the school datas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.schoolmng.school.model.impl.SchoolDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of school datas
	* @param end the upper bound of the range of school datas (not inclusive)
	* @return the range of school datas
	*/
	public static java.util.List<com.liferay.schoolmng.school.model.SchoolData> getSchoolDatas(
		int start, int end) {
		return getService().getSchoolDatas(start, end);
	}

	/**
	* Returns all the school datas matching the UUID and company.
	*
	* @param uuid the UUID of the school datas
	* @param companyId the primary key of the company
	* @return the matching school datas, or an empty list if no matches were found
	*/
	public static java.util.List<com.liferay.schoolmng.school.model.SchoolData> getSchoolDatasByUuidAndCompanyId(
		String uuid, long companyId) {
		return getService().getSchoolDatasByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns a range of school datas matching the UUID and company.
	*
	* @param uuid the UUID of the school datas
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of school datas
	* @param end the upper bound of the range of school datas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching school datas, or an empty list if no matches were found
	*/
	public static java.util.List<com.liferay.schoolmng.school.model.SchoolData> getSchoolDatasByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.schoolmng.school.model.SchoolData> orderByComparator) {
		return getService()
				   .getSchoolDatasByUuidAndCompanyId(uuid, companyId, start,
			end, orderByComparator);
	}

	/**
	* Returns the number of school datas.
	*
	* @return the number of school datas
	*/
	public static int getSchoolDatasCount() {
		return getService().getSchoolDatasCount();
	}

	/**
	* Update SchoolData and Re-index
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

	/**
	* Updates the school data in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param schoolData the school data
	* @return the school data that was updated
	*/
	public static com.liferay.schoolmng.school.model.SchoolData updateSchoolData(
		com.liferay.schoolmng.school.model.SchoolData schoolData) {
		return getService().updateSchoolData(schoolData);
	}

	public static SchoolDataLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<SchoolDataLocalService, SchoolDataLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(SchoolDataLocalService.class);

		ServiceTracker<SchoolDataLocalService, SchoolDataLocalService> serviceTracker =
			new ServiceTracker<SchoolDataLocalService, SchoolDataLocalService>(bundle.getBundleContext(),
				SchoolDataLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}