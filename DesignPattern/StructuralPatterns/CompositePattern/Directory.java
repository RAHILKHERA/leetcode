package DesignPattern.StructuralPatterns.CompositePattern;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Directory implements FileSystem {

    private long id;
    private Map<Long, FileSystem> children;
    private String name;
    private long size;

    public Directory(String name) {
        id = idGenerator();
        this.name = name;
        children = new HashMap<>();
    }

    public void addChild(FileSystem file) {
        if (children.containsKey(file.getId())) {
            throw new RuntimeException("File/Directory already exists.");
        }
        children.put(file.getId(), file);
    }

    public void removeChild(FileSystem file) {
        if (!children.containsKey(file.getId())) {
            throw new RuntimeException("File/Directory does not exists.");
        }
        children.remove(file.getId());
    }

    public Collection<FileSystem> getChildren() {
        return children.values();
    }

    @Override
    public String toString() {
        return "Directory [id = " + id + ", name = " + name + ", size = " + size + ", children = " + children.size()
                + "]";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public long getSize() {
        long total = 0;
        for (FileSystem child : children.values()) {
            total += child.getSize();
        }
        return total;
    }

    @Override
    public void ls() {
        System.out.println(toString());
        for (Map.Entry<Long, FileSystem> entry : children.entrySet()) {
            entry.getValue().ls();
        }
    }

    @Override
    public long getId() {
        return id;
    }

}
