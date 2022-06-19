package model.dao.implementation;

import model.dao.GenericDAO;
import model.entity.Library;
import persistant.DatabaseConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LibraryDAO implements GenericDAO<Library> {
    private static final String GET_ALL = "SELECT * FROM db_for_db.library";
    private static final String GET_BY_ID = "SELECT * FROM db_for_db.library WHERE id=?";
    private static final String CREATE = "INSERT db_for_db.library "
            + "(`amount_of_songs`, `amount_of_downloaded_songs`) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE db_for_db.library"
            + " SET amount_of_liked_songs=?, amount_of_downloaded_songs=?, WHERE id=?";
    private static final String DELETE = "DELETE FROM db_for_db.library WHERE id=?";

    @Override
    public List<Library> findAll() throws SQLException {
        List<Library> libraries = new ArrayList<>();
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ALL)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Library library = new Library(
                        resultSet.getInt("id"),
                        resultSet.getInt("amount_of_songs"),
                        resultSet.getInt("amount_of_downloaded_songs")
                );
                libraries.add(library);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return libraries;
    }

    @Override
    public Library findById(Integer id) throws SQLException {
        Library library = null;
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                library = new Library(
                        resultSet.getInt("id"),
                        resultSet.getInt("amount_of_songs"),
                        resultSet.getInt("amount_of_downloaded_songs")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return library;
    }

    @Override
    public void create(Library library) throws SQLException {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, String.valueOf(library.getAmount_of_songs()));
            statement.setString(2, String.valueOf(library.getAmount_of_downloaded_songs()));
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Integer id, Library library) throws SQLException {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(UPDATE)) {
            statement.setInt(1, library.getAmount_of_songs());
            statement.setInt(2, library.getAmount_of_downloaded_songs());
            statement.setInt(3, library.getId());
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
