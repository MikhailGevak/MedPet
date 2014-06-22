package com.med.properties.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import com.med.properties.ServletParameters;

public class ServletParametersImpl implements ServletParameters {
	private static final String SERVLET_SUFIX = "med.servlet.property.";
	private Map<String, String> parameters = new HashMap<>();

	public ServletParametersImpl(Properties properties) {
		for(Entry<Object, Object> entry : properties.entrySet()){
			if(entry.getKey().toString().startsWith(SERVLET_SUFIX)){
				String key = entry.getKey().toString().replace(SERVLET_SUFIX, "");
				parameters.put(key, entry.getValue().toString());
			}
		}
	}

	@Override
	public Map<String, String> getParameters() {
		return parameters;
	}

}
