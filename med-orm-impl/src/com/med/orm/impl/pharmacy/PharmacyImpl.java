package com.med.orm.impl.pharmacy;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.med.orm.impl.AbstractEntityImpl;
import com.med.orm.pharmacy.Pharmacy;

@DatabaseTable(tableName = "pharmacy")
public class PharmacyImpl extends AbstractEntityImpl implements Pharmacy{
	@DatabaseField(id = true)
	private String id;
	@DatabaseField
	private String name;
	@DatabaseField
	private String address;

	public PharmacyImpl(){
		 // ORMLite needs a no-arg constructor 
	}
	
	public PharmacyImpl(PharmacyBuilder builder) {
		this.name = builder.getName();
		this.address = builder.getAddress();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

	@Override
	public String getId() {
		return id;
	}
}
