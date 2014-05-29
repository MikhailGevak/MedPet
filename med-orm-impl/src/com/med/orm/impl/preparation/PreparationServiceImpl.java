package com.med.orm.impl.preparation;

import com.google.inject.Inject;
import com.med.orm.impl.AbstractServiceImpl;
import com.med.orm.impl.dao.PreparationDAO;
import com.med.orm.preparation.Preparation;
import com.med.orm.preparation.PreparationService;

public class PreparationServiceImpl extends AbstractServiceImpl<Preparation, PreparationImpl> implements PreparationService{

	@Inject
	public PreparationServiceImpl(PreparationDAO dao) {
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