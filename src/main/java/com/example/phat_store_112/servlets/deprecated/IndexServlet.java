package com.example.phat_store_112.servlets.deprecated;

import com.example.phat_store_112.model.dao.category.CategoryService;
import com.example.phat_store_112.model.dao.category.CategoryServiceImplementation;
import com.example.phat_store_112.model.entities.Category;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.*;

//@WebServlet(name = "indexServlet", value = "/index")
public class IndexServlet extends HttpServlet {
    private CategoryService categoryService;

    public void init() {
        categoryService = new CategoryServiceImplementation();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("application/json; charset=UTF-8");
        List<Category> all = null;
        try {
            all = categoryService.all();
            PrintWriter out = response.getWriter();
            out.println(getJSON(all));
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String getJSON(Object object) {
        GsonBuilder jBuilder = new GsonBuilder();
        Gson result = jBuilder.create();
        return result.toJson(object);
    }


    public void destroy() {
        try {
            categoryService.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}