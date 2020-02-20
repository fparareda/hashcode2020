package com.google.hashcode.model;

import java.util.List;

public class Book {
    private Integer bookId;
    private Integer score;

    public Book(Integer bookId, Integer score) {
        this.bookId = bookId;
        this.score = score;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
