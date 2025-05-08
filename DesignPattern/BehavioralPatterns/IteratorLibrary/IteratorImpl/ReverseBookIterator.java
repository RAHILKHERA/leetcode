package DesignPattern.BehavioralPatterns.IteratorLibrary.IteratorImpl;

import java.util.List;

import DesignPattern.BehavioralPatterns.IteratorLibrary.Iterators.Iterator;
import DesignPattern.BehavioralPatterns.IteratorLibrary.Model.Book;

public class ReverseBookIterator implements Iterator<Book>{

    private List<Book> books;
    private int index;

    public ReverseBookIterator(List<Book> books) {
        this.books = books;
        index = books.size() - 1;
    }
    @Override
    public boolean hasNext() {
        return index >=0;
    }

    @Override
    public Book next() {
        if (hasNext()) {
            return books.get(index--);
        }
        throw new RuntimeException("ReverseBookIterator, No books available.");
    }
    
}
