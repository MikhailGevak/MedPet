package com.med.service.impl;

import java.sql.SQLException;

import com.med.orm.Entity;
import com.med.orm.Service;
import com.med.orm.impl.dao.AbstractDAO;
import com.med.orm.model.impl.AbstractEntityImpl;

public abstract class AbstractServiceImpl<E extends Entity, I extends AbstractEntityImpl> implements Service<E>{
	protected final AbstractDAO<I> dao;
	
	public AbstractServiceImpl(AbstractDAO<I> dao){
		this.dao = dao;
	}
	
	@Override
	public E createEntity(E entity) throws SQLException {
		return convertToInterface(dao.createIfNotExists(convertToImpl(entity)));
	}

	@Override
	public E getEntityById(String id) throws SQLException {
		return convertToInterface(dao.queryForId(id));
	}

	protected abstract I convertToImpl(E entity);
	protected abstract E convertToInterface(I entityImpl);
}
