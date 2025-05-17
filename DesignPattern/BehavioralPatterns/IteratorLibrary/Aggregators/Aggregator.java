package DesignPattern.BehavioralPatterns.IteratorLibrary.Aggregators;

import DesignPattern.BehavioralPatterns.IteratorLibrary.Iterators.Iterator;

public interface Aggregator<T> {
    public Iterator<T> iterator();

    public Iterator<T> reverseIterator();
}
