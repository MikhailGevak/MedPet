package com.med.injector;

import java.sql.SQLException;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.med.orm.model.impl.PharmacyImpl;
import com.med.orm.model.impl.PharmacyPreparation;
import com.med.orm.model.impl.PreparationImpl;

public class DBHelper {
	private static final String DB_NAME = "unit_tests.db";
	private static final String IN_MEMORY_DB_URL = "jdbc:sqlite:" + DB_NAME;
	
	public static ConnectionSource getConnectionSource() throws SQLException, ClassNotFoundException{
		Class.forName("org.sqlite.JDBC");
		return new JdbcConnectionSource(IN_MEMORY_DB_URL);
	}

	public static void prepareTables(ConnectionSource source) throws SQLException{
		TableUtils.createTableIfNotExists(source, PharmacyImpl.class);
		TableUtils.createTableIfNotExists(source, PreparationImpl.class);
		TableUtils.createTableIfNotExists(source, PharmacyPreparation.class);
	}
}
