package service.implementation;

import model.dao.implementation.LibraryDAO;
import model.entity.Library;
import service.GenericService;

import java.sql.SQLException;
import java.util.List;

public class LibraryService implements GenericService<Library> {

    private final LibraryDAO dao = new LibraryDAO();

    @Override
    public List<Library> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Library findById(Integer id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void create(Library entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, Library entity) throws SQLException {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}