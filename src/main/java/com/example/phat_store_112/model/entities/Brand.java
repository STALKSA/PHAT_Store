package com.example.phat_store_112.model.entities;

import lombok.Data;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
public class Brand extends BaseEntity {
    private String name;

    public Brand(ResultSet resultSet) {
        try {
            setId(resultSet.getInt("id"));
            setName(resultSet.getString("name"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
