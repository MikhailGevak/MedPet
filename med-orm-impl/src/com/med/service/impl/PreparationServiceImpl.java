package com.med.service.impl;

import java.util.List;

import com.google.inject.Inject;
import com.med.model.ServiceException;
import com.med.model.preparation.Preparation;
import com.med.model.preparation.PreparationAssociated;
import com.med.model.preparation.PreparationService;
import com.med.orm.impl.dao.PreparationDAO;
import com.med.orm.model.impl.PreparationImpl;

public class PreparationServiceImpl extends AbstractServiceImpl<Preparation, PreparationImpl> implements PreparationService{

	@Inject
	public PreparationServiceImpl(PreparationDAO dao) throws ServiceException {
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

	@Override
	public List<Preparation> getAllPreparations(
			PreparationAssociated preparationAssociated) {
		return preparationAssociated.getPreparations();
	}

}