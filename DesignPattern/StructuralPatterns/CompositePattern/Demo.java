package DesignPattern.StructuralPatterns.CompositePattern;

public class Demo {
    public static void main(String[] args) {
        Directory directory = new Directory("Interview Preparations");
        Directory leetCode = new Directory("LeetCode");
        FileSystem problem1 = new File("LeetCode_1.java");
        FileSystem problem2 = new File("LeetCode_2.java");
        Directory designPattern = new Directory("Design Pattern");
        directory.addChild(leetCode);
        directory.addChild(designPattern);
        leetCode.addChild(problem1);
        leetCode.addChild(problem2);
        directory.addChild(new File("Resume.pdf"));
        directory.ls();
    }
}
