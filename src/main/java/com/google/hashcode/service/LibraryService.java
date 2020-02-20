package com.google.hashcode.service;

import com.google.hashcode.model.*;
import com.google.hashcode.output.Writer;

import java.util.*;
import java.util.stream.Collectors;

public class LibraryService {
    private final static Double SCORING_NUM_BOOKS = 0.1;
    private final static Double SCORING_SIGNUP_DAYS = 0.2;
    private final static Double SCORING_SCAN_DAYS = 0.7;

    public void storeList(String output, List<Library> libraries, Map<Integer, Integer> scores) {
        Writer writer = new Writer(output);
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<LibraryScoring> librariesSorted = getListScoring(libraries, scores);
        for(LibraryScoring libraryScoring : librariesSorted) {
            map.put(libraryScoring.getLibraryId(), libraryScoring.getOrderedBooks());
        }
        writer.print(map);
    }

    public List<LibraryScoring> getListScoring(List<Library> libraries, Map<Integer, Integer> scores){
        List<LibraryScoring> orderedLibraries = libraries.parallelStream()
                .map(library -> getLibraryScoring(scores, library))
                .collect(Collectors.toList());

        Collections.sort(orderedLibraries, new Comparator<LibraryScoring>() {
            @Override
            public int compare(LibraryScoring b1, LibraryScoring b2) {
                return b1.getScoring().compareTo(b2.getScoring());
            }
        });
        return orderedLibraries;
    }

    private LibraryScoring getLibraryScoring(Map<Integer, Integer> scores, Library library) {
        return new LibraryScoring(library.getLibraryId(),
                library.getBooks(),
                calculateScore(library.getBooks(), scores) * SCORING_NUM_BOOKS
                + library.getSignupDays() * SCORING_SIGNUP_DAYS
                + library.getBooksToScanDays() * SCORING_SCAN_DAYS);
    }
    private Integer calculateScore(List<Book> books, Map<Integer, Integer> scores){
        return books.parallelStream()
                .mapToInt(book -> scores.get(book.getBookId()))
                .sum();
    }
}
