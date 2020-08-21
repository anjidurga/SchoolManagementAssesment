package com.liferay.schoolmng.school.exception;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.exception.PortalException;

import java.util.List;

/**
 *
 * @author Anjaneya
 *
 */
@ProviderType
public class SchoolDataValidationException extends PortalException {

	public SchoolDataValidationException() {
	}

	/**
	 * Custom constructor taking a list as a parameter.
	 *
	 * @param errors
	 */
	public SchoolDataValidationException(List<String> errors) {
		super(String.join(",", errors));

		_errors = errors;
	}

	public SchoolDataValidationException(String msg) {
		super(msg);
	}

	public SchoolDataValidationException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public SchoolDataValidationException(Throwable cause) {
		super(cause);
	}

	public List<String> getErrors() {
		return _errors;
	}

	private List<String> _errors;

}