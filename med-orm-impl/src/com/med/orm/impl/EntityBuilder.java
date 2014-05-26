package com.med.orm.impl;


public abstract class EntityBuilder<E extends Entity> {
	public abstract E build();
}
