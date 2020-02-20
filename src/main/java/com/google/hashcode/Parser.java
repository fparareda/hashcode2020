package com.google.hashcode;

import com.google.hashcode.model.Book;
import com.google.hashcode.model.Library;
import com.google.hashcode.model.Scores;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Parser {

    int numberOfBooks;
    int numberOfLibraries;
    int numberOfDays;

    Scores scoresObj;
    List<Library> libraries = new ArrayList<>();

    public static void main(String[] args) {
        Parser parser = new Parser();
        parser.readFile();
    }

    void readFile()
    {
        try {

            File f = getFileFromResources("a_example.txt");

            BufferedReader b = new BufferedReader(new FileReader(f));

            String readLine = "";

            List<String> lines = new ArrayList<>();
            while ((readLine = b.readLine()) != null) {
                lines.add(readLine);
            }

            String firstLine = lines.get(0);
            String[] valuesFirstLine = firstLine.split(" ");

            numberOfBooks = Integer.parseInt(valuesFirstLine[0]);
            numberOfLibraries = Integer.parseInt(valuesFirstLine[1]);
            numberOfDays = Integer.parseInt(valuesFirstLine[2]);

            System.out.println("numberOfBooks " + numberOfBooks);
            System.out.println("numberOfLibraries " + numberOfLibraries);
            System.out.println("numberOfDays " + numberOfDays);


            String secondLine = lines.get(1);
            String[] valuesSecondLine = secondLine.split(" ");
            List<Book> books = new ArrayList<>();
            for(int i = 0 ; i < valuesSecondLine.length ; i++)
            {
                Book book = new Book(i, Integer.parseInt(valuesSecondLine[i]));
                books.add(book);
            }
            scoresObj = new Scores(books);

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

            System.out.println();

        } catch (IOException e) {
            e.printStackTrace();
        }
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