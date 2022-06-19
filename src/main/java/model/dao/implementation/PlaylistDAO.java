package model.dao.implementation;

import model.dao.GenericDAO;
import model.entity.Playlist;
import persistant.DatabaseConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlaylistDAO implements GenericDAO<Playlist> {
    private static final String GET_ALL = "SELECT * FROM db_for_db.playlist";
    private static final String GET_BY_ID = "SELECT * FROM db_for_db.playlist WHERE id=?";
    private static final String CREATE = "INSERT db_for_db.playlist "
            + "(`appointment`, `about`, `library_id`) VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE db_for_db.playlist"
            + " SET appointment=?, about=?, library_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM db_for_db.playlist WHERE id=?";

    @Override
    public List<Playlist> findAll() throws SQLException {
        List<Playlist> playlists = new ArrayList<>();
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ALL)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Playlist playlist = new Playlist(
                        resultSet.getInt("id"),
                        resultSet.getString("appointment"),
                        resultSet.getString("about"),
                        resultSet.getInt("library_id")
                );
                playlists.add(playlist);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return playlists;
    }

    @Override
    public Playlist findById(Integer id) throws SQLException {
        Playlist playlist = null;
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                playlist = new Playlist(
                        resultSet.getInt("id"),
                        resultSet.getString("appointment"),
                        resultSet.getString("about"),
                        resultSet.getInt("library_id")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return playlist;
    }

    @Override
    public void create(Playlist playlist) throws SQLException {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, String.valueOf(playlist.getAppointment()));
            statement.setString(2, String.valueOf(playlist.getAbout()));
            statement.setString(3, String.valueOf(playlist.getLibrary_id()));
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Integer id, Playlist playlist) throws SQLException {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(UPDATE)) {
            statement.setString(1, playlist.getAppointment());
            statement.setString(2, playlist.getAbout());
            statement.setInt(3, playlist.getLibrary_id());
            statement.setInt(4, playlist.getId());
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