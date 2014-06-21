package com.med.server;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.j256.ormlite.support.ConnectionSource;
import com.med.injector.DBHelper;
import com.med.orm.impl.dao.PharmacyDAO;
import com.med.orm.impl.dao.PreparationDAO;
import com.med.orm.pharmacy.PharmacyService;
import com.med.orm.preparation.PreparationService;
import com.med.properties.DatabaseProperties;
import com.med.properties.PropertyService;
import com.med.properties.impl.PropertyServiceImpl;
import com.med.service.impl.PharmacyServiceImpl;
import com.med.service.impl.PreparationServiceImpl;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.guice.JerseyServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;

public class GuiceBinderModule extends JerseyServletModule {
	private final Properties properties;

	public GuiceBinderModule(Properties properties)
			throws ClassNotFoundException, SQLException {
		this.properties = properties;
	}

	@Override
	protected final void configureServlets() {
		PropertyService propertiesService = new PropertyServiceImpl(properties);

		configureConnections(propertiesService.getDatabaseProperties());

		bind(GuiceContainer.class);
		bind(PharmacyService.class).to(PharmacyServiceImpl.class);
		bind(PreparationService.class).to(PreparationServiceImpl.class);
		bind(PharmacyDAO.class);
		bind(PreparationDAO.class);

		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("com.sun.jersey.spi.container.ContainerRequestFilters",
				"com.sun.jersey.api.container.filter.LoggingFilter");
		parameters.put("com.sun.jersey.spi.container.ContainerResponseFilters",
				"com.sun.jersey.api.container.filter.LoggingFilter");

		parameters.put(PackagesResourceConfig.PROPERTY_PACKAGES,
				"com.med.server.rest;org.codehaus.jackson.jaxrs");

		parameters.put("com.sun.jersey.config.feature.Trace", "true");
		serve("/*").with(GuiceContainer.class, parameters);
	}

	protected void configureConnections(DatabaseProperties properties) {
		try {
			ConnectionSource connectionSource = initConnection(properties);
			bind(ConnectionSource.class).toInstance(connectionSource);

			DBHelper.prepareTables(connectionSource);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	protected ConnectionSource initConnection(
			DatabaseProperties databaseProperties) throws SQLException,
			ClassNotFoundException {
		return DBHelper
				.getConnectionSource(databaseProperties.getDatabaseURI());
	}
}
