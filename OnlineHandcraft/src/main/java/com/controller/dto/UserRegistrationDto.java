package com.ohm.controller.dto;

public class UserRegistrationDto {

	private String firstName;
	private String lastName;

	private String email;
	private String password;
	private String address;
	private String contactNo;
	private String dob;
	private String city;
	private String state;
	private String gender;

	public UserRegistrationDto(String firstName,String lastName, String email, String password, String address, String contactNo,
			String dob, String city, String state, String gender) {
		super();
		this.firstName = firstName;
		this.lastName=lastName;
		this.email = email;
		this.password = password;
		this.address = address;
		this.contactNo = contactNo;
		this.dob = dob;
		this.city = city;
		this.state = state;
		this.gender = gender;
	
	}

	public UserRegistrationDto() {
		// TODO Auto-generated constructor stub
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
