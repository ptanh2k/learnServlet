package com.learn.entity;

public class BookList {
    private int userId;
    private int bookId;
    private int quantity;

    private String date_borrow;
    private String date_return_target;
    private String date_return_real;

    public BookList() {
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setDate_borrow(String date_borrow) {
        this.date_borrow = date_borrow;
    }

    public String getDate_borrow() {
        return date_borrow;
    }

    public void setDate_return_target(String date_return_target) {
        this.date_return_target = date_return_target;
    }

    public String getDate_return_target() {
        return date_return_target;
    }

    public void setDate_return_real(String date_return_real) {
        this.date_return_real = date_return_real;
    }

    public String getDate_return_real() {
        return date_return_real;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
