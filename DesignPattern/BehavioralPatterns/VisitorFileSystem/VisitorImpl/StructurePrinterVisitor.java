package DesignPattern.BehavioralPatterns.VisitorFileSystem.VisitorImpl;

import DesignPattern.BehavioralPatterns.VisitorFileSystem.FileSystem;
import DesignPattern.BehavioralPatterns.VisitorFileSystem.ElementImpl.Directory;
import DesignPattern.BehavioralPatterns.VisitorFileSystem.ElementImpl.File;
import DesignPattern.BehavioralPatterns.VisitorFileSystem.Visitor.FileSystemVisitor;

public class StructurePrinterVisitor implements FileSystemVisitor<String> {

    private static final String DIRECTORY = "Directory: ";
    private static final String FILE = "File: ";

    private final StringBuilder structureBuilder = new StringBuilder();
    private int depth = 0;

    @Override
    public String visit(File file) {
        structureBuilder.append("  ".repeat(depth))
                .append(FILE)
                .append(file.getName())
                .append("\n");
        return structureBuilder.toString();
    }

    @Override
    public String visit(Directory directory) {
        structureBuilder.append("  ".repeat(depth))
                .append(DIRECTORY)
                .append(directory.getName())
                .append("\n");

        depth++;
        for (FileSystem child : directory.getChildren()) {
            if (child.isDirectory()) {
                ((Directory) child).accept(this);
            } else {
                ((File) child).accept(this);
            }
        }
        depth--;

        return structureBuilder.toString();
    }
}
