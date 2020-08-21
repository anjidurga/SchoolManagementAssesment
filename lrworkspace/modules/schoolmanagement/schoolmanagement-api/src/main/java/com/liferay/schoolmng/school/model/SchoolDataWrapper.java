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

package com.liferay.schoolmng.school.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link SchoolData}.
 * </p>
 *
 * @author Anjaneya
 * @see SchoolData
 * @generated
 */
@ProviderType
public class SchoolDataWrapper implements SchoolData, ModelWrapper<SchoolData> {
	public SchoolDataWrapper(SchoolData schoolData) {
		_schoolData = schoolData;
	}

	@Override
	public Class<?> getModelClass() {
		return SchoolData.class;
	}

	@Override
	public String getModelClassName() {
		return SchoolData.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("schoolId", getSchoolId());
		attributes.put("groupId", getGroupId());
		attributes.put("schoolName", getSchoolName());
		attributes.put("schoolType", getSchoolType());
		attributes.put("city", getCity());
		attributes.put("noOfStudents", getNoOfStudents());
		attributes.put("rating", getRating());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long schoolId = (Long)attributes.get("schoolId");

		if (schoolId != null) {
			setSchoolId(schoolId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		String schoolName = (String)attributes.get("schoolName");

		if (schoolName != null) {
			setSchoolName(schoolName);
		}

		String schoolType = (String)attributes.get("schoolType");

		if (schoolType != null) {
			setSchoolType(schoolType);
		}

		String city = (String)attributes.get("city");

		if (city != null) {
			setCity(city);
		}

		Integer noOfStudents = (Integer)attributes.get("noOfStudents");

		if (noOfStudents != null) {
			setNoOfStudents(noOfStudents);
		}

		Integer rating = (Integer)attributes.get("rating");

		if (rating != null) {
			setRating(rating);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	@Override
	public Object clone() {
		return new SchoolDataWrapper((SchoolData)_schoolData.clone());
	}

	@Override
	public int compareTo(SchoolData schoolData) {
		return _schoolData.compareTo(schoolData);
	}

	/**
	* Returns the city of this school data.
	*
	* @return the city of this school data
	*/
	@Override
	public String getCity() {
		return _schoolData.getCity();
	}

	/**
	* Returns the company ID of this school data.
	*
	* @return the company ID of this school data
	*/
	@Override
	public long getCompanyId() {
		return _schoolData.getCompanyId();
	}

	/**
	* Returns the create date of this school data.
	*
	* @return the create date of this school data
	*/
	@Override
	public Date getCreateDate() {
		return _schoolData.getCreateDate();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _schoolData.getExpandoBridge();
	}

	/**
	* Returns the group ID of this school data.
	*
	* @return the group ID of this school data
	*/
	@Override
	public long getGroupId() {
		return _schoolData.getGroupId();
	}

	/**
	* Returns the modified date of this school data.
	*
	* @return the modified date of this school data
	*/
	@Override
	public Date getModifiedDate() {
		return _schoolData.getModifiedDate();
	}

	/**
	* Returns the no of students of this school data.
	*
	* @return the no of students of this school data
	*/
	@Override
	public int getNoOfStudents() {
		return _schoolData.getNoOfStudents();
	}

	/**
	* Returns the primary key of this school data.
	*
	* @return the primary key of this school data
	*/
	@Override
	public long getPrimaryKey() {
		return _schoolData.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _schoolData.getPrimaryKeyObj();
	}

	/**
	* Returns the rating of this school data.
	*
	* @return the rating of this school data
	*/
	@Override
	public int getRating() {
		return _schoolData.getRating();
	}

	/**
	* Returns the school ID of this school data.
	*
	* @return the school ID of this school data
	*/
	@Override
	public long getSchoolId() {
		return _schoolData.getSchoolId();
	}

	/**
	* Returns the school name of this school data.
	*
	* @return the school name of this school data
	*/
	@Override
	public String getSchoolName() {
		return _schoolData.getSchoolName();
	}

	/**
	* Returns the school type of this school data.
	*
	* @return the school type of this school data
	*/
	@Override
	public String getSchoolType() {
		return _schoolData.getSchoolType();
	}

	/**
	* Returns the user ID of this school data.
	*
	* @return the user ID of this school data
	*/
	@Override
	public long getUserId() {
		return _schoolData.getUserId();
	}

	/**
	* Returns the user name of this school data.
	*
	* @return the user name of this school data
	*/
	@Override
	public String getUserName() {
		return _schoolData.getUserName();
	}

	/**
	* Returns the user uuid of this school data.
	*
	* @return the user uuid of this school data
	*/
	@Override
	public String getUserUuid() {
		return _schoolData.getUserUuid();
	}

	/**
	* Returns the uuid of this school data.
	*
	* @return the uuid of this school data
	*/
	@Override
	public String getUuid() {
		return _schoolData.getUuid();
	}

	@Override
	public int hashCode() {
		return _schoolData.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _schoolData.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _schoolData.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _schoolData.isNew();
	}

	@Override
	public void persist() {
		_schoolData.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_schoolData.setCachedModel(cachedModel);
	}

	/**
	* Sets the city of this school data.
	*
	* @param city the city of this school data
	*/
	@Override
	public void setCity(String city) {
		_schoolData.setCity(city);
	}

	/**
	* Sets the company ID of this school data.
	*
	* @param companyId the company ID of this school data
	*/
	@Override
	public void setCompanyId(long companyId) {
		_schoolData.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this school data.
	*
	* @param createDate the create date of this school data
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_schoolData.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_schoolData.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_schoolData.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_schoolData.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this school data.
	*
	* @param groupId the group ID of this school data
	*/
	@Override
	public void setGroupId(long groupId) {
		_schoolData.setGroupId(groupId);
	}

	/**
	* Sets the modified date of this school data.
	*
	* @param modifiedDate the modified date of this school data
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_schoolData.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_schoolData.setNew(n);
	}

	/**
	* Sets the no of students of this school data.
	*
	* @param noOfStudents the no of students of this school data
	*/
	@Override
	public void setNoOfStudents(int noOfStudents) {
		_schoolData.setNoOfStudents(noOfStudents);
	}

	/**
	* Sets the primary key of this school data.
	*
	* @param primaryKey the primary key of this school data
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_schoolData.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_schoolData.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the rating of this school data.
	*
	* @param rating the rating of this school data
	*/
	@Override
	public void setRating(int rating) {
		_schoolData.setRating(rating);
	}

	/**
	* Sets the school ID of this school data.
	*
	* @param schoolId the school ID of this school data
	*/
	@Override
	public void setSchoolId(long schoolId) {
		_schoolData.setSchoolId(schoolId);
	}

	/**
	* Sets the school name of this school data.
	*
	* @param schoolName the school name of this school data
	*/
	@Override
	public void setSchoolName(String schoolName) {
		_schoolData.setSchoolName(schoolName);
	}

	/**
	* Sets the school type of this school data.
	*
	* @param schoolType the school type of this school data
	*/
	@Override
	public void setSchoolType(String schoolType) {
		_schoolData.setSchoolType(schoolType);
	}

	/**
	* Sets the user ID of this school data.
	*
	* @param userId the user ID of this school data
	*/
	@Override
	public void setUserId(long userId) {
		_schoolData.setUserId(userId);
	}

	/**
	* Sets the user name of this school data.
	*
	* @param userName the user name of this school data
	*/
	@Override
	public void setUserName(String userName) {
		_schoolData.setUserName(userName);
	}

	/**
	* Sets the user uuid of this school data.
	*
	* @param userUuid the user uuid of this school data
	*/
	@Override
	public void setUserUuid(String userUuid) {
		_schoolData.setUserUuid(userUuid);
	}

	/**
	* Sets the uuid of this school data.
	*
	* @param uuid the uuid of this school data
	*/
	@Override
	public void setUuid(String uuid) {
		_schoolData.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<SchoolData> toCacheModel() {
		return _schoolData.toCacheModel();
	}

	@Override
	public SchoolData toEscapedModel() {
		return new SchoolDataWrapper(_schoolData.toEscapedModel());
	}

	@Override
	public String toString() {
		return _schoolData.toString();
	}

	@Override
	public SchoolData toUnescapedModel() {
		return new SchoolDataWrapper(_schoolData.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _schoolData.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SchoolDataWrapper)) {
			return false;
		}

		SchoolDataWrapper schoolDataWrapper = (SchoolDataWrapper)obj;

		if (Objects.equals(_schoolData, schoolDataWrapper._schoolData)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _schoolData.getStagedModelType();
	}

	@Override
	public SchoolData getWrappedModel() {
		return _schoolData;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _schoolData.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _schoolData.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_schoolData.resetOriginalValues();
	}

	private final SchoolData _schoolData;
}