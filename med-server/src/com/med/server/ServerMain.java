package com.med.server;

import java.util.EnumSet;

import javax.servlet.DispatcherType;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceFilter;
import com.med.injector.ORMLiteModule;
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
		
		Injector injector = Guice.createInjector(new ORMLiteModule(), new AbstractModule() {
		    @Override
		    protected void configure() {
		        binder().requireExplicitBindings();
		        bind(GuiceFilter.class);
		    }
		});
		 
		FilterHolder guiceFilter = new FilterHolder(injector.getInstance(GuiceFilter.class));
		context.addFilter(guiceFilter, "/*", EnumSet.allOf(DispatcherType.class));

		
		server.start();
		server.join();
	}
}
