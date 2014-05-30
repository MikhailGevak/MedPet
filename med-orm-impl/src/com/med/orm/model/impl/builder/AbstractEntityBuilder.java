package com.med.orm.model.impl.builder;

import com.med.orm.Entity;


public abstract class AbstractEntityBuilder<E extends Entity> {
	public abstract E build();
}
