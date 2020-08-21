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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.schoolmng.school.service.http.SchoolDataServiceSoap}.
 *
 * @author Anjaneya
 * @see com.liferay.schoolmng.school.service.http.SchoolDataServiceSoap
 * @generated
 */
@ProviderType
public class SchoolDataSoap implements Serializable {
	public static SchoolDataSoap toSoapModel(SchoolData model) {
		SchoolDataSoap soapModel = new SchoolDataSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setSchoolId(model.getSchoolId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setSchoolName(model.getSchoolName());
		soapModel.setSchoolType(model.getSchoolType());
		soapModel.setCity(model.getCity());
		soapModel.setNoOfStudents(model.getNoOfStudents());
		soapModel.setRating(model.getRating());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static SchoolDataSoap[] toSoapModels(SchoolData[] models) {
		SchoolDataSoap[] soapModels = new SchoolDataSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SchoolDataSoap[][] toSoapModels(SchoolData[][] models) {
		SchoolDataSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SchoolDataSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SchoolDataSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SchoolDataSoap[] toSoapModels(List<SchoolData> models) {
		List<SchoolDataSoap> soapModels = new ArrayList<SchoolDataSoap>(models.size());

		for (SchoolData model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SchoolDataSoap[soapModels.size()]);
	}

	public SchoolDataSoap() {
	}

	public long getPrimaryKey() {
		return _schoolId;
	}

	public void setPrimaryKey(long pk) {
		setSchoolId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getSchoolId() {
		return _schoolId;
	}

	public void setSchoolId(long schoolId) {
		_schoolId = schoolId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public String getSchoolName() {
		return _schoolName;
	}

	public void setSchoolName(String schoolName) {
		_schoolName = schoolName;
	}

	public String getSchoolType() {
		return _schoolType;
	}

	public void setSchoolType(String schoolType) {
		_schoolType = schoolType;
	}

	public String getCity() {
		return _city;
	}

	public void setCity(String city) {
		_city = city;
	}

	public int getNoOfStudents() {
		return _noOfStudents;
	}

	public void setNoOfStudents(int noOfStudents) {
		_noOfStudents = noOfStudents;
	}

	public int getRating() {
		return _rating;
	}

	public void setRating(int rating) {
		_rating = rating;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	private String _uuid;
	private long _schoolId;
	private long _groupId;
	private String _schoolName;
	private String _schoolType;
	private String _city;
	private int _noOfStudents;
	private int _rating;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
}