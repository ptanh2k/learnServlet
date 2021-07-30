package com.learn;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Demo extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String email = (String) request.getAttribute("email");
        String password = (String) request.getAttribute("password");
        String userName = (String) request.getAttribute("userName");

        PrintWriter out = response.getWriter();

        out.println("Email: " + email);
        out.println("Password: " + password);
        out.println("User: " + userName);

    }
}