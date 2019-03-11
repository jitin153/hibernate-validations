package com.jitin.hibernatevalidations;

import java.util.Arrays;
import java.util.List;

import com.jitin.hibernatevalidations.group.StudentGroup;
import com.jitin.hibernatevalidations.model.Address;
import com.jitin.hibernatevalidations.model.Contact;
import com.jitin.hibernatevalidations.model.User;
import com.jitin.hibernatevalidations.util.ValidationUtil;

public class TestStudentValidation {

	public static void main(String[] args) {
		Contact contact = new Contact("0111222333", null, "test@abc.com", null);
		List<Address> address = Arrays.asList(new Address(56, "Food Street", "Mumbai"));
		User student = new User(1L, "Naman", address, contact, "FAIL", "http://hello.com");
		ValidationUtil validationUtil = new ValidationUtil();
		List<String> errors = validationUtil.validate(student, StudentGroup.class);
		if (errors.size() > 0) {
			errors.forEach(System.out::println);
		} else {
			System.out.println("Valid Object...");
		}
	}
}
