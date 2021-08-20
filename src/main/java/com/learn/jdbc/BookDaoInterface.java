package com.learn.jdbc;

import java.util.List;

import com.learn.entity.Book;

public interface BookDaoInterface {
    public Book searchBook(String title);

    public List<Book> getBooks();

    public List<Book> getBookByCategory(String category_name);

    public int addBookToList();

}
