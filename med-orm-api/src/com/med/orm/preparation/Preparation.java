package com.med.orm.preparation;

import com.med.orm.Entity;

public interface Preparation extends Entity {
	String getName();
	
	void setName(String name);
	
	String getDescription();
	
	void setDescription(String description);
	
	String getCode();
	
	void setCode(String code);
	
}
