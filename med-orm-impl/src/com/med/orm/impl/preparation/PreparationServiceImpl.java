package com.med.orm.impl.preparation;

import com.google.inject.Inject;
import com.med.orm.impl.AbstractServiceImpl;
import com.med.orm.impl.dao.AbstractDAO;
import com.med.orm.impl.dao.PharmacyDAO;
import com.med.orm.preparation.Preparation;
import com.med.orm.preparation.PreparationService;

public class PreparationServiceImpl extends AbstractServiceImpl<Preparation, PreparationImpl> implements PreparationService{

	@Inject
	public PreparationServiceImpl(AbstractDAO<PreparationImpl> dao) {
		super(dao);
	}

	@Override
	protected PreparationImpl convertToImpl(Preparation entity) {
		return (PreparationImpl)entity;
	}

	@Override
	protected Preparation convertToInterface(PreparationImpl entityImpl) {
		return entityImpl;
	}

}