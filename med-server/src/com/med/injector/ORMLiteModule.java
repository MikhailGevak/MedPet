package com.med.injector;

import com.google.inject.AbstractModule;
import com.med.orm.impl.pharmacy.PharmacyServiceImpl;
import com.med.orm.impl.preparation.PreparationServiceImpl;
import com.med.orm.pharmacy.PharmacyService;
import com.med.orm.preparation.PreparationService;

public class ORMLiteModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(PharmacyService.class).to(PharmacyServiceImpl.class);
		bind(PreparationService.class).to(PreparationServiceImpl.class);
	}

}
