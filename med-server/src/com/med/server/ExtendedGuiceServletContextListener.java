package com.med.server;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.Properties;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.med.properties.PropertyService;

public class ExtendedGuiceServletContextListener extends
		GuiceServletContextListener {
	private final Properties properties;
	private Injector injector;

	public ExtendedGuiceServletContextListener(Properties properties) {
		this.properties = properties;
	}

	@Override
	protected Injector getInjector() {
		if (injector == null) {
			try {
				injector = createInjector(properties);
			} catch (SQLException | IOException | ClassNotFoundException e) {
				e.printStackTrace();
				return null;
			}
		}
		return injector;
	}

	public Injector getGuiceInjector() {
		return injector;
	}

	protected Injector createInjector(Properties properties)
			throws SQLException, IOException, ClassNotFoundException {
		return Guice.createInjector(new GuiceBinderModule(properties));
	}

	public URI getServerURI() throws URISyntaxException {
		return getInjector().getInstance(PropertyService.class).getServerProperties().getServerURI();
	}
}