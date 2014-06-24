package com.med.model.pharmacy;

import com.med.model.Entity;


public interface Pharmacy extends Entity{
	String getName();
	
	void setName(String name);
	
	String getAddress();

	void setAddress(String address);	
}
