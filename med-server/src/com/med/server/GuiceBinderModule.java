package com.med.server;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.j256.ormlite.support.ConnectionSource;
import com.med.injector.DBHelper;
import com.med.orm.impl.dao.PharmacyDAO;
import com.med.orm.impl.dao.PreparationDAO;
import com.med.orm.pharmacy.PharmacyService;
import com.med.orm.preparation.PreparationService;
import com.med.service.impl.PharmacyServiceImpl;
import com.med.service.impl.PreparationServiceImpl;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.guice.JerseyServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;

public class GuiceBinderModule extends JerseyServletModule {
	private final ConnectionSource connectionSource;
	private final String[] args;

	public GuiceBinderModule() throws SQLException, IOException, ClassNotFoundException {
		this(new String[] { System.getProperty("user.dir") });
	}

	public GuiceBinderModule(String args[]) throws SQLException, IOException, ClassNotFoundException {
		this.args = args;
		connectionSource = initConnection();
	}

	@Override
	protected final void configureServlets() {
		configureConnections();

		bind(GuiceContainer.class);

		try {
			DBHelper.prepareTables(connectionSource);

			bind(PharmacyService.class).to(PharmacyServiceImpl.class);
			bind(PreparationService.class).to(PreparationServiceImpl.class);
			bind(PharmacyDAO.class).toInstance(
					new PharmacyDAO(connectionSource));
			bind(PreparationDAO.class).toInstance(
					new PreparationDAO(connectionSource));
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("com.sun.jersey.spi.container.ContainerRequestFilters",
				"com.sun.jersey.api.container.filter.LoggingFilter");
		parameters.put("com.sun.jersey.spi.container.ContainerResponseFilters",
				"com.sun.jersey.api.container.filter.LoggingFilter");

		parameters
				.put(PackagesResourceConfig.PROPERTY_PACKAGES,
						"com.med.server.rest;org.codehaus.jackson.jaxrs");

		parameters.put("com.sun.jersey.config.feature.Trace", "true");
		serve("/*").with(GuiceContainer.class, parameters);
	}

	protected void configureConnections() {
		try {
			bind(ConnectionSource.class).toInstance(getConnectionInstance());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return;
	}

	public final ConnectionSource getConnectionInstance() throws SQLException {
		return connectionSource;
	}

	protected ConnectionSource initConnection() throws SQLException, ClassNotFoundException {
		return DBHelper.getConnectionSource();
	}
}
