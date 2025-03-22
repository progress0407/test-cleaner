package io.philo;

import com.mysql.cj.jdbc.MysqlDataSource;
import javax.sql.DataSource;

public class DataSourceFactory {

    public static DataSource createMySQLDataSource(String database, String username, String password) {

		var dataSource = new MysqlDataSource();
        dataSource.setURL("jdbc:mysql://localhost:3306/" + database);
        dataSource.setUser(username);
        dataSource.setPassword(password);

        return dataSource;
    }
}
