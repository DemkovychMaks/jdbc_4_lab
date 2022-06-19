package service.implementation;

import model.dao.implementation.ArtistDAO;
import model.entity.Artist;
import service.GenericService;

import java.sql.SQLException;
import java.util.List;

public class ArtistService implements GenericService<Artist> {

    private final ArtistDAO dao = new ArtistDAO();

    @Override
    public List<Artist> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Artist findById(Integer id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void create(Artist entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, Artist entity) throws SQLException {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}