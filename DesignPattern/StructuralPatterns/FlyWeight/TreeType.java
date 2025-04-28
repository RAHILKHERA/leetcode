package DesignPattern.StructuralPatterns.FlyWeight;

public enum TreeType {
    
    OAK("Oak"),
    PINE("Pine"),
    CHERRYBLOSSOM("CherryBlossom"),
    UNKNOWN("Unknown");

    private String type; 

    TreeType(String type) {
        this.type = type;
    }

    public String getType() {
        return type; 
    }

    public static  TreeType getTreeType(String type) {
        for (TreeType treeType : values()) {
            if (treeType.getType().equals(type)) {
                return treeType;
            }
        }
        return UNKNOWN;
    }
}
