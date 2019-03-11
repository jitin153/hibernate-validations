package com.jitin.hibernatevalidations.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class Address {
	@NotNull(message = "House number cannot be null.")
	private Integer houserNumber;
	@NotBlank(message = "Street cannot be blank.")
	private String street;
	@NotNull(message = "City cannot be null.")
	@Pattern(regexp = "[A-Za-z ]+", message = "Invalid city.")
	private String city;

	public Address(Integer houserNumber, String street, String city) {
		this.houserNumber = houserNumber;
		this.street = street;
		this.city = city;
	}

	public Integer getHouserNumber() {
		return houserNumber;
	}

	public void setHouserNumber(Integer houserNumber) {
		this.houserNumber = houserNumber;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
