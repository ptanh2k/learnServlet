package com.learn.jdbc;

import java.util.List;

import com.learn.entity.Book;
import com.learn.entity.ReadList;
import com.learn.entity.User;

public interface BookDaoInterface {
    public List<Book> searchBook(String title);

    public List<Book> getBooks();

    public List<Book> getBookByCategory(String category_name);

    public int addBookToList(User user, Book book);

    public List<ReadList> viewListBookOfUser(User user);

}
