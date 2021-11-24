package controller.implementation;


import controller.GenericController;
import model.entity.Song;
import service.implementation.SongService;

import java.sql.SQLException;
import java.util.List;

public class SongController implements GenericController<Song> {

    SongService service = new SongService();

    @Override
    public List<Song> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public Song findById(Integer id) throws SQLException {
        return service.findById(id);
    }

    @Override
    public void create(Song entity) throws SQLException {
        service.create(entity);
    }

    @Override
    public void update(Integer id, Song entity) throws SQLException {
        service.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}