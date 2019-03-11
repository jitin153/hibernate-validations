package com.jitin.hibernatevalidations;

import java.util.Arrays;
import java.util.List;

import com.jitin.hibernatevalidations.model.Address;
import com.jitin.hibernatevalidations.model.Contact;
import com.jitin.hibernatevalidations.model.User;
import com.jitin.hibernatevalidations.util.ValidationUtil;

public class TestPeonValidation {

	public static void main(String[] args) {
		Contact contact = new Contact("0011222333", null, null, null);
		List<Address> addresses = Arrays.asList(new Address(109, "Pqr Street", "Mumbai"));
		User peon = new User(27L, "Babu Lal", addresses, contact, null, null);
		ValidationUtil validationUtil = new ValidationUtil();
		List<String> errors = validationUtil.validate(peon);
		if (errors.size() > 0) {
			errors.forEach(System.out::println);
		} else {
			System.out.println("Valid Object...");
		}
	}
}
