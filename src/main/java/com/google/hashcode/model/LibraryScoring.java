package com.google.hashcode.model;

public class LibraryScoring {
    private Integer libraryId;
    private Double scoring;

    public LibraryScoring(Integer libraryId, Double scoring) {
        this.libraryId = libraryId;
        this.scoring = scoring;
    }

    public Integer getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(Integer libraryId) {
        this.libraryId = libraryId;
    }

    public Double getScoring() {
        return scoring;
    }

    public void setScoring(Double scoring) {
        this.scoring = scoring;
    }
}
