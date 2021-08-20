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
import com.learn.jdbc.BookDao;

@WebServlet("/getCategory")
public class CategoryServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookDao dao = new BookDao();
        List<Category> categories = dao.getCategories();

        request.setAttribute("list_category", categories);

        String ctx = request.getContextPath();

        String landing_url = "/landing.jsp";
        String category_url = "/jsp/category.jsp";

        // RequestDispatcher rd1 = request.getRequestDispatcher(ctx + landing_url);
        RequestDispatcher rd2 = request.getRequestDispatcher(category_url);
        // rd1.forward(request, response);
        rd2.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
