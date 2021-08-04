package com.learn;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learn.entity.Book;
import com.learn.jdbc.BookDao;

@WebServlet("/getBook")
public class BookServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int book_id = Integer.parseInt(request.getParameter("book_id"));
        BookDao dao = new BookDao();
        Book book = dao.getBook(book_id);

        request.setAttribute("book", book);

        String url = "/jsp/book.jsp";

        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
    }
}
