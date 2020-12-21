package com.friday.adress.model;

public class Adress {
	
	private String Street;
	private String houseNumber;

	public Adress() {
		super();
	}

	public Adress(String street, String houseNumber) {
		super();
		Street = street;
		this.houseNumber = houseNumber;
	}
	
	public String getStreet() {
		return Street;
	}
	public void setStreet(String street) {
		Street = street;
	}
	public String getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}
}
