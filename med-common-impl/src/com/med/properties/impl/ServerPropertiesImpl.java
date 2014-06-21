package com.med.properties.impl;

import java.util.Properties;

import com.med.properties.ServerProperties;

public class ServerPropertiesImpl implements ServerProperties{
	private static final String SERVER_PORT_PROPERTY = "med.server.port";
	private static final String CONTEXT_PATH_PORT_PROPERTY = "med.server.context_path";
	
	private String port;
	private String contextPath;
	
	public ServerPropertiesImpl(Properties properties){
		load(properties);
	}
	
	public void load(Properties properties){
		this.port = properties.getProperty(SERVER_PORT_PROPERTY);
		this.contextPath = properties.getProperty(CONTEXT_PATH_PORT_PROPERTY);
	}
	
	@Override
	public String getPort() {
		return port;
	}

	@Override
	public String getContextPath() {
		return contextPath;
	}

}
