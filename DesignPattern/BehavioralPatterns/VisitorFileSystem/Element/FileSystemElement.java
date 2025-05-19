package DesignPattern.BehavioralPatterns.VisitorFileSystem.Element;

import DesignPattern.BehavioralPatterns.VisitorFileSystem.FileSystem;
import DesignPattern.BehavioralPatterns.VisitorFileSystem.Visitor.FileSystemVisitor;

public interface FileSystemElement extends FileSystem {
    public  <T> T accept(FileSystemVisitor<T> visitor);
}
