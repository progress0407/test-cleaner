package io.philo;

import javax.sql.DataSource;

public class Main {
	public static void main(String[] args) {

		var database  = "defaultDatabase";
		var username = "defaultUser";
		var password = "defaultPassword";

		for (String arg : args) {
			if (arg.startsWith("--database=")) {
				database = arg.substring("--database=".length());
			} else if (arg.startsWith("--username=")) {
				username = arg.substring("--username=".length());
			} else if (arg.startsWith("--password=")) {
				password = arg.substring("--password=".length());
			}
		}

		var mySQLDataSource = DataSourceFactory.createMySQLDataSource(database, username, password);
		var testCleaner = new TestCleaner(mySQLDataSource);
		testCleaner.cleanDatabase();
	}
}