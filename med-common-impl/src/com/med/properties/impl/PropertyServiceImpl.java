package com.med.properties.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.med.properties.DatabaseProperties;
import com.med.properties.PropertyService;
import com.med.properties.ServerProperties;
import com.med.properties.ServletParameters;

public class PropertyServiceImpl implements PropertyService {
	private Properties properties;
	private ServerProperties serverProperties;
	private DatabaseProperties databaseProperties;
	private ServletParameters servletParameters;
	
	public PropertyServiceImpl(){
		load(new Properties());
	}
	
	public PropertyServiceImpl(InputStream stream) throws IOException{
		Properties properties = new Properties();
		properties.load(stream);
		load(properties);
	}
	
	public PropertyServiceImpl(Properties properties){
		load(properties);
	}
		public void load(Properties properties){
		this.properties = properties;
		this.databaseProperties = new DatabasePropertiesImpl(properties);
		this.serverProperties = new ServerPropertiesImpl(properties);
		this.servletParameters = new ServletParametersImpl(properties);
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

	@Override
	public ServletParameters getServletParameters() {
		return servletParameters;
	}
}
