package com.med.injector;

import java.sql.SQLException;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.med.orm.model.impl.PharmacyImpl;
import com.med.orm.model.impl.PharmacyPreparation;
import com.med.orm.model.impl.PreparationImpl;

public class DBHelper {
	public static ConnectionSource getConnectionSource(String DatabaseURI) throws SQLException, ClassNotFoundException{
		Class.forName("org.sqlite.JDBC");
		return new JdbcConnectionSource(DatabaseURI);
	}

	public static void prepareTables(ConnectionSource source) throws SQLException{
		TableUtils.createTableIfNotExists(source, PharmacyImpl.class);
		TableUtils.createTableIfNotExists(source, PreparationImpl.class);
		TableUtils.createTableIfNotExists(source, PharmacyPreparation.class);
	}
}
