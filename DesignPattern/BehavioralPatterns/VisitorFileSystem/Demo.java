package DesignPattern.BehavioralPatterns.VisitorFileSystem;

import java.util.logging.Logger;

import DesignPattern.BehavioralPatterns.VisitorFileSystem.ElementImpl.Directory;
import DesignPattern.BehavioralPatterns.VisitorFileSystem.ElementImpl.File;

public class Demo {

    private static Logger LOGGER = Logger.getLogger("Visitor : ");
    public static void main(String[] args) {
        Directory directory = new Directory("Interview Preparations");
        Directory leetCode = new Directory("LeetCode");
        File problem1 = new File("LeetCode_1.java");
        File problem2 = new File("LeetCode_2.java");
        Directory designPattern = new Directory("Design Pattern");
        problem1.setSize(1024);
        problem2.setSize(2048);
        directory.addChild(leetCode);
        directory.addChild(designPattern);
        leetCode.addChild(problem1);
        leetCode.addChild(problem2);
        directory.addChild(new File("Resume.pdf"));
        LOGGER.info(directory.ls());
        LOGGER.info("Size : " + directory.getSize());
    }
}
