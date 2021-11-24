package model.dao;

import java.sql.SQLException;
import java.util.List;

public interface GenericDAO<E> {

    List<E> findAll() throws SQLException;

    default E findById(Integer id) throws SQLException {
        return null;
    }

    default void create(E entity) throws SQLException {}

    default void update(Integer id, E entity) throws SQLException {}

    default void delete(Integer id) throws SQLException {}


    default E findByName(String name) throws SQLException {
        return null;
    }

    default void update(String name, E entity) throws SQLException {}

    default void delete(String name) throws SQLException {}
}