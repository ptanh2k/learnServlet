package com.learn.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.learn.DBconnect.DBconnect;
import com.learn.entity.User;

public class UserDao {
    private DBconnect dbc = new DBconnect();

    public void registerUser(User user) {
        String query = "INSERT INTO user " + "(user_name, email, password, role) VALUES " + "(?, ?, ?, ?)";
        int count = 0;
        try {
            Connection connection = dbc.getConnection();
            PreparedStatement stm = connection.prepareStatement(query);
            stm.setString(2, user.getUser_name());
            stm.setString(3, user.getEmail());
            stm.setString(4, user.getPassword());
            stm.setString(5, user.getRole());
            count = stm.executeUpdate();
            System.out.println(count + " row(s) affected");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbc.close();
        }
    }

    public void getUser(String email) {
        User user = new User();

        try {
            Connection connection = dbc.getConnection();
            String query = "SELECT * FROM user WHERE user_email = " + email;
            PreparedStatement stm = connection.prepareStatement(query);
            stm.setString(1, email);
            ResultSet result = stm.executeQuery();
            while (result.next()) {
                user.setEmail(result.getString(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbc.close();
        }
    }
}
