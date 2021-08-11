package com.learn;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learn.entity.Book;
import com.learn.jdbc.Dao;

@WebServlet("/getBookByCategory")
public class BookByCategoryServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Dao dao = new Dao();

        String category = request.getParameter("category");
        List<Book> books = dao.getBookByCategory(category);

        request.setAttribute("list_book_by_category", books);
        request.setAttribute("category", category);

        String url = "/jsp/book_category.jsp";

        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
    }
}
