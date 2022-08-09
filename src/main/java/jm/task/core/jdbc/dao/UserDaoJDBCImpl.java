package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;

import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        String queryString ="CREATE TABLE `pre_project_1_1_3`.`users` (\n" +
                "  `ID` INT NOT NULL AUTO_INCREMENT,\n" +
                "  `NAME` VARCHAR(45) NOT NULL,\n" +
                "  `LAST_NAME` VARCHAR(45) NOT NULL,\n" +
                "  `AGE` INT(3) NOT NULL,\n" +
                "        PRIMARY KEY (`ID`),\n" +
                "        UNIQUE INDEX `idUsers_UNIQUE` (`ID` ASC) VISIBLE);";


    }

    public void dropUsersTable() {

    }

    public void saveUser(String name, String lastName, byte age) {

    }

    public void removeUserById(long id) {

    }

    public List<User> getAllUsers() {
        return null;
    }

    public void cleanUsersTable() {

    }
}
