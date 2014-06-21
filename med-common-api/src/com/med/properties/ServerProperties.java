package com.med.properties;

import java.net.URI;
import java.net.URISyntaxException;

public interface ServerProperties {
	String getPort();
	String getContextPath();
	String getHostName();
	URI getServerURI() throws URISyntaxException;
}
