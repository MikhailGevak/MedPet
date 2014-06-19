package com.med.server;

import java.io.IOException;
import java.sql.SQLException;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;

public class ExtendedGuiceServletContextListener extends GuiceServletContextListener {
	private final String[] args;
	private Injector injector;
	
	public ExtendedGuiceServletContextListener(){
		this(new String[]{});
	}
	public ExtendedGuiceServletContextListener(String[] args){
		this.args = args;
	}
	@Override
	protected Injector getInjector() {
		 if (injector == null){
			 try {
				injector = createInjector();
			} catch (SQLException | IOException | ClassNotFoundException e) {
				e.printStackTrace();
				return null;
			}
		 }
		 return injector;  
	}
	
	public Injector getGuiceInjector(){
		return injector;
	}
	
	protected Injector createInjector() throws SQLException, IOException, ClassNotFoundException{
		return Guice.createInjector(new GuiceBinderModule(args));
	}
}