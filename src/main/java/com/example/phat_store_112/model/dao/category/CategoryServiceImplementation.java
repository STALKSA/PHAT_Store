package com.example.phat_store_112.model.dao.category;

import com.example.phat_store_112.model.entities.Category;
import com.jcabi.xml.XML;
import com.jcabi.xml.XMLDocument;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CategoryServiceImplementation implements CategoryService {
    private final String configPath = System.getProperty("user.dir") + "/config.xml";
    private Connection connection;

    public CategoryServiceImplementation() {
        System.out.println(configPath);
        try {
            initConnection(configPath);
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

    private void initConnection(String configFile) throws ClassNotFoundException, SQLException, FileNotFoundException {
        File configurationFile = new File(configFile);
        XML config = new XMLDocument(configurationFile);
        Class.forName(config.xpath("//db/driver/text()").get(0));
        this.connection = DriverManager.getConnection(
                config.xpath("//db/url/text()").get(0),
                config.xpath("//db/username/text()").get(0),
                config.xpath("//db/password/text()").get(0));
    }


    @Override
    public List<Category> all() {
        String query = "SELECT * FROM categories_t";
        List<Category> all = new ArrayList<>();
        ResultSet resultSet;
        try {
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                all.add(new Category(resultSet));
            }
            return all;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Category> findById(int id) {
        return Optional.empty();
    }

    @Override
    public Category save(Category category) {
        return null;
    }

    @Override
    public boolean update(Category category) {
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }

    @Override
    public void close() throws SQLException {
        this.connection.close();
    }
}
