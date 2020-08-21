
package com.liferay.schoolmng.school.service.validation;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.schoolmng.school.exception.SchoolDataValidationException;

import java.util.ArrayList;
import java.util.List;

public class SchoolDataValidator {

	/**
	 *
	 * @param cityName
	 * @param errors
	 * @return
	 */
	public static boolean isCityNameValid(
		final String cityName, final List<String> errors) {

			boolean result = true;

			if (Validator.isNull(cityName)) {
				errors.add("error.schooldata-cityname-empty");
				result = false;
			}

			return result;
		}

	/**
	 *
	 * @param schoolName
	 * @param errors
	 * @return
	 */
	public static boolean isSchollNameValid(
		final String schoolName, final List<String> errors) {

		boolean result = true;

		if (Validator.isNull(schoolName)) {
			errors.add("error.schooldata-schoolname-empty");
			result = false;
		}

		return result;
	}

	/**
	 * Validate SchoolData
	 *
	 * @param schoolName
	 * @param schoolType
	 * @param cityName
	 * @param noOfStudents
	 * @param rating
	 * @param errors
	 * @return
	 */
	public static boolean isSchoolDataValid(String schoolName, String schoolType, String cityName,
			final List<String> errors) {

		boolean result = true;

		result &= isSchollNameValid(schoolName, errors);
		result &= isSchoolTypeValid(schoolType, errors);
		result &= isCityNameValid(cityName, errors);

		return result;
	}

	/**
	 *
	 * @param schoolType
	 * @param errors
	 * @return
	 */
	public static boolean isSchoolTypeValid(
		final String schoolType, final List<String> errors) {

		boolean result = true;

		if (Validator.isNull(schoolType)) {
			errors.add("error.schooldata-schooltype-empty");
			result = false;
		}

		return result;
	}

	/**
	 *
	 * @param schoolName
	 * @param schoolType
	 * @param cityName
	 * @param noOfStudents
	 * @param rating
	 * @throws SchoolDataValidationException
	 */
	public static void validate(
			String schoolName, String schoolType, String cityName)
		throws SchoolDataValidationException {

		List<String> errors = new ArrayList<>();

		if (!isSchoolDataValid(schoolName, schoolType, cityName, errors)) {
			throw new SchoolDataValidationException(errors);
		}
	}

}