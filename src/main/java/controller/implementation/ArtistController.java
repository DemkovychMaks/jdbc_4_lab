package controller.implementation;

import controller.GenericController;
import model.entity.Artist;
import service.implementation.ArtistService;

import java.sql.SQLException;
import java.util.List;

public class ArtistController implements GenericController<Artist> {

    ArtistService service = new ArtistService();

    @Override
    public List<Artist> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public Artist findById(Integer id) throws SQLException {
        return service.findById(id);
    }

    @Override
    public void create(Artist entity) throws SQLException {
        service.create(entity);
    }

    @Override
    public void update(Integer id, Artist entity) throws SQLException {
        service.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}
