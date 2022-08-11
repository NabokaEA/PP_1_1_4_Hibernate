package jm.task.core.jdbc.dao;

import com.sun.xml.bind.v2.model.core.ID;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public static UserDaoJDBCImpl getINSTANCE() {
        return INSTANCE;
    }

    private static final UserDaoJDBCImpl INSTANCE = new UserDaoJDBCImpl();
    private static final String createUsersTableSQL = "CREATE TABLE IF NOT EXISTS `pre_project_1_1_3`.`users` (\n" +
            "  `ID` INT NOT NULL AUTO_INCREMENT,\n" +
            "  `NAME` VARCHAR(45) NOT NULL,\n" +
            "  `LAST_NAME` VARCHAR(45) NOT NULL,\n" +
            "  `AGE` INT(3) NOT NULL,\n" +
            "        PRIMARY KEY (`ID`),\n" +
            "        UNIQUE INDEX `idUsers_UNIQUE` (`ID` ASC) VISIBLE);";
    private static final String dropUsersTableSQL = "DROP TABLE IF EXISTS `pre_project_1_1_3`.`users`;";
    private static final String saveUserSQL = "INSERT INTO users (NAME, LAST_NAME, AGE) values (?,?,?)";
    private static final String removeUserByIdSQL = "DELETE FROM users WHERE id=?";
    private static final String getAllUsersSQL = "SELECT ID, NAME, LAST_NAME, AGE FROM users;";
    private static final String cleanUsersTableSQL = "DELETE FROM users;";

    private UserDaoJDBCImpl() {

    }


    public void createUsersTable() {
        try (Connection connection = Util.getMySQLConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(createUsersTableSQL);) {
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println(e.getStackTrace());
        }
    }

    public void dropUsersTable() {
        try (Connection connection = Util.getMySQLConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(dropUsersTableSQL);) {
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println(e.getStackTrace());
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try (Connection connection = Util.getMySQLConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(saveUserSQL)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println(e.getStackTrace());
        }
    }

    public void removeUserById(long id) {
        try (Connection connection = Util.getMySQLConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(removeUserByIdSQL)) {
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println(e.getStackTrace());
        }
    }

    public List<User> getAllUsers() {
        List<User> users = null;
        try (Connection connection = Util.getMySQLConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(getAllUsersSQL)) {
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
            System.out.println(e.getStackTrace());
        }
        return users;
    }

    public void cleanUsersTable() {
        try (Connection connection = Util.getMySQLConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(cleanUsersTableSQL);) {
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println(e.getStackTrace());
        }
    }
}
