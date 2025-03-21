package io.philo;

import javax.sql.DataSource;

public class Main {
	public static void main(String[] args) {

		String username = "defaultUser";
		String password = "defaultPassword";

		for (String arg : args) {
			if (arg.startsWith("--username=")) {
				username = arg.substring("--username=".length());
			} else if (arg.startsWith("--password=")) {
				password = arg.substring("--password=".length());
			}
		}

		DataSource mySQLDataSource = DataSourceFactory.createMySQLDataSource(username, password);
		TestCleaner testCleaner = new TestCleaner(mySQLDataSource);
		testCleaner.cleanDatabase();
	}
}