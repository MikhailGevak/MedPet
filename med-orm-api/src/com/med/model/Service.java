package com.med.model;

import java.sql.SQLException;


public interface Service<E extends Entity> {
	void initialPrepareData() throws ServiceException;
	E createEntity(E entity) throws SQLException;
	E getEntityById(String id) throws SQLException;
}
