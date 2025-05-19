package DesignPattern.BehavioralPatterns.VisitorFileSystem.Visitor;

import DesignPattern.BehavioralPatterns.VisitorFileSystem.ElementImpl.Directory;
import DesignPattern.BehavioralPatterns.VisitorFileSystem.ElementImpl.File;

public interface FileSystemVisitor<T> {
    public T visit(File file);

    public T visit(Directory directory);
}
