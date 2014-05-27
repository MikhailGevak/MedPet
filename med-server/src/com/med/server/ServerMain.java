package com.med.server;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import com.sun.jersey.spi.container.servlet.ServletContainer;

public class ServerMain {
	public static void main(String[] args) throws Exception{
		ServletHolder sh = new ServletHolder(ServletContainer.class);
		sh.setInitParameter(
				"com.sun.jersey.config.property.resourceConfigClass",
				"com.sun.jersey.api.core.PackagesResourceConfig");
		sh.setInitParameter("com.sun.jersey.config.property.packages", "com.med.server.rest");
		sh.setInitParameter("com.sun.jersey.api.json.POJOMappingFeature",
				"true");

		Server server = new Server(9999);
		ServletContextHandler context = new ServletContextHandler(server, "/",
				ServletContextHandler.SESSIONS);
		context.addServlet(sh, "/*");
		server.start();
		server.join();
		
		System.out.println("Server started...");
		System.in.read();
		System.out.println("Server is stopping...");
		server.stop();
	}
}
