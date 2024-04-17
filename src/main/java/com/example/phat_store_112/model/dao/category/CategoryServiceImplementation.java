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
    private Connection connection;

    String DB_URL = "jdbc:postgresql://localhost:5432/phat_store_112";
    String USERNAME = "postgres";
    String PASSWORD = "ItsMyLife0203";
    String DB_DRIVER = "org.postgresql.Driver";

    public CategoryServiceImplementation() {
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

//    private void initConnection(String configFile) throws FileNotFoundException, ClassNotFoundException, SQLException {
//        XML config = new XMLDocument(new File(configFile));
//        Class.forName(config.xpath("//db/driver/text()").get(0));
//        this.connection = DriverManager.getConnection(
//                config.xpath("//db/url/text()").get(0),
//                config.xpath("//db/username/text()").get(0),
//                config.xpath("//db/password/text()").get(0));
//    }


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
    public void close() throws SQLException {
        this.connection.close();
    }
}
