package com.med.server;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.med.injector.ORMLiteModule;

public class GuiceServletConfig extends GuiceServletContextListener {
	 
    @Override
    protected Injector getInjector() {
        return Guice.createInjector(new ORMLiteModule());
    }
}