package com.learn.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.learn.DBconnect.DBconnect;
import com.learn.auth.HashedPass;
import com.learn.entity.User;

public class UserDao implements UserDaoInterface {
    HashedPass hashedPass = new HashedPass();

    @Override
    public int registerUser(User user) {
        String query = "INSERT INTO user " + "(user_name, email, password, hashed_password, role) VALUES "
                + " (?, ?, ?, ?, ?);";
        int count = 0;
        Connection connection = null;
        try {
            connection = DBconnect.openConnection();
            PreparedStatement stm = connection.prepareStatement(query);
            stm.setString(1, user.getUser_name());
            stm.setString(2, user.getEmail());
            stm.setString(3, user.getPassword());
            stm.setString(4, hashedPass.hashedPassword(user.getPassword()));
            stm.setString(5, user.getRole());
            count = stm.executeUpdate();
            System.out.println(count + " row(s) affected");
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public User getUser(String email, String pwd) {
        User user = new User();
        Connection connection = null;
        try {
            connection = DBconnect.openConnection();
            Statement stm = connection.createStatement();
            ResultSet result = stm.executeQuery(
                    "SELECT * FROM `user` WHERE email = '" + email + "'" + "AND password = '" + pwd + "'");
            if (result.next()) {
                user.setUser_id(result.getInt("user_id"));
                user.setUser_name(result.getString("user_name"));
                user.setEmail(result.getString("email"));
                user.setRole(result.getString("role"));
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public boolean checkLogin(String email, String pwd) {
        String query = "SELECT * FROM user WHERE email = ? AND password = ?";
        Connection connection = null;
        try {
            connection = DBconnect.openConnection();
            PreparedStatement stm = connection.prepareStatement(query);
            stm.setString(1, email);
            stm.setString(2, pwd);
            ResultSet result = stm.executeQuery();
            if (result.next()) {
                return true;
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
