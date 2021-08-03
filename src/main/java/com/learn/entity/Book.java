package com.learn.entity;

public class Book {
    private int book_id;
    private String title;
    private String author;
    private int category_id;
    private int published_year;

    public Book(int book_id, String title, String author, int category_id, int published_year) {
        this.book_id = book_id;
        this.title = title;
        this.author = author;
        this.category_id = category_id;
        this.published_year = published_year;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public int getPublished_year() {
        return published_year;
    }

    public void setPublished_year(int published_year) {
        this.published_year = published_year;
    }
}
