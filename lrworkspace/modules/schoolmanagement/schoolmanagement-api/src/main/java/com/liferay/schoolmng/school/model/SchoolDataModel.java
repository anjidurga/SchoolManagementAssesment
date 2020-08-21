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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the SchoolData service. Represents a row in the &quot;School&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.schoolmng.school.model.impl.SchoolDataModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.schoolmng.school.model.impl.SchoolDataImpl}.
 * </p>
 *
 * @author Anjaneya
 * @see SchoolData
 * @see com.liferay.schoolmng.school.model.impl.SchoolDataImpl
 * @see com.liferay.schoolmng.school.model.impl.SchoolDataModelImpl
 * @generated
 */
@ProviderType
public interface SchoolDataModel extends BaseModel<SchoolData>, GroupedModel,
	ShardedModel, StagedAuditedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a school data model instance should use the {@link SchoolData} interface instead.
	 */

	/**
	 * Returns the primary key of this school data.
	 *
	 * @return the primary key of this school data
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this school data.
	 *
	 * @param primaryKey the primary key of this school data
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this school data.
	 *
	 * @return the uuid of this school data
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this school data.
	 *
	 * @param uuid the uuid of this school data
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the school ID of this school data.
	 *
	 * @return the school ID of this school data
	 */
	public long getSchoolId();

	/**
	 * Sets the school ID of this school data.
	 *
	 * @param schoolId the school ID of this school data
	 */
	public void setSchoolId(long schoolId);

	/**
	 * Returns the group ID of this school data.
	 *
	 * @return the group ID of this school data
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this school data.
	 *
	 * @param groupId the group ID of this school data
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the school name of this school data.
	 *
	 * @return the school name of this school data
	 */
	@AutoEscape
	public String getSchoolName();

	/**
	 * Sets the school name of this school data.
	 *
	 * @param schoolName the school name of this school data
	 */
	public void setSchoolName(String schoolName);

	/**
	 * Returns the school type of this school data.
	 *
	 * @return the school type of this school data
	 */
	@AutoEscape
	public String getSchoolType();

	/**
	 * Sets the school type of this school data.
	 *
	 * @param schoolType the school type of this school data
	 */
	public void setSchoolType(String schoolType);

	/**
	 * Returns the city of this school data.
	 *
	 * @return the city of this school data
	 */
	@AutoEscape
	public String getCity();

	/**
	 * Sets the city of this school data.
	 *
	 * @param city the city of this school data
	 */
	public void setCity(String city);

	/**
	 * Returns the no of students of this school data.
	 *
	 * @return the no of students of this school data
	 */
	public int getNoOfStudents();

	/**
	 * Sets the no of students of this school data.
	 *
	 * @param noOfStudents the no of students of this school data
	 */
	public void setNoOfStudents(int noOfStudents);

	/**
	 * Returns the rating of this school data.
	 *
	 * @return the rating of this school data
	 */
	public int getRating();

	/**
	 * Sets the rating of this school data.
	 *
	 * @param rating the rating of this school data
	 */
	public void setRating(int rating);

	/**
	 * Returns the company ID of this school data.
	 *
	 * @return the company ID of this school data
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this school data.
	 *
	 * @param companyId the company ID of this school data
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this school data.
	 *
	 * @return the user ID of this school data
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this school data.
	 *
	 * @param userId the user ID of this school data
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this school data.
	 *
	 * @return the user uuid of this school data
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this school data.
	 *
	 * @param userUuid the user uuid of this school data
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this school data.
	 *
	 * @return the user name of this school data
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this school data.
	 *
	 * @param userName the user name of this school data
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this school data.
	 *
	 * @return the create date of this school data
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this school data.
	 *
	 * @param createDate the create date of this school data
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this school data.
	 *
	 * @return the modified date of this school data
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this school data.
	 *
	 * @param modifiedDate the modified date of this school data
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(SchoolData schoolData);

	@Override
	public int hashCode();

	@Override
	public CacheModel<SchoolData> toCacheModel();

	@Override
	public SchoolData toEscapedModel();

	@Override
	public SchoolData toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}