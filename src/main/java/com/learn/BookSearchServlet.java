package com.learn;

import java.util.List;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learn.entity.Book;
import com.learn.jdbc.BookDao;

@WebServlet("/searchBook")
public class BookSearchServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String input_title = request.getParameter("title");
        String title = input_title.trim();
        BookDao dao = new BookDao();
        List<Book> books = dao.searchBook(title);

        request.setAttribute("books", books);

        String url = "/jsp/book.jsp";

        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
