package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserServiceImpl;


public class Main {
    public static void main(String[] args) {

        UserServiceImpl userService = new UserServiceImpl();


        userService.createUsersTable();
        userService.saveUser("Petr", "Petrov", (byte) 18);
        userService.saveUser("Sidor", "Sidorov", (byte) 23);
        userService.saveUser("Mikhail", "Mikhail", (byte) 25);
        userService.saveUser("Mikhaila", "Mikhailova", (byte) 22);
        userService.getAllUsers();
        userService.removeUserById(2);
        userService.getAllUsers();
        userService.cleanUsersTable();
        userService.getAllUsers();
        userService.dropUsersTable();


    }
}
