package com.google.hashcode.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LibraryScoring {
    private Integer libraryId;
    private List<Book> books;
    private Double scoring;

    public LibraryScoring(Integer libraryId, List<Book> books, Double scoring) {
        this.libraryId = libraryId;
        this.books = books;
        this.scoring = scoring;
    }

    public Integer getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(Integer libraryId) {
        this.libraryId = libraryId;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Double getScoring() {
        return scoring;
    }

    public void setScoring(Double scoring) {
        this.scoring = scoring;
    }

    public List<Integer> getOrderedBooks() {
         Collections.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book b1, Book b2) {
                return b1.getScore().compareTo(b2.getScore());
            }
        });
         return books.stream()
                 .map(Book::getScore)
                 .collect(Collectors.toList());
    }
}
