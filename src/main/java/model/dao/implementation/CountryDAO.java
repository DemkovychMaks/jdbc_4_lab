package model.dao.implementation;

import model.dao.GenericDAO;
import model.entity.Country;
import persistant.DatabaseConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CountryDAO implements GenericDAO<Country> {
    private static final String GET_ALL = "SELECT * FROM db_for_db.country";
    private static final String GET_BY_ID = "SELECT * FROM db_for_db.country WHERE id=?";
    private static final String CREATE = "INSERT db_for_db.country "
            + "(`name`, `population`) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE db_for_db.country"
            + " SET name=?, population=?, WHERE id=?";
    private static final String DELETE = "DELETE FROM db_for_db.country WHERE id=?";

    @Override
    public List<Country> findAll() throws SQLException {
        List<Country> countries = new ArrayList<>();
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ALL)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Country country = new Country(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("population")
                );
                countries.add(country);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return countries;
    }

    @Override
    public Country findById(Integer id) throws SQLException {
        Country country = null;
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                country = new Country(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("population")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return country;
    }

    @Override
    public void create(Country country) throws SQLException {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, String.valueOf(country.getName()));
            statement.setString(2, String.valueOf(country.getPopulation()));
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Integer id, Country country) throws SQLException {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(UPDATE)) {
            statement.setString(1, country.getName());
            statement.setInt(2, country.getPopulation());
            statement.setInt(3, country.getId());
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