package com.med.server;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.EnumSet;
import java.util.Properties;

import javax.servlet.DispatcherType;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

import com.google.inject.servlet.GuiceFilter;

public class ServerMain {
	
	private static final String DEFAULT_PROPERTIES_RESOURCE = "/default.properties";

	public static void main(String[] args) throws Exception {
		Properties properties = loadProperties(args);
		
		ExtendedGuiceServletContextListener guiceServlet = new ExtendedGuiceServletContextListener(properties);
        
		Server appServer = createSimpleJettyServer(guiceServlet);
    	appServer.start();
    	
    	System.out.println("Server running");
        System.out.println("Hit return to stop...");
        System.in.read();
        System.out.println("Stopping server");
        appServer.stop();
        System.out.println("Server stopped");
    }    
    
	private static Properties loadProperties(String[] args) throws IOException {
		InputStream inputStream = null;
		
		if (args == null || args.length == 0){
			inputStream = ClassLoader.class.getResourceAsStream(DEFAULT_PROPERTIES_RESOURCE);
		}
		
		Properties properties = new Properties();
		properties.load(inputStream);
		return properties;
	}

	private static Server createSimpleJettyServer(ExtendedGuiceServletContextListener guiceConfig) throws URISyntaxException{
		URI uri = guiceConfig.getServerURI();
    	Server server = new Server(uri.getPort());
    	
        ServletContextHandler root = new ServletContextHandler(server, uri.getPath());
        
        root.addEventListener(guiceConfig);
        root.addFilter(GuiceFilter.class, "/*", EnumSet.allOf(DispatcherType.class));
        root.addServlet(DummyServlet.class, "/*");
        
        return server;
    }
}
