package com.med.orm.impl.dao;

import java.sql.SQLException;
import java.util.List;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import com.med.orm.impl.AbstractEntityImpl;

public abstract class AbstractDAO<E extends AbstractEntityImpl> extends
		BaseDaoImpl<E, String> {

	protected AbstractDAO(ConnectionSource connectionSource, Class<E> dataClass)
			throws SQLException {
		super(connectionSource, dataClass);
	}

	public List<E> getAll() throws SQLException {
		return this.queryForAll();
	}
}
