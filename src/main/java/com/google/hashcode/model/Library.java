package com.google.hashcode.model;

public class Library {
    private Integer libraryId;
    private Integer numBooks;
    private Integer signupDays;
    private Integer booksToScanDays;

    public Library(Integer libraryId, Integer numBooks, Integer signupDays, Integer booksToScanDays) {
        this.libraryId = libraryId;
        this.numBooks = numBooks;
        this.signupDays = signupDays;
        this.booksToScanDays = booksToScanDays;
    }

    public Integer getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(Integer libraryId) {
        this.libraryId = libraryId;
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
