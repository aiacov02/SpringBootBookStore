package com.example.bookstore.entity;

public class Book {
    private long id;

    private String title;

    private String author;

    private String genre;

    private short rating;

    public Book(long id, String title, String author, String genre, short rating) {
        this.id = id;
        this.rating = rating;
        this.genre = genre;
        this.author = author;
        this.title = title;
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public short getRating() {
        return rating;
    }

    public void setRating(short rating) {
        this.rating = rating;
    }

    public long getId() {
        return id;
    }
}
