package com.med.orm.pharmacy;

import com.med.orm.Entity;


public interface Pharmacy extends Entity{
	String getName();
	
	void setName(String name);
	
	String getAddress();

	void setAddress(String address);	
}
