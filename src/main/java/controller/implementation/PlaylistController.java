package controller.implementation;

import controller.GenericController;
import model.entity.Playlist;
import service.implementation.PlaylistService;

import java.sql.SQLException;
import java.util.List;

public class PlaylistController implements GenericController<Playlist> {

    PlaylistService service = new PlaylistService();

    @Override
    public List<Playlist> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public Playlist findById(Integer id) throws SQLException {
        return service.findById(id);
    }

    @Override
    public void create(Playlist entity) throws SQLException {
        service.create(entity);
    }

    @Override
    public void update(Integer id, Playlist entity) throws SQLException {
        service.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}
