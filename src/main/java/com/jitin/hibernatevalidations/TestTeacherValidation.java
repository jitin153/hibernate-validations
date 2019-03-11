package com.jitin.hibernatevalidations;

import java.util.Arrays;
import java.util.List;

import com.jitin.hibernatevalidations.group.TeacherGroup;
import com.jitin.hibernatevalidations.model.Address;
import com.jitin.hibernatevalidations.model.Contact;
import com.jitin.hibernatevalidations.model.User;
import com.jitin.hibernatevalidations.util.ValidationUtil;

public class TestTeacherValidation {

	public static void main(String[] args) {
		Contact contact = new Contact("0011122233", "9812398123", "test@abc.com", null);
		Address homeAddress = new Address(56, "Abc Street", "Mumbai");
		Address officeAddress = new Address(109, "Xyz Street", "Mumbai");
		List<Address> addresses = Arrays.asList(homeAddress, officeAddress);
		User teacher = new User(104L, "Atul Chaudhary", addresses, contact, null, "http://testurl.com");
		ValidationUtil validationUtil = new ValidationUtil();
		List<String> errors = validationUtil.validate(teacher, TeacherGroup.class);
		if (errors.size() > 0) {
			errors.forEach(System.out::println);
		} else {
			System.out.println("Valid Object...");
		}
	}
}
