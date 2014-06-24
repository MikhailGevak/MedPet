package com.med.server;

import java.sql.SQLException;

import com.med.properties.PropertyService;
import com.sun.jersey.guice.JerseyServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;

public class GuiceBinderModule extends JerseyServletModule {
	private final PropertyService propertiesService;

	public GuiceBinderModule(PropertyService propertiesService)
			throws ClassNotFoundException, SQLException {
		this.propertiesService = propertiesService;
	}

	@Override
	protected final void configureServlets() {
		bind(PropertyService.class).toInstance(propertiesService);	
	
		serve("/*").with(GuiceContainer.class, propertiesService.getServletParameters().getParameters());
	}
}
