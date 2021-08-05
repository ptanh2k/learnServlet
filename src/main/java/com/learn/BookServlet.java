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

@WebServlet("/getBook")
public class BookServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int book_id = Integer.parseInt(request.getParameter("book_id"));
        Dao dao = new Dao();
        Book book = dao.getBook(book_id);
        List<Book> books = dao.getBooks();

        request.setAttribute("book", book);
        request.setAttribute("books", books);

        String url = "/jsp/book.jsp";

        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
