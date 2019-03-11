package com.jitin.hibernatevalidations.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class ValidationUtil<T> {
	public List<String> validate(T object) {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<T>> constraintViolations = validator.validate(object);
		List<String> errors = new ArrayList<String>();
		;
		if (constraintViolations.size() > 0) {
			for (ConstraintViolation<T> violation : constraintViolations) {
				errors.add(violation.getMessage());
			}
		}
		return errors;
	}

	public List<String> validate(T object, Class group) {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<T>> constraintViolations = validator.validate(object, group);
		List<String> errors = new ArrayList<String>();
		;
		if (constraintViolations.size() > 0) {
			for (ConstraintViolation<T> violation : constraintViolations) {
				errors.add(violation.getMessage());
			}
		}
		return errors;
	}
}
