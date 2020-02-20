package com.google.hashcode.model;

public class Library {
    private Integer numBooks;
    private Integer signupDays;
    private Integer booksToScanDays;

    public Library(Integer numBooks, Integer signupDays, Integer booksToScanDays) {
        this.numBooks = numBooks;
        this.signupDays = signupDays;
        this.booksToScanDays = booksToScanDays;
    }

    public Integer getNumBooks() {
        return numBooks;
    }

    public void setNumBooks(Integer numBooks) {
        this.numBooks = numBooks;
    }

    public Integer getSignupDays() {
        return signupDays;
    }

    public void setSignupDays(Integer signupDays) {
        this.signupDays = signupDays;
    }

    public Integer getBooksToScanDays() {
        return booksToScanDays;
    }

    public void setBooksToScanDays(Integer booksToScanDays) {
        this.booksToScanDays = booksToScanDays;
    }
}
