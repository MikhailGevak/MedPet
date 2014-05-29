package com.med.orm.impl.pharmacy;

import com.google.inject.Inject;
import com.med.orm.impl.AbstractServiceImpl;
import com.med.orm.impl.dao.AbstractDAO;
import com.med.orm.impl.dao.PharmacyDAO;
import com.med.orm.pharmacy.Pharmacy;
import com.med.orm.pharmacy.PharmacyService;

public class PharmacyServiceImpl extends AbstractServiceImpl<Pharmacy, PharmacyImpl> implements PharmacyService{

	@Inject
	public PharmacyServiceImpl(PharmacyDAO dao) {
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

}
