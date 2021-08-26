package com.learn;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learn.entity.Category;
import com.learn.jdbc.CategoryDao;

@WebServlet("/getCategory")
public class CategoryServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoryDao dao = new CategoryDao();
        List<Category> categories = dao.getCategories();

        request.setAttribute("list_category", categories.get(1));

        String ctx = request.getContextPath();

        String url = "/landing.jsp";

        RequestDispatcher rd = request.getRequestDispatcher(ctx + url);
        rd.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
