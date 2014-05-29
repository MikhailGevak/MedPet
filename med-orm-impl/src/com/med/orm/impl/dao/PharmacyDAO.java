package com.med.orm.impl.dao;

import java.sql.SQLException;

import com.j256.ormlite.support.ConnectionSource;
import com.med.orm.impl.pharmacy.PharmacyImpl;

public class PharmacyDAO extends AbstractDAO<PharmacyImpl>{

	protected PharmacyDAO(ConnectionSource connectionSource, Class<PharmacyImpl> dataClass) throws SQLException {
		super(connectionSource, dataClass);
	}
}
