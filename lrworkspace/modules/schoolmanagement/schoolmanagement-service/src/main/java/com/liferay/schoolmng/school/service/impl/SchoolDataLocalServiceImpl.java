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
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.schoolmng.school.model.SchoolData;
import com.liferay.schoolmng.school.service.base.SchoolDataLocalServiceBaseImpl;
import com.liferay.schoolmng.school.service.validation.SchoolDataValidator;

import java.util.Date;

/**
 * The implementation of the school data local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.schoolmng.school.service.SchoolDataLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Anjaneya
 * @see SchoolDataLocalServiceBaseImpl
 * @see com.liferay.schoolmng.school.service.SchoolDataLocalServiceUtil
 */
	public class SchoolDataLocalServiceImpl
		extends SchoolDataLocalServiceBaseImpl {

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
	@Indexable(type = IndexableType.REINDEX)
	public SchoolData addSchoolData(long groupId, String schoolName, String schoolType, String cityName,
			int noOfStudents, int rating,
			ServiceContext serviceContext) throws PortalException {
		Group group = GroupLocalServiceUtil.getGroup(groupId);
		long userId = serviceContext.getUserId();
		User user = userLocalService.getUser(userId);
		

		if (_log.isTraceEnabled()) {
			_log.trace("Entered  : addSchoolData in SchoolDataLocalServiceImpl");
		}
		
		if (_log.isDebugEnabled()) {
			_log.debug(" Values to insert in service Layer  : "
					+ "schoolName =[ "+schoolName + " ]"+
					"schoolType =[ "+schoolType + " ]"+
					"city =[ "+cityName + " ]"+
					"noOfStudents =[ "+noOfStudents + " ]"+
					"rating =[ "+rating + " ]");
		}

		// Validate the data

		SchoolDataValidator.validate(schoolName, schoolType, cityName);

		if (_log.isTraceEnabled()) {
			_log.trace("Validation  : Entered inputs are valid");
		}
		
		long schoolId = counterLocalService.increment(
			SchoolData.class.getName());

		// Create SchoolData

		SchoolData schoolData = createSchoolData(schoolId);

		schoolData.setCompanyId(group.getCompanyId());
		schoolData.setGroupId(groupId);
		schoolData.setUserId(userId);

		schoolData.setSchoolName(schoolName);
		schoolData.setSchoolType(schoolType);
		schoolData.setCity(cityName);
		schoolData.setNoOfStudents(noOfStudents);
		schoolData.setRating(rating);
		schoolData.setUserName(user.getScreenName());

		schoolData.setCreateDate(serviceContext.getCreateDate(new Date()));
		schoolData.setModifiedDate(serviceContext.getModifiedDate(new Date()));

		schoolData = super.addSchoolData(schoolData);
		
		if (_log.isTraceEnabled()) {
			_log.trace("School data [ "+schoolData.getSchoolId() + "] has been created");
		}

		// Add permission resources.

		boolean portletActions = false;
		boolean addGroupPermissions = true;
		boolean addGuestPermissions = true;
		
		
		resourceLocalService.addResources(group.getCompanyId(), groupId, userId, SchoolData.class.getName(),
				schoolData.getSchoolId(), portletActions, addGroupPermissions,
				addGuestPermissions);
		
		if (_log.isTraceEnabled()) {
			_log.trace("School data [ "+schoolData.getSchoolId() + "] has been added into resource table");
		}
		// Add to Asset framework.

		updateAsset(schoolData, serviceContext);
		
		if (_log.isTraceEnabled()) {
			_log.trace("School data [ "+schoolData.getSchoolId() + "] has been added into Asset table");
		}

		return schoolData;
	}

	/**
	 * Adds an addSchoolData (silenced) *
	 *
	 * @param assignment
	 * @return
	 */
	@Override
	public SchoolData addSchoolData(SchoolData schoolData) {

		throw new UnsupportedOperationException(
				"please use instead addSchoolData(long groupId, String schoolName, String schoolType, " +
						"String cityName, int noOfStudents, float rating,\n" +
						"   ServiceContext serviceContext)");
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
	@Indexable(type = IndexableType.REINDEX)
	public SchoolData updateSchoolData(long groupId, long schoolId, String schoolName, String schoolType,
			String cityName, int noOfStudents, int rating,
			ServiceContext serviceContext) throws PortalException {
		long userId = serviceContext.getUserId();
		User user = userLocalService.getUser(userId);

		// Get SchoolData
		
		if (_log.isTraceEnabled()) {
			_log.trace("Enter updateSchoolData : School data for edit is = [ "+schoolId + "] ");
		}
		
		if (_log.isDebugEnabled()) {
			_log.debug(" Values to Update in service Layer  is : "
					+ "schoolName =[ "+schoolName + " ]"+
					"schoolType =[ "+schoolType + " ]"+
					"city =[ "+cityName + " ]"+
					"noOfStudents =[ "+noOfStudents + " ]"+
					"rating =[ "+rating + " ]");
		}

		SchoolData schoolData = getSchoolData(schoolId);

		schoolData.setGroupId(groupId);
		schoolData.setUserId(userId);

		schoolData.setSchoolName(schoolName);
		schoolData.setSchoolType(schoolType);
		schoolData.setCity(cityName);
		schoolData.setNoOfStudents(noOfStudents);
		schoolData.setRating(rating);
		schoolData.setUserName(user.getScreenName());
		schoolData.setModifiedDate(serviceContext.getModifiedDate(new Date()));

		schoolData = super.updateSchoolData(schoolData);

		if (_log.isTraceEnabled()) {
			_log.trace("School data = [ "+schoolId + "] has been updated successfully");
		}
		
		// Update the Asset table
		
		updateAsset(schoolData, serviceContext);
		
		if (_log.isTraceEnabled()) {
			_log.trace("School data = [ "+schoolId + "] has been updated in Asset table successfully");
		}

		return schoolData;
	}

	/**
	 * Delete SchoolData and delete from Index.
	 *
	 * @param assignmentId
	 * @return
	 * @throws PortalException
	 */
	@Indexable(type = IndexableType.DELETE)
	public SchoolData deleteSchoolData(long schoolId) throws PortalException {

		SchoolData schoolData = getSchoolData(schoolId);

		return deleteSchoolData(schoolData);
	}

	/**
	 * Delete SchoolData and delete from Index.
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
	@Indexable(type = IndexableType.DELETE)
	public SchoolData deleteSchoolData(SchoolData schoolData)
		throws PortalException {
		_log.info("SB : Deleting SchoolObje " + schoolData.getSchoolId());

		// Delete permission resources.

		resourceLocalService.deleteResource(
			schoolData, ResourceConstants.SCOPE_INDIVIDUAL);

		// Delete from Asset framework

		assetEntryLocalService.deleteEntry(
			SchoolData.class.getName(), schoolData.getSchoolId());

		return super.deleteSchoolData(schoolData);
	}

	/**
	 * Add SchoolData to Asset framework
	 *
	 * @param assignment
	 * @param serviceContext
	 * @throws PortalException
	 */
	private void updateAsset(
			SchoolData assignment, ServiceContext serviceContext)
		throws PortalException {

		assetEntryLocalService.updateEntry(serviceContext.getUserId(), serviceContext.getScopeGroupId(),
				assignment.getCreateDate(), assignment.getModifiedDate(),
				SchoolData.class.getName(), assignment.getSchoolId(),
				assignment.getUuid(), 0, serviceContext.getAssetCategoryIds(),
				serviceContext.getAssetTagNames(), true, true,
				assignment.getCreateDate(), null, null, null,
				ContentTypes.TEXT_HTML, assignment.getSchoolName(),
				assignment.getCity(), null, null, null, 0, 0,
				serviceContext.getAssetPriority());
	}

	private static final Log _log = LogFactoryUtil.getLog(
		SchoolDataLocalServiceImpl.class);

}