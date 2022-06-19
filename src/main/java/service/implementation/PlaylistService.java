package service.implementation;

import model.dao.implementation.PlaylistDAO;
import model.entity.Playlist;
import service.GenericService;

import java.sql.SQLException;
import java.util.List;

public class PlaylistService implements GenericService<Playlist> {

    private final PlaylistDAO dao = new PlaylistDAO();

    @Override
    public List<Playlist> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Playlist findById(Integer id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void create(Playlist entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, Playlist entity) throws SQLException {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}