package com.google.hashcode.service;

import com.google.hashcode.model.*;
import com.google.hashcode.output.Writer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LibraryService {
    private final static Double SCORING_NUM_BOOKS = 0.1;
    private final static Double SCORING_SIGNUP_DAYS = 0.2;
    private final static Double SCORING_SCAN_DAYS = 0.7;

    public void storeList(){
        Writer writer = new Writer();
        //    idLibrary, listOfBooksId
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<LibraryScoring> libraries = getListScoring();
        for(LibraryScoring libraryScoring : libraries) {
            map.put(libraryScoring.getLibraryId(), libraryScoring.getOrderedBooks());
        }

        writer.print(map);
    }

    public List<LibraryScoring> getListScoring(){
        List<LibraryScoring> list = new ArrayList<>();

//        list.add(getLibraryScoring(score, library));

        return list;
    }

    private LibraryScoring getLibraryScoring(Scores scores, Library library) {
        return new LibraryScoring(library.getLibraryId(),
                library.getBooks(),
                library.getNumBooks() * SCORING_NUM_BOOKS
                + library.getSignupDays() * SCORING_SIGNUP_DAYS
                + library.getBooksToScanDays() * SCORING_SCAN_DAYS);
    }
}
