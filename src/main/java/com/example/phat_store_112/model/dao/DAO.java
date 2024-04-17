package com.example.phat_store_112.model.dao;

import com.example.phat_store_112.model.entities.Item;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface DAO<T> {
    List<T> all() throws SQLException;

    Optional<T> findById(int id) throws SQLException;

    T save(T t);

    boolean update(T t);

    boolean deleteById(int id);

    void close() throws SQLException;
}
