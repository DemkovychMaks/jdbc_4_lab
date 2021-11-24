package service.implementation;

import model.dao.implementation.CountryDAO;
import model.entity.Country;
import service.GenericService;

import java.sql.SQLException;
import java.util.List;

public class CountryService implements GenericService<Country> {

    private final CountryDAO dao = new CountryDAO();

    @Override
    public List<Country> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Country findById(Integer id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void create(Country entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, Country entity) throws SQLException {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}