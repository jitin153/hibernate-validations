package com.jitin.hibernatevalidations;

import java.util.Arrays;
import java.util.List;

import com.jitin.hibernatevalidations.group.ChairmanGroup;
import com.jitin.hibernatevalidations.model.Address;
import com.jitin.hibernatevalidations.model.Contact;
import com.jitin.hibernatevalidations.model.User;
import com.jitin.hibernatevalidations.util.ValidationUtil;

public class TestChairmanValidation {

	public static void main(String[] args) {
		Contact contact = new Contact("0001112233", "0000111123", "test@abc.com", "9874657483");
		Address homeAddress = new Address(23, "Klm Street", "Mumbai");
		Address officeAddress = new Address(109, "Xyz Street", "Mumbai");
		List<Address> addresses = Arrays.asList(homeAddress, officeAddress);
		User chairman = new User(1002L, "Vibhav Sinha", addresses, contact, null, "http://testurl.com");
		ValidationUtil validationUtil = new ValidationUtil();
		List<String> errors = validationUtil.validate(chairman, ChairmanGroup.class);
		if (errors.size() > 0) {
			errors.forEach(System.out::println);
		} else {
			System.out.println("Valid Object...");
		}
	}

}
