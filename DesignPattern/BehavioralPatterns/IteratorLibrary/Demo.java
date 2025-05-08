package DesignPattern.BehavioralPatterns.IteratorLibrary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import DesignPattern.BehavioralPatterns.IteratorLibrary.AggregatorImpl.Library;
import DesignPattern.BehavioralPatterns.IteratorLibrary.Iterators.Iterator;
import DesignPattern.BehavioralPatterns.IteratorLibrary.Model.Book;

public class Demo {
    public static void main(String[] args) {

        List<Book> books = new ArrayList<>(Arrays.asList(new Book("abc", "James"),
        new Book("Designing Data Intensive Applications", "Martin Kleppmann"),
        new Book("Data Structure And Algorithms ", "Narshima")));
        
        Library library = new Library(books);

        System.out.println("-----------------------------------------------");
        System.out.println("Current List of Books...");
        Iterator<Book> listOfBooks = library.iterator();
        while (listOfBooks.hasNext()) {
            System.out.println(listOfBooks.next());
        }
        System.out.println("-----------------------------------------------");


        System.out.println("Adding new Book...");   
        library.addBook(new Book("Introduction to Algorithms", "Thomas h."));
        System.out.println("-----------------------------------------------");  

        System.out.println("Updated List of Books...");
        listOfBooks = library.iterator();
        while (listOfBooks.hasNext()) {
            System.out.println(listOfBooks.next());
        }

        System.out.println("-----------------------------------------------");
        System.out.println("Reverse List of Books...");
        listOfBooks = library.reverseIterator(); 
        while (listOfBooks.hasNext()) {
            System.out.println(listOfBooks.next());
        } 
    }
}
