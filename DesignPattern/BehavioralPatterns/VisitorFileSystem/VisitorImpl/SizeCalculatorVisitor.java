package DesignPattern.BehavioralPatterns.VisitorFileSystem.VisitorImpl;

import DesignPattern.BehavioralPatterns.VisitorFileSystem.FileSystem;
import DesignPattern.BehavioralPatterns.VisitorFileSystem.ElementImpl.Directory;
import DesignPattern.BehavioralPatterns.VisitorFileSystem.ElementImpl.File;
import DesignPattern.BehavioralPatterns.VisitorFileSystem.Visitor.FileSystemVisitor;

public class SizeCalculatorVisitor implements FileSystemVisitor<Long>{

    @Override
    public Long visit(File file) {
        return file.getSize();
    }

    @Override
    public Long visit(Directory directory) {
        long directorySize = 0;
        for (FileSystem file : directory.getChildren()) {
            directorySize += file.getSize();
        }
        return directorySize;
    }
    
}
