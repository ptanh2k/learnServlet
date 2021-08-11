package com.learn.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.learn.entity.Book;
import com.learn.entity.Category;
import com.learn.entity.User;

public class Dao {
    private static final String url = "jdbc:mysql://localhost:3306/book_sys";
    private static final String name = "root";
    private static final String password = "Anh988119@@@";

    private static final String driver = "com.mysql.cj.jdbc.Driver";

    public Book searchBook(String title) {
        Book book = new Book();
        try {
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url, name, password);
            Statement stm = connection.createStatement();
            ResultSet result = stm.executeQuery("SELECT * FROM book WHERE title LIKE '" + title + "%'");
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

    public List<Category> getCategories() {
        List<Category> categories = new ArrayList<Category>();

        try {
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url, name, password);
            Statement stm = connection.createStatement();
            ResultSet result = stm.executeQuery("SELECT * FROM category");
            while (result.next()) {
                categories.add(new Category(result.getInt("category_id"), result.getString("category_name")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return categories;
    }

    public List<Book> getBookByCategory(String category_name) {
        List<Book> books = new ArrayList<Book>();

        String sql = "SELECT b.*, c.category_name FROM book b JOIN category c ON b.category_id = c.category_id AND c.category_name = "
                + "'" + category_name + "'";

        try {
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url, name, password);
            Statement stm = connection.createStatement();
            ResultSet result = stm.executeQuery(sql);
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
        String query = "INSERT INTO user " + "(user_name, email, password, role) VALUES (?, ?, ?, ?)";
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

    public User getUser(String email, String password) {
        User user = new User();

        try {
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url, name, password);
            Statement stm = connection.createStatement();
            ResultSet result = stm.executeQuery(
                    "SELECT * FROM `user` WHERE email = '" + email + "'" + "AND password = '" + password + "'");
            if (result.next()) {
                user.setUser_id(result.getInt("user_id"));
                user.setUser_name(result.getString("user_name"));
                user.setEmail(result.getString("email"));
                user.setRole(result.getString("role"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }

    public boolean checkLogin(String email, String pwd) {
        String query = "SELECT * FROM user WHERE email = ? AND password = ?";

        try {
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url, name, password);
            PreparedStatement stm = connection.prepareStatement(query);
            stm.setString(1, email);
            stm.setString(2, pwd);
            ResultSet result = stm.executeQuery();
            if (result.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
