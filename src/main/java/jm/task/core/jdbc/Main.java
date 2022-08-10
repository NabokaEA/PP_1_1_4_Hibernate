package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.SQLException;


public class Main {
    public static void main(String[] args) throws SQLException {
        UserDaoJDBCImpl.getINSTANCE().dropUsersTable();
        UserDaoJDBCImpl.getINSTANCE().createUsersTable();
        UserDaoJDBCImpl.getINSTANCE().saveUser("Иван","Иваныч", (byte) 15);


    }
}
