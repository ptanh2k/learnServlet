package com.learn.jdbc;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.learn.DBconnect.DBconnect;
import com.learn.entity.Book;
import com.learn.entity.User;

public class BookDao implements BookDaoInterface {
    @Override
    public List<Book> searchBook(String title) {
        List<Book> books = new ArrayList<Book>();
        Connection connection = null;
        try {
            connection = DBconnect.openConnection();
            Statement stm = connection.createStatement();
            ResultSet result = stm.executeQuery("SELECT * FROM book WHERE title LIKE '" + title + "%'");
            while (result.next()) {
                books.add(new Book(result.getInt("book_id"), result.getString("title"), result.getString("author"),
                        result.getInt("category_id"), result.getInt("published_year")));
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return books;
    }

    @Override
    public List<Book> getBooks() {
        List<Book> books = new ArrayList<Book>();
        Connection connection = null;

        try {
            connection = DBconnect.openConnection();
            Statement stm = connection.createStatement();
            ResultSet result = stm.executeQuery("SELECT * FROM book");
            while (result.next()) {
                books.add(new Book(result.getInt("book_id"), result.getString("title"), result.getString("author"),
                        result.getInt("category_id"), result.getInt("published_year")));
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return books;
    }

    @Override
    public List<Book> getBookByCategory(String category_name) {
        List<Book> books = new ArrayList<Book>();
        Connection connection = null;

        String sql = "SELECT b.*, c.category_name FROM book b JOIN category c ON b.category_id = c.category_id AND c.category_name = "
                + "'" + category_name + "'";

        try {
            connection = DBconnect.openConnection();
            Statement stm = connection.createStatement();
            ResultSet result = stm.executeQuery(sql);
            while (result.next()) {
                books.add(new Book(result.getInt("book_id"), result.getString("title"), result.getString("author"),
                        result.getInt("category_id"), result.getInt("published_year")));
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return books;
    }

    @Override
    public void addBookToList(User user, Book book) {
        Connection connection = null;

        String sql = "UPDATE borrow_detail SET book_id = " + book.getBook_id() + ", user_id = " + user.getUser_id()
                + " WHERE ";
    }
}
