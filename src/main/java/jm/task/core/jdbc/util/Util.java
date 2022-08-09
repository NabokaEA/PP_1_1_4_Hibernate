package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Util {
    private static Connection connection;

    // Connect to MySQL
    public static Connection getMySQLConnection() {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pre_project_1_1_3", "root",
                "root")) {
            System.out.println("Соединение с БД Установлено");
        } catch (SQLException e) {
            System.out.println("При установке соединения возникла исключительная ситуация");
            e.printStackTrace();
        }
        return connection;
    }
}
