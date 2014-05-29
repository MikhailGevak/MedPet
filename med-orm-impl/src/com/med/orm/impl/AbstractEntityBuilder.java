package com.med.orm.impl;

import com.med.orm.Entity;


public abstract class AbstractEntityBuilder<E extends Entity> {
	public abstract E build();
}
