package DesignPattern.BehavioralPatterns.TemplateDataExporter;

public class DataExporterException extends Exception {
    
    DataExporterException(String msg) {
        super(msg);
    }

    DataExporterException(String msg, Throwable clause) {
        super(msg, clause);
    }

    DataExporterException(Throwable clause) {
        super(clause);
    }
}
