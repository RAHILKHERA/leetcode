package DesignPattern.StructuralPatterns.CompositePattern;

public class File implements FileSystem {

    private long id;
    private String name;
    private long size;

    public File(String name) {
        this.id = idGenerator();
        this.name = name;
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
    public void ls() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "File [id=" + id + ", name=" + name + ", size=" + size + "]";
    }

    @Override
    public long getId() {
        return id;
    }

}
