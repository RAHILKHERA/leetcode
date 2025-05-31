package DesignPattern.BehavioralPatterns.TemplateDataExporter.impl;


import java.util.List;
import java.util.logging.Logger;

import DesignPattern.BehavioralPatterns.TemplateDataExporter.DataExporter;
import DesignPattern.BehavioralPatterns.TemplateDataExporter.Format;

public class ExcelDataExporter extends DataExporter {

    private static final Logger LOGGER = Logger.getLogger("ExcelData Exporter");

    public ExcelDataExporter(boolean allowFormatting) {
        super(Format.Excel);
        this.allowFormatting = allowFormatting;
    }

    @Override
    public void format() {
        LOGGER.info("Formatting data for " + format.getFormat() + "...");
    }

    @Override
    public boolean write(List<String[]> data) {
        LOGGER.info("Writing " + format.getFormat() + " data to file...");
        return true;
    }

    @Override
    public boolean shouldFormatData() {
        return allowFormatting;
    }

}
