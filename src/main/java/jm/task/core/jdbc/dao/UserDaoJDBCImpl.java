package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
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
    private static final String removeUserByIdSQL = "";
    private static final String getAllUsersSQL = "";
    private static final String cleanUsersTableSQL = "";

    private UserDaoJDBCImpl() {

    }


    public void createUsersTable() throws SQLException {
        try (Connection connection = Util.getMySQLConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(createUsersTableSQL);) {
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void dropUsersTable() throws SQLException {
        String queryString = "DROP TABLE IF EXISTS `pre_project_1_1_3`.`users`;";
        Boolean executeResult;
        try (Statement statement = Util.getMySQLConnection().createStatement()) {
            executeResult = statement.execute(queryString);
        }
        System.out.println(executeResult);

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
