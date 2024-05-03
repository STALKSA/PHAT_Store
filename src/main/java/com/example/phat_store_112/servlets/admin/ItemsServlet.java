package com.example.phat_store_112.servlets.admin;

import com.example.phat_store_112.model.dao.item.ItemService;
import com.example.phat_store_112.model.dao.item.ItemServiceImplementation;
import com.example.phat_store_112.model.entities.Item;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

@WebServlet("/admin/items")
public class ItemsServlet extends HttpServlet {
    private ItemService itemService;

    public ItemsServlet() {
        itemService = new ItemServiceImplementation(); //добавить
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setAttribute("items", itemService.all());
            req.setAttribute("formMethod", "POST");
            Optional<Item> item = itemService.findById(Integer.parseInt(req.getParameter("id")));
            req.setAttribute("item", item.orElse(null));
            req.getRequestDispatcher("/sources/pages/admin/entities/items.jsp").forward(req, resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String model = req.getParameter("model");
        int price = Integer.parseInt(req.getParameter("price"));
        int amount = Integer.parseInt(req.getParameter("amount"));
        String size = req.getParameter("size");
        // ƒобавь другие пол€ в зависимости от вашей сущности Item

        Item newItem = new Item();
        newItem.setModel(model);
        newItem.setPrice(price);
        newItem.setAmount(amount);
        newItem.setSize(size);
        // ”станови другие пол€ сущности Item

        itemService.save(newItem);
        resp.sendRedirect(req.getContextPath() + "/admin/items");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int itemId = Integer.parseInt(req.getParameter("id"));
        String model = req.getParameter("model");
        int price = Integer.parseInt(req.getParameter("price"));
        int amount = Integer.parseInt(req.getParameter("amount"));
        String size = req.getParameter("size");
        // ƒобавь другие пол€ в зависимости от вашей сущности Item

        Item itemToUpdate = new Item();
        itemToUpdate.setModel(model);
        itemToUpdate.setPrice(price);
        itemToUpdate.setAmount(amount);
        itemToUpdate.setSize(size);
        // ”станови другие пол€ сущности Item

        itemService.update(itemToUpdate);
        resp.sendRedirect(req.getContextPath() + "/admin/items");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int itemId = Integer.parseInt(req.getParameter("id"));
        itemService.deleteById(itemId);
        resp.sendRedirect(req.getContextPath() + "/admin/items");
    }

    @Override
    public void destroy() {
        try {
            itemService.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

