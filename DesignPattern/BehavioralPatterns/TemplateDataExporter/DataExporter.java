package DesignPattern.BehavioralPatterns.TemplateDataExporter;

import java.util.List;
import java.util.logging.Logger;

public abstract class DataExporter {


    private static final Logger LOGGER = Logger.getLogger("Data Exporter");
    private long fd; 
    protected String fileName;
    protected Format format;
    protected boolean allowFormatting;

    public DataExporter(Format format) {
        this.format = format;
    }  

    protected long open(String fileName) {
        LOGGER.info("Opening file " + fileName + " for " + format.getFormat() + " Export" );
        fd = (long) Math.random();
        this.fileName = fileName;
        return fd;
    }

    protected void close() {
        LOGGER.info("Closing  file " + fileName + " for " + format.getFormat() + " Export");
    }


    protected abstract void format();

    protected abstract boolean write(List<String[]> data);

    protected abstract boolean shouldFormatData();

    public final void exportData(List<String[]> data, MetaData metaData) {
        
        open(metaData.filename());

        if (shouldFormatData()) {
            format();    
        }
        
        write(data);

        close();
        
        LOGGER.info("Successfully exported " + fileName + " for " + format.getFormat() + " format.");
    }
}