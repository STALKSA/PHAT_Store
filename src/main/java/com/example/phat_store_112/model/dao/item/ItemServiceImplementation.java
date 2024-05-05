package com.example.phat_store_112.model.dao.item;

import com.example.phat_store_112.model.entities.Item;

import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ItemServiceImplementation implements ItemService {
    private Connection connection;

    String DB_URL = "jdbc:postgresql://localhost:5432/phat_store_112";
    String USERNAME = "postgres";
    String PASSWORD = "123";
    String DB_DRIVER = "org.postgresql.Driver";

    public ItemServiceImplementation() {
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
    public List<Item> all() throws SQLException {
        String query = "SELECT * FROM items;";
        List<Item> allItems = new ArrayList<>();
        ResultSet resultSet = null;
        try {
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                allItems.add(new Item());
            }
            return allItems;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            assert resultSet != null;
            resultSet.close();
        }
    }

    @Override
    public Optional<Item> findById(int id) throws SQLException {
        String query = String.format("SELECT * FROM items WHERE (id = %d);", id);
        ResultSet resultSet = null;
        try {
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                return Optional.of(new Item());
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
    public Item save(Item item) {
        String query = String.format("INSERT INTO items (model, price, amount, size) VALUES ('%s', %d, %d, '%s');",
                item.getModel(), item.getPrice(), item.getAmount(), item.getSize());
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            return findByModel(item.getModel());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Item findByModel(String model) throws SQLException {
        String query = String.format("SELECT * FROM items WHERE (model = '%s')", model);
        ResultSet resultSet = null;
        try {
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            resultSet.next();
            return new Item();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            assert resultSet != null;
            resultSet.close();
        }
    }
    @Override
    public boolean update(Item item) {
        String query = String.format("UPDATE items SET model = '%s', price = %d, amount = %d, size = '%s' WHERE (id = %d);",
                item.getModel(), item.getPrice(), item.getAmount(), item.getSize(), item.getId());
        try {
            Statement statement = connection.createStatement();
            if (findById(item.getId()).isPresent()) {
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
        String query = String.format("DELETE FROM items WHERE (id = %d);", id);
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