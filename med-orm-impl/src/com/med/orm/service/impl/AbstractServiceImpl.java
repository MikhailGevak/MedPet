package com.med.orm.service.impl;

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
	public E createEntity(E entity) throws ServiceException {
		E newEntity;
		try {
			newEntity = convertToInterface(dao.createIfNotExists(convertToImpl(entity)));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
		
		return newEntity;
	}

	@Override
	public E getEntityById(String id) throws ServiceException {
		E entity;
		try {
			entity = convertToInterface(dao.queryForId(id));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
		
		return entity;
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
