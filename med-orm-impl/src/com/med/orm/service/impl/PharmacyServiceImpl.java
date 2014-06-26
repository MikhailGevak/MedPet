package com.med.orm.service.impl;

import java.util.List;

import com.google.inject.Inject;
import com.med.model.ServiceException;
import com.med.model.pharmacy.Pharmacy;
import com.med.model.pharmacy.PharmacyAssociated;
import com.med.model.pharmacy.PharmacyService;
import com.med.orm.impl.dao.PharmacyDAO;
import com.med.orm.model.impl.PharmacyImpl;

public class PharmacyServiceImpl extends AbstractServiceImpl<Pharmacy, PharmacyImpl> implements PharmacyService{

	@Inject
	public PharmacyServiceImpl(PharmacyDAO dao) throws ServiceException {
		super(dao);
	}

	@Override
	protected PharmacyImpl convertToImpl(Pharmacy entity) {
		return (PharmacyImpl)entity;
	}

	@Override
	protected Pharmacy convertToInterface(PharmacyImpl entityImpl) {
		return entityImpl;
	}

	@Override
	public List<Pharmacy> getAllPharmacies(PharmacyAssociated pharmacyAssociated) {
		return pharmacyAssociated.getPharmacies();
	}
}
