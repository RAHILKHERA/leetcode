package DesignPattern.StructuralPatterns.AdapterPattern_1;

public class Reader implements EBookReader {

    @Override
    public void readFile(String fileName) {
        EBookType type = EBookType.fromFileName(fileName);
        switch (type) {
            case EPUB:

                EBookAdapter adapter = new EBookAdapter(new EPUBReaderImpl());
                adapter.readFile(fileName);
                break;
            case PDF:
                EBookReader pdfReader = new PDFReader();
                pdfReader.readFile(fileName);
                break;
            default:
                System.out.println("Not supported :" + fileName);
                break;
        }
    }

}
