package jm.task.core.jdbc;

import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection connection = Util.getMySQLConnection();
        if (!connection.isClosed()) {
            System.out.println("Соединение установлено");
            // реализуйте алгоритм здесь
        }
    }
}
