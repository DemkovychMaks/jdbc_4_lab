package controller.implementation;

import controller.GenericController;
import model.entity.Library;
import service.implementation.LibraryService;

import java.sql.SQLException;
import java.util.List;

public class LibraryController implements GenericController<Library> {

    LibraryService service = new LibraryService();

    @Override
    public List<Library> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public Library findById(Integer id) throws SQLException {
        return service.findById(id);
    }

    @Override
    public void create(Library entity) throws SQLException {
        service.create(entity);
    }

    @Override
    public void update(Integer id, Library entity) throws SQLException {
        service.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}