package com.example.phat_store_112.servlets;

import com.example.phat_store_112.model.dao.category.CategoryService;
import com.example.phat_store_112.model.dao.category.CategoryServiceImplementation;
import com.example.phat_store_112.model.entities.Category;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/home")
public class HomepageServlet extends HttpServlet {
    private CategoryService categoryService;

    @Override
    public void init() {
        categoryService = new CategoryServiceImplementation();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        List<Category> all = categoryService.all();
        req.setAttribute("categories", all);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/sources/pages/home.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    public void destroy() {
        try {
            categoryService.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
