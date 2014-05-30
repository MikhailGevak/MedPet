package com.med.orm.impl.dao;

import java.sql.SQLException;

import com.google.inject.Inject;
import com.j256.ormlite.support.ConnectionSource;
import com.med.orm.model.impl.PreparationImpl;

public class PreparationDAO extends AbstractDAO<PreparationImpl>{
	@Inject
	protected PreparationDAO(ConnectionSource connectionSource) throws SQLException {
		super(connectionSource, PreparationImpl.class);
	}
}
