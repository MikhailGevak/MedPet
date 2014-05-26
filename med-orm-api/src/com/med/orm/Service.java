package com.med.orm;


public interface Service<E extends Entity> {
	E createEntity(Entity entity);
	E getEntityById(String id);
}
