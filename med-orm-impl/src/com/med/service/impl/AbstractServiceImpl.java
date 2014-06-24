package com.med.service.impl;

import java.sql.SQLException;

import com.med.model.Entity;
import com.med.model.Service;
import com.med.model.ServiceException;
import com.med.orm.impl.dao.AbstractDAO;
import com.med.orm.model.impl.AbstractEntityImpl;

public abstract class AbstractServiceImpl<E extends Entity, I extends AbstractEntityImpl> implements Service<E>{
	protected final AbstractDAO<I> dao;
	
	public AbstractServiceImpl(AbstractDAO<I> dao) throws ServiceException{
		this.dao = dao;
		initialPrepareData();
	}
	
	@Override
	public E createEntity(E entity) throws SQLException {
		return convertToInterface(dao.createIfNotExists(convertToImpl(entity)));
	}

	@Override
	public E getEntityById(String id) throws SQLException {
		return convertToInterface(dao.queryForId(id));
	}


	@Override
	public void initialPrepareData() throws ServiceException {
		try{
			dao.initialPrepareData();
		}catch(SQLException ex){
			throw new ServiceException(ex);
		}
	}

	protected abstract I convertToImpl(E entity);
	protected abstract E convertToInterface(I entityImpl);
}
