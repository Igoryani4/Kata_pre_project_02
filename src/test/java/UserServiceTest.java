import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class UserServiceTest {
    private final UserService userService = new UserServiceImpl();
    private final UserDaoHibernateImpl userDao = new UserDaoHibernateImpl();

    private final String testName = "Ivan";
    private final String testLastName = "Ivanov";
    private final byte testAge = 5;


    @Test
    public void dropUsersTable() {
        try {
            userDao.dropUsersTable();
            userDao.dropUsersTable();
//            userService.dropUsersTable();
//            userService.dropUsersTable();
        } catch (Exception e) {
            Assert.fail("При тестировании удаления таблицы произошло исключение\n" + e);
        }
    }

    @Test
    public void createUsersTable() {
        try {
            userDao.dropUsersTable();
            userDao.createUsersTable();
//            userService.dropUsersTable();
//            userService.createUsersTable();
        } catch (Exception e) {
            Assert.fail("При тестировании создания таблицы пользователей произошло исключение\n" + e.getMessage());
        }
    }

    @Test
    public void saveUser() {
        try {
//            userService.dropUsersTable();
//            userService.createUsersTable();
//            userService.saveUser(testName, testLastName, testAge);
            userDao.dropUsersTable();
            userDao.createUsersTable();
            userDao.saveUser(testName, testLastName, testAge);


            User user = userDao.getAllUsers().get(0);

            if (!testName.equals(user.getName())
                    || !testLastName.equals(user.getLastName())
                    || testAge != user.getAge()
            ) {
                Assert.fail("User был некорректно добавлен в базу данных");
            }

        } catch (Exception e) {
            Assert.fail("Во время тестирования сохранения пользователя произошло исключение\n" + e);
        }
    }

    @Test
    public void removeUserById() {
        try {
//            userService.dropUsersTable();
//            userService.createUsersTable();
//            userService.saveUser(testName, testLastName, testAge);
//            userService.removeUserById(1L);
            userDao.dropUsersTable();
            userDao.createUsersTable();
            userDao.saveUser(testName, testLastName, testAge);
            userDao.removeUserById(1L);
        } catch (Exception e) {
            Assert.fail("При тестировании удаления пользователя по id произошло исключение\n" + e);
        }
    }

    @Test
    public void getAllUsers() {
        try {
//            userService.dropUsersTable();
//            userService.createUsersTable();
//            userService.saveUser(testName, testLastName, testAge);
//            List<User> userList = userService.getAllUsers();
            userDao.dropUsersTable();
            userDao.createUsersTable();
            userService.saveUser(testName, testLastName, testAge);
            List<User> userList2 = userService.getAllUsers();

            if (userList2.size() != 1) {
                Assert.fail("Проверьте корректность работы метода сохранения пользователя/удаления или создания таблицы");
            }
        } catch (Exception e) {
            Assert.fail("При попытке достать всех пользователей из базы данных произошло исключение\n" + e);
        }
    }

    @Test
    public void cleanUsersTable() {
        try {
//            userService.dropUsersTable();
//            userService.createUsersTable();
//            userService.saveUser(testName, testLastName, testAge);
//            userService.cleanUsersTable();
            userDao.dropUsersTable();
            userDao.createUsersTable();
            userDao.saveUser(testName, testLastName, testAge);
            userDao.cleanUsersTable();

            if (userDao.getAllUsers().size() != 0) {
                Assert.fail("Метод очищения таблицы пользователей реализован не корректно");
            }
        } catch (Exception e) {
            Assert.fail("При тестировании очистки таблицы пользователей произошло исключение\n" + e);
        }
    }

}
