package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.SQLException;


public class Main {
    public static void main(String[] args) throws SQLException {
       /* Util.getMySQLConnection();*/
        UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();
        //userDaoJDBC.createUsersTable();
        userDaoJDBC.dropUsersTable();


    }
}
