package com.med.properties.impl;

import java.util.Properties;

import com.med.properties.DatabaseProperties;
import com.med.properties.PropertyService;
import com.med.properties.ServerProperties;

public class PropertyServiceImpl implements PropertyService {
	private Properties properties;
	private ServerProperties serverProperties;
	private DatabaseProperties databaseProperties;
	
	public PropertyServiceImpl(){
		load(new Properties());
	}
	
	public PropertyServiceImpl(Properties properties){
		load(properties);
	}
		public void load(Properties properties){
		this.properties = properties;
		this.databaseProperties = new DatabasePropertiesImpl(properties);
		this.serverProperties = new ServerPropertiesImpl(properties);
	}
	
	@Override
	public String getPropertyValue(String name){
		return properties.getProperty(name);
	}
	
	@Override
	public ServerProperties getServerProperties(){
		return serverProperties;
	}
	
	@Override
	public DatabaseProperties getDatabaseProperties() {
		return databaseProperties;
	}
}
