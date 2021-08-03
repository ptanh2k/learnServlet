package com.learn.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.learn.entity.User;

public class UserDao {
    private String url = "jdbc:mysql://localhost:3306/book_sys";
    private String name = "root";
    private String password = "Anh988119@@@";

    public void registerUser(User user) {
        String query = "INSERT INTO user " + "(user_name, email, password, role) VALUES " + "(?, ?, ?, ?)";
        int count = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, name, password);
            PreparedStatement stm = connection.prepareStatement(query);
            stm.setString(2, user.getUser_name());
            stm.setString(3, user.getEmail());
            stm.setString(4, user.getPassword());
            stm.setString(5, user.getRole());

            count = stm.executeUpdate();

            System.out.println(count + " row(s) affected");

            stm.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getUser(String email) {
        User user = new User();

        try {
            Connection connection = DriverManager.getConnection(url, name, password);
            String query = "SELECT * FROM user WHERE user_email = " + email;
            PreparedStatement stm = connection.prepareStatement(query);
            stm.setString(1, email);
            ResultSet result = stm.executeQuery();
            while (result.next()) {
                user.setEmail(result.getString(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
