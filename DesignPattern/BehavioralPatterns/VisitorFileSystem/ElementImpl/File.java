package DesignPattern.BehavioralPatterns.VisitorFileSystem.ElementImpl;

import DesignPattern.BehavioralPatterns.VisitorFileSystem.Element.FileSystemElement;
import DesignPattern.BehavioralPatterns.VisitorFileSystem.Visitor.FileSystemVisitor;
import DesignPattern.BehavioralPatterns.VisitorFileSystem.VisitorImpl.StructurePrinterVisitor;

public class File implements FileSystemElement {

    private long id;
    private String name;
    private long size;
    private FileSystemVisitor<String> structurePrinterVisitor;

   public File(String name) {
        this.id = idGenerator();
        this.name = name;
        structurePrinterVisitor = new StructurePrinterVisitor();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public long getSize() {
        return size;
    }

    public void setSize(long bytes) {
        size = bytes;
    }

    @Override
    public String ls() {
        return accept(structurePrinterVisitor);
    }

    @Override
    public String toString() {
        return "File [id=" + id + ", name=" + name + ", size=" + size + "]";
    }

    @Override
    public long getId() {
        return id;
    }

     @Override
    public <T> T accept(FileSystemVisitor<T> visitor) {
        return visitor.visit(this);
    }

     @Override
     public boolean isDirectory() {
         return false;
     }
    
}
