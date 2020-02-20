package com.google.hashcode.service;

import com.google.hashcode.model.*;
import com.google.hashcode.output.Writer;

import java.util.*;
import java.util.stream.Collectors;

public class LibraryService {
    private final static Double SCORING_NUM_BOOKS = 0.1;
    private final static Double SCORING_SIGNUP_DAYS = 0.9;
    private final static Double SCORING_SCAN_DAYS = 0.9;

    public void storeList(String output, List<Library> libraries, Map<Integer, Integer> scores) {
        Writer writer = new Writer(output);
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<LibraryScoring> librariesSorted = getListScoring(libraries, scores);

        double value = librariesSorted.size() * 0.2;
        librariesSorted = librariesSorted.subList(0, ((Long)Math.round(value)).intValue());

        for(LibraryScoring libraryScoring : librariesSorted) {
            map.put(libraryScoring.getLibraryId(), libraryScoring.getOrderedBooks());
        }
        writer.print(map);
    }

    public List<LibraryScoring> getListScoring(List<Library> libraries, Map<Integer, Integer> scores){
        List<LibraryScoring> orderedLibraries = libraries.parallelStream()
                .map(library -> getLibraryScoring(scores, library))
                .collect(Collectors.toList());

        Collections.sort(orderedLibraries, (b1, b2) -> b2.getScoring().compareTo(b1.getScoring()));
        return orderedLibraries;
    }

    private LibraryScoring getLibraryScoring(Map<Integer, Integer> scores, Library library) {
        return new LibraryScoring(library.getLibraryId(),
                library.getBooks(),
                Double.valueOf(calculateScore(library.getBooks(), scores)));
    }
    private Integer calculateScore(List<Book> books, Map<Integer, Integer> scores){
        return books.parallelStream()
                .mapToInt(book -> scores.get(book.getBookId()))
                .sum();
    }
}
