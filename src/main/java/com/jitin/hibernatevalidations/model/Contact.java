package com.jitin.hibernatevalidations.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.jitin.hibernatevalidations.group.ChairmanGroup;
import com.jitin.hibernatevalidations.group.StudentGroup;
import com.jitin.hibernatevalidations.group.TeacherGroup;

public class Contact {
	@NotNull(message = "Personal phone cannot be null.")
	@Pattern(regexp = "[0-9]{10}", message = "Invalid personal phone number.")
	private String personalPhone;
	@NotNull(groups = { ChairmanGroup.class, TeacherGroup.class }, message = "Office phone cannot be null.")
	@Pattern(regexp = "[0-9]{10}", message = "Invalid office phone number.")
	private String officePhone;
	@NotNull(groups = { ChairmanGroup.class, TeacherGroup.class,
			StudentGroup.class }, message = "Email cannot be null.")
	@Email(message = "Invalid email.")
	private String email;
	@NotNull(groups = ChairmanGroup.class, message = "Fax cannot be null.")
	@Pattern(regexp = "[0-9]{10}", message = "Invalid fax.")
	private String fax;

	public Contact(String personalPhone, String officePhone, String email, String fax) {
		this.personalPhone = personalPhone;
		this.officePhone = officePhone;
		this.email = email;
		this.fax = fax;
	}

	public String getPersonalPhone() {
		return personalPhone;
	}

	public void setPersonalPhone(String personalPhone) {
		this.personalPhone = personalPhone;
	}

	public String getOfficePhone() {
		return officePhone;
	}

	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}
}
