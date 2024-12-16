package jm.task.core.jdbc.dao;


import jm.task.core.jdbc.model.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static jm.task.core.jdbc.util.Util.getConnection;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {  // this is default constructor
    }

    public void createUsersTable() {
        String createTable = "CREATE TABLE IF NOT EXISTS users (id INT PRIMARY KEY AUTO_INCREMENT," +
                " name VARCHAR(45), lastName VARCHAR(45), age INT(3))";

        try (Connection connection = getConnection(); Statement statement = connection.createStatement()) {
            statement.executeUpdate(createTable);
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public void dropUsersTable() {

        String dropTable = "DROP TABLE IF EXISTS users";
        try (Connection connection = getConnection(); Statement statement = connection.createStatement()) {
            statement.executeUpdate(dropTable);
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        String insertUser = "INSERT users (name, lastName, age) VALUES ("
                +"'"+ name + "', '" + lastName + "', " + age + ")";
        try (Connection connection = getConnection(); Statement statement = connection.createStatement()) {
            statement.executeUpdate(insertUser);
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public void removeUserById(long id) {
        String sql = "DELETE FROM users WHERE id = '" + id + "'";
        try (Connection connection = getConnection(); Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public List<User> getAllUsers() {

        List<User> users = new ArrayList<>();
        try (Connection connection = getConnection(); Statement statement = connection.createStatement()) {
            String sql = "SELECT * FROM users";
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()) {
                int count = 1;
                int id = resultSet.getInt(count++);
                String name = resultSet.getString(count++);
                String lastName = resultSet.getString(count++);
                byte age = resultSet.getByte(count++);
                User user = new User(name, lastName, age);
                users.add(user);
                System.out.printf("%d. %s, %s, %d\n", id, name, lastName, age);
            }
            return users;
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public void cleanUsersTable() {
        String sql = "TRUNCATE TABLE users";

        try (Connection connection = getConnection(); Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }
}
