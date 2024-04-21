package com.example.phat_store_112.servlets.admin;

import com.example.phat_store_112.model.dao.brand.BrandService;
import com.example.phat_store_112.model.dao.brand.BrandServiceImplementation;
import com.example.phat_store_112.model.entities.Brand;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

@WebServlet("/admin/brands")
@MultipartConfig
public class BrandsServlet extends HttpServlet {
    private BrandService brandService;

    public BrandsServlet() {
        brandService = new BrandServiceImplementation();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setAttribute("brands", brandService.all());
            req.setAttribute("formMethod", "PUT");
            Optional<Brand> brand = brandService.findById(Integer.parseInt(req.getParameter("id")));
            req.setAttribute("brand", brand.orElse(null));
            req
                    .getServletContext()
                    .getRequestDispatcher("/sources/pages/admin/entities/brands.jsp")
                    .forward(req, resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String method = req.getParameter("method");
        if (method.equals("POST")) {
            brandService.save(new Brand(name));
        } else if (method.equals("PUT")) {
            doPut(req, resp);
        } else {
            doDelete(req, resp);
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) {
        Brand toUpdate = new Brand(Integer.parseInt(req.getParameter("id")), req.getParameter("name"));
        System.out.println(brandService.update(toUpdate));
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        brandService.deleteById(id);
    }

    @Override
    public void destroy() {
        try {
            brandService.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
