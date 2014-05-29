package com.med.orm;

import java.sql.SQLException;


public interface Service<E extends Entity> {
	E createEntity(E entity) throws SQLException;
	E getEntityById(String id) throws SQLException;
}
