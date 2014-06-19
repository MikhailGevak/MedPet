package com.med.server;

import java.io.IOException;
import java.net.URI;
import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.ws.rs.core.UriBuilder;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

import com.google.inject.servlet.GuiceFilter;

public class ServerMain {
	
	public static void main(String[] args) throws Exception {
		ExtendedGuiceServletContextListener guiceServlet = new ExtendedGuiceServletContextListener();
        
		Server appServer = createSimpleJettyServer(guiceServlet);
    	appServer.start();
    	
    	System.out.println("Server running");
        System.out.println("Hit return to stop...");
        System.in.read();
        System.out.println("Stopping server");
        appServer.stop();
        System.out.println("Server stopped");
    }    
    
	public static Server createSimpleJettyServer(ExtendedGuiceServletContextListener guiceConfig){
		String contextPath = "";
		String serverPort = "8888";
		
		URI uri = UriBuilder.fromPath("http://localhost:" + serverPort + "/" + contextPath ).build();
	
		return createSimpleJettyServer(guiceConfig, uri);
	}
   
    public static Server createSimpleJettyServer(ExtendedGuiceServletContextListener guiceConfig, URI uri, String baseDir) throws IOException{
		return createSimpleJettyServer(guiceConfig, uri);
    }
    
    private static Server createSimpleJettyServer(ExtendedGuiceServletContextListener guiceConfig, URI uri){
    	Server server = new Server(uri.getPort());
    	
        ServletContextHandler root = new ServletContextHandler(server, uri.getPath());
        
        root.addEventListener(guiceConfig);
        root.addFilter(GuiceFilter.class, "/*", EnumSet.allOf(DispatcherType.class));
        root.addServlet(DummyServlet.class, "/*");
        
        return server;
    }
}
