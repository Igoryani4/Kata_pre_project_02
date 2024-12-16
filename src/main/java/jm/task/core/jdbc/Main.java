package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

public class Main {
    public static void main(String[] args) {

        UserServiceImpl userService = new UserServiceImpl();
        UserDao userDao = new UserDaoHibernateImpl();

//        userService.createUsersTable();
//        userService.saveUser("Petr", "Petrov", (byte) 18);
//        userService.saveUser("Sidor", "Sidorov", (byte) 23);
//        userService.saveUser("Mikhail", "Mikhail", (byte) 25);
//        userService.saveUser("Mikhaila", "Mikhailova", (byte) 22);
//        userService.getAllUsers();
//        userService.removeUserById(2);
//        userService.getAllUsers();
//        userService.cleanUsersTable();
//        userService.getAllUsers();
//        userService.dropUsersTable();

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
