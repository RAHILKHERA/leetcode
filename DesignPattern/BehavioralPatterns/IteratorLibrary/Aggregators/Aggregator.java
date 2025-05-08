package DesignPattern.BehavioralPatterns.IteratorLibrary.Aggregators;

public interface Aggregator<T> {
    public T iterator();
    public T reverseIterator();
}
