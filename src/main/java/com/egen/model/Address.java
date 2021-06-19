package com.egen.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Address {

	@Id
	@Column(columnDefinition = "VARCHAR(36)")
	private String addressId;
	private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private int zipCode;
    

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2
				+ ", city=" + city + ", state=" + state + ", zipCode=" + zipCode + "]";
	}
	
	public Address() {
		
		super();
        this.addressId = UUID.randomUUID().toString();
    }
	

	public Address(String addressLine1, String addressLine2, String city, String state, int zipCode) {
		
		super();
		this.addressId =  UUID.randomUUID().toString();
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	public String getAddressId() {
		return addressId;
	}
	
	public String getAddressLine1() {
		return addressLine1;
	}
	
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	
	public String getAddressLine2() {
		return addressLine2;
	}
	
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
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
	
	public int getZipCode() {
		return zipCode;
	}
	
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

}
