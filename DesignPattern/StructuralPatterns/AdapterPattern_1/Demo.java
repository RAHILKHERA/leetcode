package DesignPattern.StructuralPatterns.AdapterPattern_1;

public class Demo {
    public static void main(String[] args) {

        EBookReader reader = new Reader();
        reader.readFile("abc.pdf");
        reader.readFile("def.epub");
    }
}
