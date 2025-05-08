package DesignPattern.BehavioralPatterns.IteratorLibrary.IteratorImpl;

import java.util.List;

import DesignPattern.BehavioralPatterns.IteratorLibrary.Iterators.Iterator;
import DesignPattern.BehavioralPatterns.IteratorLibrary.Model.Book;

public class BookIterator implements Iterator<Book> {

    private List<Book> books;
    private int size;
    private int index;
    
    public BookIterator(List<Book> books) {
        this.books = books;
        size = books.size();
        index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < size;    
    }

    @Override
    public Book next() {
        if (hasNext()) {
            return books.get(index++);
        }
        throw new RuntimeException("BookIterator, No books available.");
    }
    
}
