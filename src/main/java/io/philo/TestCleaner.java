package io.philo;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestCleaner {

    private final DataSource dataSource;

    public TestCleaner(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void cleanDatabase()  {

        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()) {

            // 외래 키 제약조건 비활성화 (MySQL)
            statement.execute("SET FOREIGN_KEY_CHECKS = 0");

            DatabaseMetaData metaData = connection.getMetaData();

            try (ResultSet tables = metaData.getTables(null, null, "%", new String[] {"TABLE"})) {
                while (tables.next()) {
                    String tableName = tables.getString("TABLE_NAME");

                    String sql = "TRUNCATE TABLE " + tableName; // or DELETE FROM

                    // 또는: String sql = "DELETE FROM " + tableName;

                    System.out.println("Executing: " + sql);

                    statement.execute(sql);
                }
            }

            // 외래 키 제약조건 다시 활성화
            statement.execute("SET FOREIGN_KEY_CHECKS = 1");

        } catch (Exception exception) {
            System.out.println(exception);
        }
    }
}
