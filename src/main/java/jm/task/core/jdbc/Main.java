package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        UserServiceImpl service = new UserServiceImpl();
        service.createUsersTable();
        service.saveUser("Иван", "Иваныч", (byte) 15);
        service.saveUser("Иван", "Кузьмич", (byte) 17);
        service.saveUser("Петр", "Иваныч", (byte) 51);
        service.saveUser("Дональд", "Иваныч", (byte) 59);
        List<User> users = service.getAllUsers();
        for (User user : users) {
            System.out.println(user.toString());
        }
        service.cleanUsersTable();
        service.dropUsersTable();
    }
}
