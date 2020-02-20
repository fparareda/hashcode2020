package com.google.hashcode.output;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Writer {
    //number of signed up libraries
    //library ID + number of books to scan
    //list of books ID in scanning order (no duplicates)
    //repeat per library

//    idLibrary, listOfBooksId
    public void print (Map<Integer, ArrayList<Integer>> result)
    {
        PrintWriter printer;
        int numberOfSignedUpLibraries = result.keySet().size();
        int numberOfBooksToScan;
        int[] listOfBookIds;
        printer = createPrinter();
        printer.println(numberOfSignedUpLibraries);
        for (Integer libraryId : result.keySet()) {
            listOfBookIds = result.get(libraryId);
            numberOfBooksToScan = listOfBookIds.length;
            printer.println(libraryId + " " + numberOfBooksToScan);
            for (int bookId : listOfBookIds)
                printer.print(bookId+" ");
            printer.println();
        }
        printer.close();
    }

    private PrintWriter createPrinter() {
        File file;
        PrintWriter printer;
        file = new File("result.txt");
        try {
            if (!file.exists())
                file.createNewFile();
            printer = new PrintWriter(file);
            return printer;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return null;
        }
    }
}