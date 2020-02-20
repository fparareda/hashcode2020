package com.google.hashcode;

import com.google.hashcode.model.Book;
import com.google.hashcode.model.Library;
import com.google.hashcode.model.Summary;
import com.google.hashcode.service.LibraryService;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Parser {
//    private String input = "a_example.txt";
    private String input = "b_read_on.txt";
//    private String input = "c_incunabula.txt";
//    private String input = "d_tough_choices.txt";
//    private String input = "e_so_many_books.txt";



    private Map<Integer, Integer> scores = new HashMap<>();
    private Summary summary;
    private List<Library> libraries;

    public void execute() {
        readFile(input);

        LibraryService libraryService = new LibraryService();
        libraryService.storeList(libraries, this.scores);
    }

    public void readFile(String file)
    {
        libraries = new ArrayList<>();
        try {

            File f = getFileFromResources(file);

            BufferedReader b = new BufferedReader(new FileReader(f));

            String readLine = "";

            List<String> lines = new ArrayList<>();
            while ((readLine = b.readLine()) != null) {
                lines.add(readLine);
            }

            String firstLine = lines.get(0);
            String[] valuesFirstLine = firstLine.split(" ");

            int numberOfLibraries = Integer.parseInt(valuesFirstLine[1]);

            summary = new Summary(
                    Integer.parseInt(valuesFirstLine[0]),
                    Integer.parseInt(valuesFirstLine[1]),
                    Integer.parseInt(valuesFirstLine[2])
                    );

            String secondLine = lines.get(1);
            String[] valuesSecondLine = secondLine.split(" ");
            List<Book> books = new ArrayList<>();
            for(int i = 0 ; i < valuesSecondLine.length ; i++)
                scores.put(i, Integer.parseInt(valuesSecondLine[i]));

            int line = 2;
            for(int libraryId = 0 ; libraryId < numberOfLibraries ; libraryId++)
            {

                String firstLinePerLibrary = lines.get(line);
                String[] valuesfirstLinePerLibrary = firstLinePerLibrary.split(" ");

                int numberOfBooks = Integer.parseInt(valuesfirstLinePerLibrary[0]);
                int signupDays = Integer.parseInt(valuesfirstLinePerLibrary[1]);
                int booksToScanPerDay = Integer.parseInt(valuesfirstLinePerLibrary[2]);

                String secondLinePerLibrary = lines.get(line+1);
                String[] valuesSecondLinePerLibrary = secondLinePerLibrary.split(" ");

                List<Book> booksPerLibrary = new ArrayList<>();
                for(int j = 0 ; j < valuesSecondLinePerLibrary.length ; j++)
                {
                    Book book = new Book(j, Integer.parseInt(valuesSecondLinePerLibrary[j]));
                    booksPerLibrary.add(book);
                }

                Library library = new Library(libraryId, numberOfBooks, signupDays, booksToScanPerDay, booksPerLibrary);
                libraries.add(library);
                line = line+2;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public Map<Integer, Integer> getScores() {
        return scores;
    }

    public void setScores(Map<Integer, Integer> scores) {
        this.scores = scores;
    }

    public List<Library> getLibraries() {
        return libraries;
    }

    public void setLibraries(List<Library> libraries) {
        this.libraries = libraries;
    }

    private File getFileFromResources(String fileName) {

        ClassLoader classLoader = getClass().getClassLoader();

        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file is not found!");
        } else {
            return new File(resource.getFile());
        }

    }
}
