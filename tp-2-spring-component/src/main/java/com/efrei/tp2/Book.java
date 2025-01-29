package com.efrei.tp2;

public class Book {
    private String isbn;
    private String title;
    private String author;
    private boolean isRented;
    private String rentedBy;

    // Constructors, Getters, and Setters
    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.isRented = false;
        this.rentedBy = null;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
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

    public boolean isRented() {
        return isRented;
    }

    public void setRented(boolean rented) {
        isRented = rented;
    }

    public String getRentedBy() {
        return rentedBy;
    }

    public void setRentedBy(String rentedBy) {
        this.rentedBy = rentedBy;
    }
}
