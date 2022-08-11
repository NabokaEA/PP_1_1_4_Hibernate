package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.SQLException;
import java.util.List;


public class Main {
    public static void main(String[] args) throws SQLException {
        UserDaoJDBCImpl.getINSTANCE().dropUsersTable();
        UserDaoJDBCImpl.getINSTANCE().createUsersTable();
        UserDaoJDBCImpl.getINSTANCE().saveUser("Иван", "Иваныч", (byte) 15);
        UserDaoJDBCImpl.getINSTANCE().saveUser("Иван", "Кузьмич", (byte) 17);
        UserDaoJDBCImpl.getINSTANCE().saveUser("Петр", "Иваныч", (byte) 51);
        UserDaoJDBCImpl.getINSTANCE().removeUserById(2);
        List<User> users =  UserDaoJDBCImpl.getINSTANCE().getAllUsers();
        for (User user: users)
        System.out.println(user.toString());
        UserDaoJDBCImpl.getINSTANCE().cleanUsersTable();
        System.out.println("__________________________________");
        users =  UserDaoJDBCImpl.getINSTANCE().getAllUsers();
        for (User user: users)
            System.out.println(user.toString());
    }
}
