package com.google.hashcode.output;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Writer {
    private PrintWriter printer;

    public Writer (String filePath){
        File file = new File(filePath);
        try {
            if (!file.exists())
                file.createNewFile();
            printer = new PrintWriter(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //number of signed up libraries
    //library ID + number of books to scan
    //list of books ID in scanning order (no duplicates)
    //repeat per library

//    idLibrary, listOfBooksId
    public void print (Map<Integer, List<Integer>> result)
    {
        int numberOfSignedUpLibraries = result.keySet().size();
        int numberOfBooksToScan;
        List<Integer> listOfBookIds;

        printer.println(numberOfSignedUpLibraries);
        for (Integer libraryId : result.keySet()) {
            listOfBookIds = result.get(libraryId);
            printer.println(libraryId + " " + listOfBookIds.size());
            for (int bookId : listOfBookIds)
                printer.print(bookId+" ");
            printer.println();
        }
        printer.close();
    }
}