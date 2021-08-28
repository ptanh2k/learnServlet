package com.learn;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learn.jdbc.BookDao;

@WebServlet("/returnBook")
public class ReturnBook extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookDao dao = new BookDao();

        int book_id = Integer.parseInt(request.getParameter("book_id"));

        int count = dao.returnBook(book_id);

        String ctx = request.getContextPath();

        if (count != 0) {
            response.sendRedirect(ctx + "/jsp/success.jsp");
        } else {
            response.sendRedirect(ctx + "/jsp/book_status.jsp");
        }
    }

}
