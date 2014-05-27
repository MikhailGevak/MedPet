package com.med.orm.impl.pharmacy;

import com.med.orm.impl.EntityBuilder;

public class PharmacyBuilder extends EntityBuilder<PharmacyImpl> {
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

	@Override
	public PharmacyImpl build() {
		return new PharmacyImpl(this);
	}
}
