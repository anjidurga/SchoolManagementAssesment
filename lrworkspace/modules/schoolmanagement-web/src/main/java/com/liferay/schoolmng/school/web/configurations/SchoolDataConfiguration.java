package com.liferay.schoolmng.school.web.configurations;

import aQute.bnd.annotation.metatype.Meta;

/**
 * Portlet preference
 *
 * @author Anjaneya
 *
 */
@Meta.OCD(id = "com.liferay.schoolmanagement.configuration.SchoolDataConfiguration")
public interface SchoolDataConfiguration {

	@Meta.AD(required = false)
	public String getAssetsStatistics();

	@Meta.AD(required = false)
	public String getDateFormat();

}