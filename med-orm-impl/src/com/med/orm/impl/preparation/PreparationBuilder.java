package com.med.orm.impl.preparation;

import com.med.orm.impl.AbstractEntityBuilder;
import com.med.orm.preparation.Preparation;
public class PreparationBuilder extends AbstractEntityBuilder<Preparation>{
	private String name;
	private String description;
	private String code;
	
	public String getName() {
		return name;
	}

	public PreparationBuilder setName(String name) {
		this.name = name;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public PreparationBuilder setDescription(String description) {
		this.description = description;
		return this;
	}

	public String getCode() {
		return code;
	}

	public PreparationBuilder setCode(String code) {
		this.code = code;
		return this;
	}

	@Override
	public Preparation build() {
		return new PreparationImpl(this);
	}

}
