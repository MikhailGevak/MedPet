package com.med.properties;


public interface PropertyService {
	String getPropertyValue(String name);
	ServerProperties getServerProperties();
	DatabaseProperties getDatabaseProperties();
	ServletParameters getServletParameters();
}
