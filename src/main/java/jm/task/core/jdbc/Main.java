package jm.task.core.jdbc;

import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        try (Connection connection = Util.getMySQLConnection();
             Statement statement = connection.createStatement()) {
            if (!connection.isClosed()) {
                System.out.println("Соединение установлено");
            }
        } catch (SQLException e) {
            System.out.println("При установке соединения возникла исключительная ситуация");
            e.printStackTrace();
        }

    }
}
