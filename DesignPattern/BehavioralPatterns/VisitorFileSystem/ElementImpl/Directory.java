package DesignPattern.BehavioralPatterns.VisitorFileSystem.ElementImpl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import DesignPattern.BehavioralPatterns.VisitorFileSystem.FileSystem;
import DesignPattern.BehavioralPatterns.VisitorFileSystem.Element.FileSystemElement;
import DesignPattern.BehavioralPatterns.VisitorFileSystem.Visitor.FileSystemVisitor;
import DesignPattern.BehavioralPatterns.VisitorFileSystem.VisitorImpl.SizeCalculatorVisitor;
import DesignPattern.BehavioralPatterns.VisitorFileSystem.VisitorImpl.StructurePrinterVisitor;

public class Directory implements FileSystemElement {

    private long id;
    private Map<Long, FileSystem> children;
    private String name;
    private FileSystemVisitor<Long> sizeCalculatorVisitor;
    private FileSystemVisitor<String> structurePrinterVisitor;

    public Directory(String name) {
        id = idGenerator();
        this.name = name;
        children = new HashMap<>();
        sizeCalculatorVisitor = new SizeCalculatorVisitor();
        structurePrinterVisitor = new StructurePrinterVisitor();
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    public void addChild(FileSystem file) {
        if (children.containsKey(file.getId())) {
            throw new RuntimeException("File/Directory already exists.");
        }
        children.put(file.getId(), file);
    }

    public void removeChild(FileSystem file) {
        if (!children.containsKey(file.getId())) {
            throw new RuntimeException("File/Directory does not exist.");
        }
        children.remove(file.getId());
    }

    public Collection<FileSystem> getChildren() {
        return children.values();
    }

    @Override
    public String toString() {
        return "Directory [id = " + id + ", name = " + name + ", size = " + getSize() + ", children = "
                + children.size()
                + "]";
    }

    @Override
    public long getSize() {
       return  accept(sizeCalculatorVisitor) ;
    }

    @Override
    public String ls() {
       return  accept(structurePrinterVisitor);
    }

    @Override
    public <T> T accept(FileSystemVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public boolean isDirectory() {
        return true;
    }

}
