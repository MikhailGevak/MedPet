package com.med.orm.impl.dao;

import java.sql.SQLException;

import com.google.inject.Inject;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.med.orm.model.impl.PharmacyPreparation;
import com.med.orm.model.impl.PreparationImpl;

public class PreparationDAO extends AbstractDAO<PreparationImpl>{
	@Inject
	public PreparationDAO(ConnectionSource connectionSource) throws SQLException {
		super(connectionSource, PreparationImpl.class);
	}

	@Override
	public void initialPrepareData() throws SQLException {
		TableUtils.createTableIfNotExists(connectionSource, PreparationImpl.class);
		TableUtils.createTableIfNotExists(connectionSource, PharmacyPreparation.class);
	}
}
