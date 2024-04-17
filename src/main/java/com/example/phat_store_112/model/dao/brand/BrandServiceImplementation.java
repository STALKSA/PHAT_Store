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
    public List<Brand> all() throws SQLException {
        String query = "SELECT * FROM brands_t;";
        List<Brand> all = new ArrayList<>();
        ResultSet resultSet = null;
        try {
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                all.add(new Brand(resultSet));
            }
            return all;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            assert resultSet != null;
            resultSet.close();
        }
    }

    @Override
    public Optional<Brand> findById(int id) throws SQLException {
        String query = String.format("SELECT * FROM brands_t WHERE (id = %d);", id);
        ResultSet resultSet = null;
        try {
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                return Optional.of(new Brand(resultSet));
            } else {
                return Optional.empty();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            assert resultSet != null;
            resultSet.close();
        }
    }

    @Override
    public Brand save(Brand brand) {
        String query = String.format("INSERT INTO brands_t (name) VALUES ('%s');", brand.getName());
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            return findByName(brand.getName());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Brand findByName(String name) throws SQLException {
        String query = String.format("SELECT * FROM brands_t WHERE (name = '%s')", name);
        ResultSet resultSet = null;
        try {
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            resultSet.next();
            return new Brand(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            assert resultSet != null;
            resultSet.close();
        }
    }

    @Override
    public boolean update(Brand brand) {
        String query = String.format("UPDATE brands_t SET name = '%s' WHERE (id = %d);",
                brand.getName(), brand.getId());
        try {
            Statement statement = connection.createStatement();
            if (findById(brand.getId()).isPresent()) {
                statement.executeUpdate(query);
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deleteById(int id) {
        String query = String.format("DELETE FROM brands_t WHERE (id = %d);", id);
        try {
            Statement statement = connection.createStatement();
            if (findById(id).isPresent()) {
                statement.executeUpdate(query);
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void close() throws SQLException {
        connection.close();
    }
}
