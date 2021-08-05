package com.learn.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.learn.entity.Book;
import com.learn.entity.User;

public class Dao {
    private static final String url = "jdbc:mysql://localhost:3306/book_sys";
    private static final String name = "root";
    private static final String password = "Anh988119@@@";

    private static final String driver = "com.mysql.cj.jdbc.Driver";

    public Book getBook(int id) {
        Book book = new Book();
        try {
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url, name, password);
            Statement stm = connection.createStatement();
            ResultSet result = stm.executeQuery("SELECT * FROM book WHERE book_id = " + id);
            if (result.next()) {
                book.setBook_id(result.getInt("book_id"));
                book.setTitle(result.getString("title"));
                book.setAuthor(result.getString("author"));
                book.setCategory_id(result.getInt("category_id"));
                book.setPublished_year(result.getInt("published_year"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return book;
    }

    public List<Book> getBooks() {
        List<Book> books = new ArrayList<Book>();

        try {
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url, name, password);
            Statement stm = connection.createStatement();
            ResultSet result = stm.executeQuery("SELECT * FROM book");
            while (result.next()) {
                books.add(new Book(result.getInt("book_id"), result.getString("title"), result.getString("author"),
                        result.getInt("category_id"), result.getInt("published_year")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return books;
    }

    public void registerUser(User user) {
        String query = "INSERT INTO user " + "(user_name, email, password, role) VALUES " + "(?, ?, ?, ?)";
        int count = 0;
        try {
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url, name, password);
            PreparedStatement stm = connection.prepareStatement(query);
            stm.setString(2, user.getUser_name());
            stm.setString(3, user.getEmail());
            stm.setString(4, user.getPassword());
            stm.setString(5, user.getRole());
            count = stm.executeUpdate();
            System.out.println(count + " row(s) affected");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getUser(String email) {
        User user = new User();

        try {
            Class.forName(driver);
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
