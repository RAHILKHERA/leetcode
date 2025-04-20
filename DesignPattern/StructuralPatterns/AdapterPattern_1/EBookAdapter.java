package DesignPattern.StructuralPatterns.AdapterPattern_1;

public class EBookAdapter implements EBookReader {

    private EPUBReader reader;

    public EBookAdapter(EPUBReader reader) {
        this.reader = reader;
    }

    @Override
    public void readFile(String fileName) {
        reader.loadEPUB(fileName);
    }

}
