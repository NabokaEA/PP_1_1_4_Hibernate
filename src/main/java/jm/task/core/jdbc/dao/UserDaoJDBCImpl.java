package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public static UserDaoJDBCImpl getINSTANCE() {
        return INSTANCE;
    }

    private static final UserDaoJDBCImpl INSTANCE = new UserDaoJDBCImpl();
    private static final String CREATE_USERS_TABLE_SQL = "CREATE TABLE IF NOT EXISTS `pre_project_1_1_3`.`users` (\n" +
            "  `ID` INT NOT NULL AUTO_INCREMENT,\n" +
            "  `NAME` VARCHAR(45) NOT NULL,\n" +
            "  `LAST_NAME` VARCHAR(45) NOT NULL,\n" +
            "  `AGE` INT(3) NOT NULL,\n" +
            "        PRIMARY KEY (`ID`),\n" +
            "        UNIQUE INDEX `idUsers_UNIQUE` (`ID` ASC) VISIBLE);";
    private static final String DROP_USERS_TABLE_SQL = "DROP TABLE IF EXISTS `pre_project_1_1_3`.`users`;";
    private static final String SAVE_USER_SQL = "INSERT INTO users (NAME, LAST_NAME, AGE) values (?,?,?)";
    private static final String REMOVE_USER_BY_ID_SQL = "DELETE FROM users WHERE id=?";
    private static final String GET_ALL_USERS_SQL = "SELECT ID, NAME, LAST_NAME, AGE FROM users;";
    private static final String CLEAN_USERS_TABLE_SQL = "DELETE FROM users;";

    private UserDaoJDBCImpl() {

    }


    public void createUsersTable() {
        try (Connection connection = Util.getMySQLConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_USERS_TABLE_SQL)) {
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }

    public void dropUsersTable() {
        try (Connection connection = Util.getMySQLConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DROP_USERS_TABLE_SQL)) {
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try (Connection connection = Util.getMySQLConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SAVE_USER_SQL)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }

    public void removeUserById(long id) {
        try (Connection connection = Util.getMySQLConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(REMOVE_USER_BY_ID_SQL)) {
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }

    public List<User> getAllUsers() {
        List<User> users = null;
        try (Connection connection = Util.getMySQLConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_USERS_SQL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            users = new ArrayList<>();
            while (resultSet.next()) {
                User user = new User(
                        resultSet.getString("NAME"),
                        resultSet.getString("LAST_NAME"),
                        resultSet.getByte("AGE"));
                user.setId(resultSet.getLong("ID"));
                users.add(user);
            }
        } catch (SQLException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
        return users;
    }

    public void cleanUsersTable() {
        try (Connection connection = Util.getMySQLConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CLEAN_USERS_TABLE_SQL)) {
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }
}
