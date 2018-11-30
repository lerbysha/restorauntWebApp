package ru.kpfu.itis.util;


import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
    private static Connection dataSource;

    private DatabaseManager() {
    }

    public static Connection getDataSource() {
        String userName = "postgres";
        String password = "kisa1999";
        String connectionURL = "jdbc:postgresql://localhost:5432/restoraunt_db";
        if (dataSource == null) {
            try {
                DriverManager.registerDriver(new org.postgresql.Driver());
                dataSource = DriverManager.getConnection(connectionURL, userName,
                        password);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return dataSource;
    }
}
