package jm.task.core.jdbc.util;

import org.hibernate.Hibernate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Util {
    // Connect to MySQL
    public static Connection getMySQLConnection() throws SQLException {
        String hostName = "localhost";
        String dbName = "pre_project_1_1_3";
        String userName = "root";
        String password = "root";
        return getMySQLConnection(hostName, dbName, userName, password);
    }

    public static Connection getMySQLConnection(String hostName, String dbName,
                                                String userName, String password) throws SQLException {
        String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;
        return DriverManager.getConnection(connectionURL, userName,
                password);
    }

    //Hibernate
}
