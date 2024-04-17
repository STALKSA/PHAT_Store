package com.example.phat_store_112.model.entities;

import lombok.Data;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
public class Category extends BaseEntity {
    private String name;

    public Category(ResultSet resultSet) throws SQLException {
        super(resultSet.getInt("id"));
        try {
            this.name = resultSet.getString("name");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
