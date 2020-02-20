package com.google.hashcode.model;

public class Summary {
    private Integer books;
    private Integer libraries;
    private Integer days;

    public Summary(Integer books, Integer libraries, Integer days) {
        this.books = books;
        this.libraries = libraries;
        this.days = days;
    }

    public Integer getBooks() {
        return books;
    }

    public void setBooks(Integer books) {
        this.books = books;
    }

    public Integer getLibraries() {
        return libraries;
    }

    public void setLibraries(Integer libraries) {
        this.libraries = libraries;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }
}
