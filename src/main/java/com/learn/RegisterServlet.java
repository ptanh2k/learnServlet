package com.learn;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learn.entity.User;
import com.learn.jdbc.UserDao;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private UserDao userDao = new UserDao();

    public RegisterServlet() {
        super();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dp = request.getRequestDispatcher("/jsp/register.jsp");
        dp.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int user_id = Integer.parseInt(request.getParameter("user_id"));
        String user_name = request.getParameter("user_name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String role = request.getParameter("role");

        User user = new User();
        user.setUser_id(user_id);
        user.setUser_name(user_name);
        user.setEmail(email);
        user.setPassword(password);
        user.setRole(role);

        try {
            userDao.registerUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}