package com.example.phat_store_112.model.dao.brand;

import com.example.phat_store_112.model.entities.Brand;

import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BrandServiceImplementation implements BrandService{
    private Connection connection;

    String DB_URL = "jdbc:postgresql://localhost:5432/phat_store_112";
    String USERNAME = "postgres";
    String PASSWORD = "ItsMyLife0203";
    String DB_DRIVER = "org.postgresql.Driver";

    public BrandServiceImplementation() {
        try {
            initConnection();
        } catch (SQLException e) {
            System.out.println("подключение невозможно");
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            System.out.println("драйвер не подключен");
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            System.out.println("конфиг не найден");
            throw new RuntimeException(e);
        }
    }

    private void initConnection() throws FileNotFoundException, ClassNotFoundException, SQLException {
        Class.forName(DB_DRIVER);
        this.connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
    }



    @Override
    public List<Brand> all() {
        String query = "SELECT * FROM brands_t";
        List<Brand> all = new ArrayList<>();
        ResultSet resultSet;
        try {
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                all.add(new Brand(resultSet));
            }
            return all;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Brand> findById(int id) {
        return Optional.empty();
    }

    @Override
    public void close() throws SQLException {
        connection.close();
    }
}
