package model.dao.implementation;

import model.dao.GenericDAO;
import model.entity.Song;
import persistant.DatabaseConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SongDAO implements GenericDAO<Song> {
    private static final String GET_ALL = "SELECT * FROM db_for_db.song";
    private static final String GET_BY_ID = "SELECT * FROM db_for_db.song WHERE id=?";
    private static final String CREATE = "INSERT db_for_db.song "
            + "(`name`, `amount_of_likes`, `downloaded_amount`, `streaming`, playlist_id, artist_id) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE db_for_db.song"
            + " SET name=?, amount_of_likes=?, downloaded_amount=?, streaming=?, playlist_id=?, artist_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM db_for_db.song WHERE id=?";

    @Override
    public List<Song> findAll() throws SQLException {
        List<Song> songs = new ArrayList<>();
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ALL)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Song song = new Song(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("amount_of_likes"),
                        resultSet.getInt("downloaded_amount"),
                        resultSet.getInt("streaming"),
                        resultSet.getInt("playlist_id"),
                        resultSet.getInt("artist_id")
                );
                songs.add(song);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return songs;
    }

    @Override
    public Song findById(Integer id) throws SQLException {
        Song song = null;
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                song = new Song(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("amount_of_likes"),
                        resultSet.getInt("downloaded_amount"),
                        resultSet.getInt("streaming"),
                        resultSet.getInt("playlist_id"),
                        resultSet.getInt("artist_id")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return song;
    }

    @Override
    public void create(Song song) throws SQLException {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, String.valueOf(song.getName()));
            statement.setString(2, String.valueOf(song.getAmount_of_likes()));
            statement.setString(3, String.valueOf(song.getDownloaded_amount()));
            statement.setString(4, String.valueOf(song.getStreaming()));
            statement.setString(5, String.valueOf(song.getPlaylist_id()));
            statement.setString(6, String.valueOf(song.getArtist_id()));
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Integer id, Song song) throws SQLException {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(UPDATE)) {
            statement.setString(1, song.getName());
            statement.setInt(2, song.getAmount_of_likes());
            statement.setInt(3, song.getDownloaded_amount());
            statement.setInt(4, song.getStreaming());
            statement.setInt(5, song.getPlaylist_id());
            statement.setInt(6, song.getArtist_id());
            statement.setInt(7, song.getId());
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