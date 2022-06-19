package model.dao.implementation;

import model.dao.GenericDAO;
import model.entity.Artist;
import persistant.DatabaseConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArtistDAO implements GenericDAO<Artist> {
    private static final String GET_ALL = "SELECT * FROM db_for_db.artist";
    private static final String GET_BY_ID = "SELECT * FROM db_for_db.artist WHERE id=?";
    private static final String CREATE = "INSERT db_for_db.artist "
            + "(`name`, `last_name`, `age`, `amount_of_albums`) VALUES (?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE db_for_db.artist"
            + " SET name=?, last_name=?, age=?, amount_of_albums=? WHERE id=?";
    private static final String DELETE = "DELETE FROM db_for_db.artist WHERE id=?";

    @Override
    public List<Artist> findAll() throws SQLException {
        List<Artist> artists = new ArrayList<>();
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ALL)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Artist artist = new Artist(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("last_name"),
                        resultSet.getInt("age"),
                        resultSet.getInt("amount_of_albums")
                );
                artists.add(artist);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return artists;
    }

    @Override
    public Artist findById(Integer id) throws SQLException {
        Artist artist = null;
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                artist = new Artist(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("last_name"),
                        resultSet.getInt("age"),
                        resultSet.getInt("amount_of_albums")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return artist;
    }

    @Override
    public void create(Artist artist) throws SQLException {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, String.valueOf(artist.getName()));
            statement.setString(2, String.valueOf(artist.getLast_name()));
            statement.setString(3, String.valueOf(artist.getAge()));
            statement.setString(4, String.valueOf(artist.getAmount_of_albums()));
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Integer id, Artist artist) throws SQLException {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(UPDATE)) {
            statement.setString(1, artist.getName());
            statement.setString(2, artist.getLast_name());
            statement.setInt(3, artist.getAge());
            statement.setInt(4, artist.getAmount_of_albums());
            statement.setInt(5, artist.getId());
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