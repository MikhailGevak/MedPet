package com.med.orm.model.impl.builder;

import com.med.model.pharmacy.Pharmacy;

public class PharmacyBuilder extends AbstractEntityBuilder<Pharmacy> {
	private String name;
	private String address;
	
	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}
	
	public PharmacyBuilder setName(String name){
		this.name = name;
		return this;
	}
	
	public PharmacyBuilder setAddress(String address){
		this.address = address;
		return this;
	}
}
