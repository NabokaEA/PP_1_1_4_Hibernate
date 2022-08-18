package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.*;

import javax.persistence.EntityManager;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    private static final String CREATE_USERS_TABLE_SQL = "CREATE TABLE IF NOT EXISTS `pre_project_1_1_3`.`users` (\n" +
            "  `ID` INT NOT NULL AUTO_INCREMENT,\n" +
            "  `NAME` VARCHAR(45) NOT NULL,\n" +
            "  `LAST_NAME` VARCHAR(45) NOT NULL,\n" +
            "  `AGE` INT(3) NOT NULL,\n" +
            "        PRIMARY KEY (`ID`),\n" +
            "        UNIQUE INDEX `idUsers_UNIQUE` (`ID` ASC) VISIBLE);";
    private static final String DROP_USERS_TABLE_SQL = "DROP TABLE IF EXISTS `pre_project_1_1_3`.`users`;";
    private static final String GET_ALL_USERS_SQL = "SELECT ID, NAME, LAST_NAME, AGE FROM users;";

    public static UserDaoHibernateImpl getINSTANCE() {
        return INSTANCE;
    }

    private static final UserDaoHibernateImpl INSTANCE = new UserDaoHibernateImpl();

    SessionFactory sessionFactory = Util.getSessionFactory();

    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable() {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession();) {
            transaction = session.beginTransaction();
            session.createSQLQuery(CREATE_USERS_TABLE_SQL).addEntity(User.class).executeUpdate();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            if (null != transaction) {
                transaction.rollback();
            }
            throw new RuntimeException(e);
        }
    }

    @Override
    public void dropUsersTable() {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession();) {
            transaction = session.beginTransaction();
            session.createSQLQuery(DROP_USERS_TABLE_SQL).addEntity(User.class).executeUpdate();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            if (null != transaction) {
                transaction.rollback();
            }
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession();) {
            transaction = session.beginTransaction();
            User user = new User(name, lastName, age);
            user.setId(null);
            session.persist(user);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            if (null != transaction) {
                transaction.rollback();
            }
            throw new RuntimeException(e);
        }
    }

    @Override
    public void removeUserById(long id) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession();) {
            transaction = session.beginTransaction();
            User user = session.getReference(User.class, id);
            session.remove(user);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            if (null != transaction) {
                transaction.rollback();
            }
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> userList;
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession();) {
            transaction = session.beginTransaction();
            userList = session.createQuery("SELECT u FROM User u").getResultList();
            //userList = session.createNativeQuery(GET_ALL_USERS_SQL, User.class).getResultList();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            if (null != transaction) {
                transaction.rollback();
            }
            throw new RuntimeException(e);
        }
        return userList;
    }

    @Override
    public void cleanUsersTable() {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession();) {
            transaction = session.beginTransaction();
            session.createQuery("DELETE FROM User").executeUpdate();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            if (null != transaction) {
                transaction.rollback();
            }
            throw new RuntimeException(e);
        }
    }
}
