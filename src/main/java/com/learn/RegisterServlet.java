package com.learn;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learn.entity.User;
import com.learn.jdbc.Dao;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Dao dao = new Dao();

        String ctx = request.getContextPath();

        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String role = request.getParameter("role");

        User user = new User();
        user.setUser_name(username);
        user.setEmail(email);
        user.setPassword(password);
        user.setRole(role);

        try {
            dao.registerUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect(ctx + "/index.jsp");

    }
}