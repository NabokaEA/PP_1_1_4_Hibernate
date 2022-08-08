package jm.task.core.jdbc.service;

import jm.task.core.jdbc.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    public void createUsersTable() {
/*        CREATE TABLE `pre_project_1_1_3`.`users` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `NAME` VARCHAR(45) NOT NULL,
  `LAST_NAME` VARCHAR(45) NOT NULL,
  `AGE` INT(3) NOT NULL,
        PRIMARY KEY (`ID`),
        UNIQUE INDEX `idUsers_UNIQUE` (`ID` ASC) VISIBLE);*/
    }

    public void dropUsersTable() {

    }

    public void saveUser(String name, String lastName, byte age) {
     /*   insert into users (NAME, LAST_NAME, AGE) values ('Evgeniy','Naboka', 50);*/
        /*update users set LAST_NAME='Stogova', NAME='Galina', AGE=45 where ID=2;*/
    }

    public void removeUserById(long id) {
        /*delete from users where id=21;*/
    }

    public List<User> getAllUsers() {
        return null;
    }
    /*select * from users where ID=1;*/
    public void cleanUsersTable() {

    }
}
