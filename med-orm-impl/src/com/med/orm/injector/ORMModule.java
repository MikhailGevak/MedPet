package com.med.orm.injector;

import java.sql.SQLException;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.med.model.pharmacy.PharmacyService;
import com.med.model.preparation.PreparationService;
import com.med.orm.impl.dao.PharmacyDAO;
import com.med.orm.impl.dao.PreparationDAO;
import com.med.properties.DatabaseProperties;
import com.med.service.impl.PharmacyServiceImpl;
import com.med.service.impl.PreparationServiceImpl;

public class ORMModule implements Module {
	private DatabaseProperties databaseProperties;

	public ORMModule(DatabaseProperties databaseProperties) {
		this.databaseProperties = databaseProperties;
	}

	@Override
	public void configure(Binder binder) {
		try {
			binder.bind(ConnectionSource.class).toInstance(
					createConnectionSource());
			binder.bind(PharmacyService.class).to(PharmacyServiceImpl.class);
			binder.bind(PreparationService.class).to(
					PreparationServiceImpl.class);
			binder.bind(PharmacyDAO.class);
			binder.bind(PreparationDAO.class);
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}
	}

	private ConnectionSource createConnectionSource() throws SQLException,
			ClassNotFoundException {
		Class.forName("org.sqlite.JDBC");
		return new JdbcConnectionSource(databaseProperties.getDatabaseURI());
	}

}
