package DesignPattern.BehavioralPatterns.VisitorFileSystem;

import java.util.Random;

public interface FileSystem {

    public long getId();

    public String getName();

    public long getSize();

    public String ls();

    public boolean isDirectory();

    public default long idGenerator() {
        return new Random().nextLong(0, Long.MAX_VALUE);
    }
}
