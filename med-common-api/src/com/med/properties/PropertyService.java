package com.med.properties;


public interface PropertyService {
	public String getPropertyValue(String name);
	public ServerProperties getServerProperties();
	public DatabaseProperties getDatabaseProperties();
}
