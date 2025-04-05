package Threads.Exercise3;

public class SharedResource {

    private int sharedResource = 0;

    public void incrementSharedResource() {
        sharedResource++;
    }

    public int getSharedResource() {
        return sharedResource;
    }
}
