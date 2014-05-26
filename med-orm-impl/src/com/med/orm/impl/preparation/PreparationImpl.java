package com.med.orm.impl.preparation;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.med.orm.impl.EntityImpl;
import com.med.orm.preparation.Preparation;

@DatabaseTable(tableName = "preparation")
public class PreparationImpl extends EntityImpl implements Preparation{
	@DatabaseField(id=true)
	private String id;
	@DatabaseField
	private String name;
	@DatabaseField
	private String description;
	@DatabaseField
	private String code;
	
	public PreparationImpl(PreparationBuilder preparationBuilder) {
		this.name = preparationBuilder.getName();
		this.description = preparationBuilder.getDescription();
		this.code = preparationBuilder.getCode();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	public String toString(){
		return ReflectionToStringBuilder.toString(this);
	}
	@Override
	public String getId() {
		return id;
	}
}
