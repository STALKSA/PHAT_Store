package com.example.phat_store_112.servlets.admin;

import com.example.phat_store_112.model.dao.brand.BrandService;
import com.example.phat_store_112.model.dao.brand.BrandServiceImplementation;
import com.example.phat_store_112.model.dao.item.ItemService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/admin")
public class AdminViewServlet extends HttpServlet {
    private BrandService brandService;

    @Override
    public void init() throws ServletException {
        brandService = new BrandServiceImplementation();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String entity = req.getParameter("entity");
        if (entity == null || entity.equals("")) {
            req
                    .getServletContext()
                    .getRequestDispatcher("/sources/pages/admin/admin.jsp")
                    .forward(req, resp);
        } else {
            switch (entity) {
                case "brands" -> completeBrandsRequest(req);
                case "categories" -> completeCategoriesRequest(req);
                case "items" -> completeItemsRequest(req);
            }
            req
                    .getServletContext()
                    .getRequestDispatcher("/sources/pages/admin/entities/".concat(entity).concat(".jsp"))
                    .forward(req, resp);
        }
    }

    private void completeBrandsRequest(HttpServletRequest req) {
        try {
            req.setAttribute("brands", brandService.all());
            req.setAttribute("formMethod", "POST");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void completeCategoriesRequest(HttpServletRequest req) {
//        req.setAttribute("categories", brandService.all());
    }

    private void completeItemsRequest(HttpServletRequest req) {
//        req.setAttribute("items", brandService.all());
    }

//    private void completeItemsRequest(HttpServletRequest req) {
//        try {
//            req.setAttribute("items", itemService.all());
//            req.setAttribute("formMethod", "POST");
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }

    @Override
    public void destroy() {
        try {
            brandService.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
