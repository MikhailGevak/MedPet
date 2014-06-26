package com.med.model;

public interface Service<E extends Entity> {
	void initialPrepareData() throws ServiceException;

	E createEntity(E entity) throws ServiceException;

	E getEntityById(String id) throws ServiceException;
}
