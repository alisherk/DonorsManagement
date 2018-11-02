package com.alsoftware.model;

public class Member {
	
	private String memberNumber;
	private String type;
	private String firstName;
	private String lastName;
	private String streetAddress; 
	private String city; 
	private String province; 
	private String postalCode; 
	private String email;
	private String phone; 
	private String comment; 
	
	public Member() {
		
	}

	public Member(String memberNumber, String type, String firstName, String lastName) {

		this.memberNumber = memberNumber; 
		this.type = type;
		this.firstName = firstName;
		this.lastName = lastName;
		
	}

	public Member(String memberNumber, String type, String firstName, String lastName, String address, 
			String city, String province, String postalCode, String email, String phone, String comment) {

		this.memberNumber = memberNumber; 
		this.type = type;
		this.firstName = firstName;
		this.lastName = lastName;
		this.streetAddress = address;
		this.city = city; 
		this.province = province;
		this.postalCode = postalCode; 
		this.email = email;
		this.phone = phone; 
		this.comment = comment;  

	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getMemberNumber() {
		return memberNumber;
	}

	public void setMemberNumber(String memberNumber) {
		this.memberNumber = memberNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
		 		
}
