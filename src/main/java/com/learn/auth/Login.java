package com.learn.auth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.learn.entity.User;
import com.learn.jdbc.Dao;

@WebServlet("/login")
public class Login extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        String ctx = request.getContextPath();

        Dao dao = new Dao();

        User user = dao.getUser(email, password);

        if (dao.checkLogin(email, password)) {
            HttpSession session = request.getSession();
            session.setAttribute("email", email);
            session.setAttribute("user", user);
            response.sendRedirect(ctx + "/landing.jsp");
        } else {
            response.sendRedirect(ctx + "index.jsp");
        }
    }
}
