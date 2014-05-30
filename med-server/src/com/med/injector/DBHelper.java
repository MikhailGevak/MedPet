package com.med.injector;

import java.sql.SQLException;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;

public class DBHelper {
	private static final String DB_NAME = "unit_tests.db";
	private static final String IN_MEMORY_DB_URL = "jdbc:sqlite:" + DB_NAME;
	
	public static ConnectionSource getConnectionSource() throws SQLException{
		return new JdbcConnectionSource(IN_MEMORY_DB_URL);
	}
}
