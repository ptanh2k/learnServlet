package com.learn;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginForm extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String userName = request.getParameter("userName");

        PrintWriter out = response.getWriter();

        String docType = "<!DOCTYPE html>\n";

        String title = "BOOK MANAGEMENT SYSTEM";

        out.println(docType + "<html>\n" + "<head>" + "<title>" + title + "</title>\n" + "</head>\n" + "<body>"
                + "<h1>Welcome " + "<b>" + userName + ", " + email + ", " + password + "</b>" + "</h1>" + "</body>"
                + "</html>");
    }
}
