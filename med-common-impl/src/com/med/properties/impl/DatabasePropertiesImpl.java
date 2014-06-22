package com.med.properties.impl;

import java.util.Properties;

import com.med.properties.DatabaseProperties;

public class DatabasePropertiesImpl implements DatabaseProperties {
	private static final String SERVER_DATABASE_PROPERTY = "med.database";
	private String databaseURI;
	
	public DatabasePropertiesImpl(Properties properties){
		load(properties);
	}
	
	public void load(Properties properties){
		this.databaseURI = properties.getProperty(SERVER_DATABASE_PROPERTY);
	}
	
	@Override
	public String getDatabaseURI() {
		return databaseURI;
	}

}
