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

package com.liferay.schoolmng.school.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import com.liferay.schoolmng.school.model.SchoolData;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SchoolData in entity cache.
 *
 * @author Anjaneya
 * @see SchoolData
 * @generated
 */
@ProviderType
public class SchoolDataCacheModel implements CacheModel<SchoolData>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SchoolDataCacheModel)) {
			return false;
		}

		SchoolDataCacheModel schoolDataCacheModel = (SchoolDataCacheModel)obj;

		if (schoolId == schoolDataCacheModel.schoolId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, schoolId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", schoolId=");
		sb.append(schoolId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", schoolName=");
		sb.append(schoolName);
		sb.append(", schoolType=");
		sb.append(schoolType);
		sb.append(", city=");
		sb.append(city);
		sb.append(", noOfStudents=");
		sb.append(noOfStudents);
		sb.append(", rating=");
		sb.append(rating);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SchoolData toEntityModel() {
		SchoolDataImpl schoolDataImpl = new SchoolDataImpl();

		if (uuid == null) {
			schoolDataImpl.setUuid("");
		}
		else {
			schoolDataImpl.setUuid(uuid);
		}

		schoolDataImpl.setSchoolId(schoolId);
		schoolDataImpl.setGroupId(groupId);

		if (schoolName == null) {
			schoolDataImpl.setSchoolName("");
		}
		else {
			schoolDataImpl.setSchoolName(schoolName);
		}

		if (schoolType == null) {
			schoolDataImpl.setSchoolType("");
		}
		else {
			schoolDataImpl.setSchoolType(schoolType);
		}

		if (city == null) {
			schoolDataImpl.setCity("");
		}
		else {
			schoolDataImpl.setCity(city);
		}

		schoolDataImpl.setNoOfStudents(noOfStudents);
		schoolDataImpl.setRating(rating);
		schoolDataImpl.setCompanyId(companyId);
		schoolDataImpl.setUserId(userId);

		if (userName == null) {
			schoolDataImpl.setUserName("");
		}
		else {
			schoolDataImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			schoolDataImpl.setCreateDate(null);
		}
		else {
			schoolDataImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			schoolDataImpl.setModifiedDate(null);
		}
		else {
			schoolDataImpl.setModifiedDate(new Date(modifiedDate));
		}

		schoolDataImpl.resetOriginalValues();

		return schoolDataImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		schoolId = objectInput.readLong();

		groupId = objectInput.readLong();
		schoolName = objectInput.readUTF();
		schoolType = objectInput.readUTF();
		city = objectInput.readUTF();

		noOfStudents = objectInput.readInt();

		rating = objectInput.readInt();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(schoolId);

		objectOutput.writeLong(groupId);

		if (schoolName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(schoolName);
		}

		if (schoolType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(schoolType);
		}

		if (city == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(city);
		}

		objectOutput.writeInt(noOfStudents);

		objectOutput.writeInt(rating);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public String uuid;
	public long schoolId;
	public long groupId;
	public String schoolName;
	public String schoolType;
	public String city;
	public int noOfStudents;
	public int rating;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
}