package com.learn.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.time.LocalDate;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.learn.DBconnect.DBconnect;
import com.learn.entity.Book;
import com.learn.entity.ReadList;
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
    public int addBookToList(User user, Book book) {
        Connection connection = null;

        LocalDate date = LocalDate.now();

        String sql = "INSERT INTO borrow_detail " + "(user_id, book_id, date_borrow) VALUES " + "(?, ?, ?);";

        int count = 0;

        try {
            connection = DBconnect.openConnection();
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, user.getUser_id());
            stm.setInt(2, book.getBook_id());
            stm.setDate(3, Date.valueOf(date));
            count = stm.executeUpdate();
            System.out.println(count + " row(s) affected");
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return count;
    }

    @Override
    public List<ReadList> viewListBookOfUser(User user) {
        Connection connection = null;

        List<ReadList> books = new ArrayList<ReadList>();

        String sql = "SELECT b.book_id, b.title, c.category_name, b.author, b.published_year, bd.date_borrow, bd.date_return_target "
                + "FROM user u " + "JOIN borrow_detail bd ON u.user_id = bd.user_id "
                + "JOIN book b ON bd.book_id = b.book_id " + "JOIN category c ON b.category_id = c.category_id "
                + "WHERE u.user_id = " + user.getUser_id();

        try {
            connection = DBconnect.openConnection();
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                books.add(new ReadList(rs.getInt("book_id"), rs.getString("title"), rs.getString("category_name"),
                        rs.getString("author"), rs.getInt("published_year"),
                        LocalDate.parse(rs.getString("date_borrow")),
                        LocalDate.parse(rs.getString("date_return_target"))));
            }
            for (int i = 0; i < books.size(); i++) {
                System.out.println(books.get(i).getBook_id());
                System.out.println(books.get(i).getTitle());
                System.out.println(books.get(i).getCategory_name());
                System.out.println(books.get(i).getAuthor());
                System.out.println(books.get(i).getPublished_year());
                System.out.println(books.get(i).getDate_borrow());
                System.out.println(books.get(i).getDate_return_target());
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return books;
    }
}
