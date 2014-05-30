package com.med.orm.model.impl.builder;

import com.med.orm.model.impl.PharmacyImpl;

public class PharmacyBuilder extends AbstractEntityBuilder<PharmacyImpl> {
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
