package com.med.injector;

import java.sql.SQLException;

import com.google.inject.AbstractModule;
import com.j256.ormlite.support.ConnectionSource;
import com.med.orm.pharmacy.PharmacyService;
import com.med.orm.preparation.PreparationService;
import com.med.service.impl.PharmacyServiceImpl;
import com.med.service.impl.PreparationServiceImpl;

public class ORMLiteModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(PharmacyService.class).to(PharmacyServiceImpl.class);
		bind(PreparationService.class).to(PreparationServiceImpl.class);
		try {
			bind(ConnectionSource.class).toInstance(DBHelper.getConnectionSource());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Error(e);
		}
	}

}
