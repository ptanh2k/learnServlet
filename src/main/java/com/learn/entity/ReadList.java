package com.learn.entity;

import java.time.LocalDate;

public class ReadList {
    private int book_id;
    private String title;
    private String category_name;
    private String author;
    private int published_year;
    private LocalDate date_borrow;
    private LocalDate date_return_target;

    public ReadList(int book_id, String title, String category_name, String author, int published_year,
            LocalDate date_borrow, LocalDate date_return_target) {
        this.book_id = book_id;
        this.title = title;
        this.category_name = category_name;
        this.author = author;
        this.published_year = published_year;
        this.date_borrow = date_borrow;
        this.date_return_target = date_return_target;
    };

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

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublished_year() {
        return published_year;
    }

    public void setPublished_year(int published_year) {
        this.published_year = published_year;
    }

    public LocalDate getDate_borrow() {
        return date_borrow;
    }

    public void setDate_borrow(LocalDate date_borrow) {
        this.date_borrow = date_borrow;
    }

    public LocalDate getDate_return_target() {
        return date_return_target;
    }

    public void setDate_return_target(LocalDate date_return_target) {
        this.date_return_target = date_return_target;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
