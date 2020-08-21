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

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the SchoolData service. Represents a row in the &quot;School&quot; database table, with each column mapped to a property of this class.
 *
 * @author Anjaneya
 * @see SchoolDataModel
 * @see com.liferay.schoolmng.school.model.impl.SchoolDataImpl
 * @see com.liferay.schoolmng.school.model.impl.SchoolDataModelImpl
 * @generated
 */
@ImplementationClassName("com.liferay.schoolmng.school.model.impl.SchoolDataImpl")
@ProviderType
public interface SchoolData extends SchoolDataModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.liferay.schoolmng.school.model.impl.SchoolDataImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<SchoolData, Long> SCHOOL_ID_ACCESSOR = new Accessor<SchoolData, Long>() {
			@Override
			public Long get(SchoolData schoolData) {
				return schoolData.getSchoolId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<SchoolData> getTypeClass() {
				return SchoolData.class;
			}
		};
}