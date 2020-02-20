package com.google.hashcode.service;

import com.google.hashcode.model.Library;
import com.google.hashcode.model.LibraryScoring;
import com.google.hashcode.model.Scores;
import com.google.hashcode.model.Summary;

import java.util.ArrayList;
import java.util.List;

public class LibraryService {
    private final static Double SCORING_NUM_BOOKS = 0.1;
    private final static Double SCORING_SIGNUP_DAYS = 0.2;
    private final static Double SCORING_SCAN_DAYS = 0.7;

    public List<LibraryScoring> getListScoring(){
        List<LibraryScoring> list = new ArrayList<>();

//        list.add(getLibraryScoring(score, library));

        return list;
    }

    private LibraryScoring getLibraryScoring(Scores scores, Library library) {
        return new LibraryScoring(library.getLibraryId(),
                library.getNumBooks() * SCORING_NUM_BOOKS
                + library.getSignupDays() * SCORING_SIGNUP_DAYS
                + library.getBooksToScanDays() * SCORING_SCAN_DAYS);
    }
}
