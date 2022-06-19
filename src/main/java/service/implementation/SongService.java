package service.implementation;

import model.dao.implementation.SongDAO;
import model.entity.Song;
import service.GenericService;

import java.sql.SQLException;
import java.util.List;

public class SongService implements GenericService<Song> {

    private final SongDAO dao = new SongDAO();

    @Override
    public List<Song> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Song findById(Integer id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void create(Song entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, Song entity) throws SQLException {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}
