package com.google.hashcode.model;

import java.util.List;

public class Scores {
    private List<Book> books;

    public Scores(List<Book> books) {
        this.books = books;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
