package com.med.orm.impl.dao;

import java.sql.SQLException;

import com.google.inject.Inject;
import com.j256.ormlite.support.ConnectionSource;
import com.med.orm.model.impl.PharmacyImpl;

public class PharmacyDAO extends AbstractDAO<PharmacyImpl>{
	@Inject
	public PharmacyDAO(ConnectionSource connectionSource) throws SQLException {
		super(connectionSource, PharmacyImpl.class);
	}
}
