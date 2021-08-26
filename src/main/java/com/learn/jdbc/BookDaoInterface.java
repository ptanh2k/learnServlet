package com.learn.jdbc;

import java.util.List;

import com.learn.entity.Book;
import com.learn.entity.User;

public interface BookDaoInterface {
    public List<Book> searchBook(String title);

    public List<Book> getBooks();

    public List<Book> getBookByCategory(String category_name);

    public void addBookToList(User user, Book book);

}
