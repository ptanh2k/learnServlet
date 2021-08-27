package com.learn;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learn.entity.Book;
import com.learn.entity.User;
import com.learn.jdbc.BookDao;

@WebServlet("/addBookToList")
public class AddBookServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookDao dao = new BookDao();

        int book_id = Integer.parseInt(request.getParameter("book_id"));
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        int category_id = Integer.parseInt(request.getParameter("category_id"));
        int published_year = Integer.parseInt(request.getParameter("published_year"));

        Book book = new Book();
        book.setBook_id(book_id);
        book.setTitle(title);
        book.setAuthor(author);
        book.setCategory_id(category_id);
        book.setPublished_year(published_year);

        User user = (User) request.getSession().getAttribute("user");

        dao.addBookToList(user, book);

        String ctx = request.getContextPath();

        response.sendRedirect(ctx + "/jsp/success.jsp");

    }
}
