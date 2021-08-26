package com.learn;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learn.jdbc.BookDao;

@WebServlet("/addBookToList")
public class AddBookServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookDao dao = new BookDao();

        int book_id = Integer.parseInt(request.getParameter("book_id"));
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        int published_year = Integer.parseInt(request.getParameter("published_year"));

    }
}
