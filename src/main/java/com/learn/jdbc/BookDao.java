package com.learn.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.learn.entity.Book;

public class BookDao {
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
}
