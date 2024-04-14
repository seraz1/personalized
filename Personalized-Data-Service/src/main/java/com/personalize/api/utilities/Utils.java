package com.personalize.api.utilities;

import java.util.Set;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

public class Utils {

	private static Validator validator;

	static {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	public static <T> void validate(T object) {
		Set<ConstraintViolation<T>> violations = validator.validate(object);
		if (!violations.isEmpty()) {
			StringBuilder errorMessage = new StringBuilder();
			for (ConstraintViolation<T> violation : violations) {
				errorMessage.append(violation.getMessage()).append("; ");
			}
			throw new IllegalArgumentException(errorMessage.toString());
		}
	}
}
