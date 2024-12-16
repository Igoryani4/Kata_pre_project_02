package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;

public class Main {
    public static void main(String[] args) {

        UserDao userDao = new UserDaoHibernateImpl();


        userDao.createUsersTable();
        userDao.saveUser("Petr", "Petrov", (byte) 18);
        userDao.saveUser("Sidor", "Sidorov", (byte) 23);
        userDao.saveUser("Mikhail", "Mikhail", (byte) 25);
        userDao.saveUser("Mikhaila", "Mikhailova", (byte) 22);
        userDao.getAllUsers();
        userDao.removeUserById(2);
        userDao.getAllUsers();
        userDao.cleanUsersTable();
        userDao.saveUser("Petr", "Petrov", (byte) 18);
        userDao.getAllUsers();
        userDao.dropUsersTable();

    }
}
