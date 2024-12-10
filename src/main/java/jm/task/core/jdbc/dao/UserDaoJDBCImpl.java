package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        cleanUsersTable();

    }

    public void dropUsersTable() {
        dropUsersTable();

    }

    public void saveUser(String name, String lastName, byte age) {
        saveUser(name, lastName, age);

    }

    public void removeUserById(long id) {
        removeUserById(id);

    }

    public List<User> getAllUsers() {

        return getAllUsers();
    }

    public void cleanUsersTable() {
        cleanUsersTable();

    }
}
