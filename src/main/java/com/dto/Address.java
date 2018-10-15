package com.dto;

public class Address {
	
	private Integer addressId;
	private Integer userId;
	private String firstName;
	private String lastName;
	private String street;
	private String apt;
	private String city;
	private String state;
	private String zip;
	private String country;
	private String phone;
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Address(Integer userId, String firstName, String lastName, String street, String apt,
			String city, String state, String zip, String country, String phone) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.street = street;
		this.apt = apt;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.country = country;
		this.phone = phone;
	}
	public Integer getAddressId() {
		return addressId;
	}
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
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
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getApt() {
		return apt;
	}
	public void setApt(String apt) {
		this.apt = apt;
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
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
}
