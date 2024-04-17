package com.example.phat_store_112.model.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface DAO<T> {
    List<T> all();

    Optional<T> findById(int id);

    void close() throws SQLException;
}
