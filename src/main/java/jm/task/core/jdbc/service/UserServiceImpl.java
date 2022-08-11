package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    public void createUsersTable() {
        UserDaoJDBCImpl.getINSTANCE().createUsersTable();
    }

    public void dropUsersTable() {
        UserDaoJDBCImpl.getINSTANCE().dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        UserDaoJDBCImpl.getINSTANCE().saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {
        UserDaoJDBCImpl.getINSTANCE().removeUserById(id);
    }

    public List<User> getAllUsers() {
        return UserDaoJDBCImpl.getINSTANCE().getAllUsers();
    }

    /*select * from users where ID=1;*/
    public void cleanUsersTable() {
        UserDaoJDBCImpl.getINSTANCE().cleanUsersTable();
    }
}
