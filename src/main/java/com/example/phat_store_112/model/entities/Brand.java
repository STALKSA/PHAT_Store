package com.example.phat_store_112.model.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
public class Brand extends BaseEntity {
    private String name;

    public Brand() {
        super(-1);
    }

    public Brand(String name) {
        super(-1);
        this.name = name;
    }

    public Brand(ResultSet resultSet) throws SQLException {
        super(resultSet.getInt("id"));
        try {
            setName(resultSet.getString("name"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Brand(int id, String name) {
        super(id);
        this.name = name;
    }
}
