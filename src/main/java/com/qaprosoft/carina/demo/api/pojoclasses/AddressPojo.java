package com.qaprosoft.carina.demo.api.pojoclasses;

public class AddressPojo {
	private Integer id;
	private String country;
	private String city;
	private String homeAddress;
	private Integer postalCode;
	private Long phone;


	public AddressPojo(Integer id, String country, String city, String homeAddress, Integer postalCode, Long phone) {
		this.id = id;
		this.country = country;
		this.city = city;
		this.homeAddress = homeAddress;
		this.postalCode = postalCode;
		this.phone = phone;
	}

	public AddressPojo() {
	}

	public String getCountry(){
		return country;
	}

	public String getCity(){
		return city;
	}

	public Long getPhone(){
		return phone;
	}

	public Integer getPostalCode(){
		return postalCode;
	}

	public Integer getId(){
		return id;
	}

	public String getHomeAddress(){
		return homeAddress;
	}
}
