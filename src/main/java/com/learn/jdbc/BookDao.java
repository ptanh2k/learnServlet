package com.learn.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.learn.entity.Book;

public class BookDao implements BookDaoInterface {
    private static final String url = "jdbc:mysql://localhost:3306/book_sys";
    private static final String name = "root";
    private static final String password = "Anh988119@@@";

    private static final String driver = "com.mysql.cj.jdbc.Driver";

    @Override
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

    @Override
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

    @Override
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

    @Override
    public int addBookToList() {
        int count = 0;

        return count;
    }
}
