package controller.implementation;

import controller.GenericController;
import model.entity.Artist;
import model.entity.Country;
import model.entity.Library;
import service.implementation.CountryService;


import java.sql.SQLException;
import java.util.List;

public class CountryController implements GenericController<Country> {

    CountryService service = new CountryService();

    @Override
    public List<Country> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public void create(Country entity) throws SQLException {
        service.create(entity);
    }

    @Override
    public Country findById(Integer id) throws SQLException {
        return service.findById(id);
    }
    @Override
    public void update(Integer id, Country entity) throws SQLException {
        service.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}
