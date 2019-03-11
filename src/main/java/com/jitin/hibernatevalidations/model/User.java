package com.jitin.hibernatevalidations.model;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.URL;

import com.jitin.hibernatevalidations.group.ChairmanGroup;
import com.jitin.hibernatevalidations.group.StudentGroup;
import com.jitin.hibernatevalidations.group.TeacherGroup;

public class User {
	@NotNull(message = "Id cannot be null.")
	private Long id;
	@NotNull(message = "Name cannot be null.")
	@Pattern(regexp = "[A-Za-z ]+", message = "Invalid name.")
	private String name;
	@Valid
	@NotEmpty(message = "Address cannot be empty.")
	private List<Address> addresses;
	@Valid
	@NotNull(message = "Contact cannot be null.")
	private Contact contact;
	@NotNull(groups = StudentGroup.class, message = "Result cannot be null.")
	@Pattern(groups = StudentGroup.class, regexp = "PASS|FAIL", message = "Result can only be PASS or FAIL.")
	private String result;
	@NotNull(groups = { TeacherGroup.class, ChairmanGroup.class }, message = "Website url cannot be null.")
	@URL(message = "Invalid website url.")
	private String website;

	public User(Long id, String name, List<Address> addresses, Contact contact, String result, String website) {
		this.id = id;
		this.name = name;
		this.addresses = addresses;
		this.contact = contact;
		this.result = result;
		this.website = website;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

}
