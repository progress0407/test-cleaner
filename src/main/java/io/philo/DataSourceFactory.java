package io.philo;

import com.mysql.cj.jdbc.MysqlDataSource;
import javax.sql.DataSource;

public class DataSourceFactory {
    public static DataSource createMySQLDataSource(String username, String password) {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL("jdbc:mysql://localhost:3306/your_database");
        dataSource.setUser(username);
        dataSource.setPassword(password);
        return dataSource;
    }
}
