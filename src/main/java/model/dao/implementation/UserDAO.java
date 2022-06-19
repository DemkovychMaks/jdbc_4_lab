package model.dao.implementation;

import model.dao.GenericDAO;
import model.entity.User;
import persistant.DatabaseConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements GenericDAO<User> {
    private static final String GET_ALL = "SELECT * FROM db_for_db.user";
    private static final String GET_BY_ID = "SELECT * FROM db_for_db.user WHERE id=?";
    private static final String CREATE = "INSERT db_for_db.user "
            + "(`name`, `last_name`, `email`, `age`, country_id, library_id) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE db_for_db.user"
            + " SET name=?, last_name=?, email=?, age=?, country_id=?, library_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM db_for_db.user WHERE id=?";

    @Override
    public List<User> findAll() throws SQLException {
        List<User> users = new ArrayList<>();
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ALL)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                User user = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("email"),
                        resultSet.getInt("age"),
                        resultSet.getInt("country_id"),
                        resultSet.getInt("library_id")
                );
                users.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public User findById(Integer id) throws SQLException {
        User user = null;
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                user = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("email"),
                        resultSet.getInt("age"),
                        resultSet.getInt("country_id"),
                        resultSet.getInt("library_id")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void create(User user) throws SQLException {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, String.valueOf(user.getName()));
            statement.setString(2, String.valueOf(user.getLast_name()));
            statement.setString(3, String.valueOf(user.getEmail()));
            statement.setString(4, String.valueOf(user.getAge()));
            statement.setString(5, String.valueOf(user.getCountry_id()));
            statement.setString(6, String.valueOf(user.getLibrary_id()));
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Integer id, User user) throws SQLException {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(UPDATE)) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getLast_name());
            statement.setString(3, user.getEmail());
            statement.setInt(4, user.getAge());
            statement.setInt(5, user.getCountry_id());
            statement.setInt(6, user.getLibrary_id());
            statement.setInt(7, user.getId());
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(DELETE)) {
            statement.setInt(1, id);
            System.out.println(statement);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}