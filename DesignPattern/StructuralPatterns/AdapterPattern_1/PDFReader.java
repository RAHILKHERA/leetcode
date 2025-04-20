package DesignPattern.StructuralPatterns.AdapterPattern_1;

public class PDFReader implements EBookReader {

    @Override
    public void readFile(String fileName) {
        System.out.println("Reading PDF File :" + fileName);

    }

}
