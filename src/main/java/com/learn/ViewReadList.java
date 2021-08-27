package com.learn;

import java.util.List;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.learn.entity.ReadList;
import com.learn.entity.User;
import com.learn.jdbc.BookDao;

@WebServlet("/viewReadList")
public class ViewReadList extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookDao dao = new BookDao();

        User user = (User) request.getSession().getAttribute("user");

        List<ReadList> books = dao.viewListBookOfUser(user);

        HttpSession session = request.getSession();
        session.setAttribute("readList", books);

        String ctx = request.getContextPath();

        response.sendRedirect(ctx + "/jsp/read_list.jsp");
    }
}
