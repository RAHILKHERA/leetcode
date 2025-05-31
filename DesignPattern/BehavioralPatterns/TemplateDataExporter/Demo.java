package DesignPattern.BehavioralPatterns.TemplateDataExporter;

import java.util.Arrays;
import java.util.List;

import DesignPattern.BehavioralPatterns.TemplateDataExporter.impl.CSVDataExporter;
import DesignPattern.BehavioralPatterns.TemplateDataExporter.impl.ExcelDataExporter;
import DesignPattern.BehavioralPatterns.TemplateDataExporter.impl.PDFDataExporter;

public class Demo {
    public static void main(String[] args) {

        MetaData metaData = new MetaData("data.xsls", Format.Excel);
        List<String[]> data = Arrays.asList(new String[] { "Hi", "This is example of Template Data Exporter" },
                new String[] { "This is part of the System Design Preparations." });

        DataExporter dataExporter = new CSVDataExporter(true);
        dataExporter.exportData(data, metaData);

        dataExporter = new PDFDataExporter(true);
        dataExporter.exportData(data, metaData);

        dataExporter = new ExcelDataExporter(false);
        dataExporter.exportData(data, metaData);
    }
}
