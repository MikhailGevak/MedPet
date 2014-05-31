package com.med.injector;

import java.sql.SQLException;

import com.google.inject.servlet.ServletModule;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.med.orm.impl.dao.PharmacyDAO;
import com.med.orm.impl.dao.PreparationDAO;
import com.med.orm.model.impl.PharmacyImpl;
import com.med.orm.model.impl.PharmacyPreparation;
import com.med.orm.model.impl.PreparationImpl;
import com.med.orm.pharmacy.PharmacyService;
import com.med.orm.preparation.PreparationService;
import com.med.service.impl.PharmacyServiceImpl;
import com.med.service.impl.PreparationServiceImpl;
import com.sun.jersey.guice.JerseyServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;

public class ORMLiteModule extends JerseyServletModule {
	
	@Override
	protected void configureServlets() {
		try {
			ConnectionSource source = DBHelper.getConnectionSource();
			
			prepareTables(source);
			
			bind(PharmacyService.class).to(PharmacyServiceImpl.class);
			bind(PreparationService.class).to(PreparationServiceImpl.class);
			bind(PharmacyDAO.class).toInstance(
					new PharmacyDAO(source));
			bind(PreparationDAO.class).toInstance(new PreparationDAO(source));
			
			serve("/*").with(GuiceContainer.class);
			 
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			throw new Error(e);
		}
	}
	
	private void prepareTables(ConnectionSource source) throws SQLException{
		TableUtils.createTableIfNotExists(source, PharmacyImpl.class);
		TableUtils.createTableIfNotExists(source, PreparationImpl.class);
		TableUtils.createTableIfNotExists(source, PharmacyPreparation.class);
	}

}
