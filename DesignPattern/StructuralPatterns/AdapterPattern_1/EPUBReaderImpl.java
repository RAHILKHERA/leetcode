package DesignPattern.StructuralPatterns.AdapterPattern_1;

public class EPUBReaderImpl implements EPUBReader {

    @Override
    public void loadEPUB(String filePath) {
        System.out.println("Loading EPUB file : " + filePath);
    }

}
