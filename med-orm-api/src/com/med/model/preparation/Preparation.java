package com.med.model.preparation;

import com.med.model.Entity;

public interface Preparation extends Entity {
	String getName();
	
	void setName(String name);
	
	String getDescription();
	
	void setDescription(String description);
	
	String getCode();
	
	void setCode(String code);
	
}
