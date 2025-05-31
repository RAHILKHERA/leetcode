package DesignPattern.BehavioralPatterns.TemplateDataExporter;

public enum Format {

    CSV("CSV"),
    PDF("PDF"),
    Excel("Excel");

    private String format;

    Format(String format) {
        this.format = format;
    }
    
    public String getFormat() {
        return format;
    }

    public static Format getFormat(String format) throws DataExporterException {
        
        for (Format f : values()) {
            if (f.getFormat().equals(format)) {
                return f;
            }
        }
        throw new DataExporterException("Format " + format + " not supported.");
    }

}
