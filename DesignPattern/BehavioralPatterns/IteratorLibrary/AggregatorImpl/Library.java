package DesignPattern.BehavioralPatterns.IteratorLibrary.AggregatorImpl;

import java.util.ArrayList;
import java.util.List;

import DesignPattern.BehavioralPatterns.IteratorLibrary.Aggregators.Aggregator;
import DesignPattern.BehavioralPatterns.IteratorLibrary.IteratorImpl.BookIterator;
import DesignPattern.BehavioralPatterns.IteratorLibrary.IteratorImpl.ReverseBookIterator;
import DesignPattern.BehavioralPatterns.IteratorLibrary.Iterators.Iterator;
import DesignPattern.BehavioralPatterns.IteratorLibrary.Model.Book;

public class Library implements Aggregator<Book> {

    private List<Book> books;

    public Library () {
        this.books = new ArrayList<>();
    }

    public Library (List<Book> books) {
        this.books = books;
    }

    public void addBook(Book newBook) {
        books.add(newBook);
    }
    
    @Override
    public Iterator<Book> iterator() {
        return new BookIterator(books);
    }

    @Override
    public Iterator<Book> reverseIterator() {
       return new ReverseBookIterator(books);
    }
    
}
