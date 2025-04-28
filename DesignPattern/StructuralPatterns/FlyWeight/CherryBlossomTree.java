package DesignPattern.StructuralPatterns.FlyWeight;

public class CherryBlossomTree implements Tree {
    private String id;
    private String color;
    private String texture;

    public CherryBlossomTree(String color, String texture) {
        this.id = "CherryBlossom" + "_" + color  + "_" + texture; 
        this.color = color;
        this.texture = texture;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getTexture() {
        return texture;
    }

    @Override
    public void plantTree(int xCoordinate, int yCoordinate) {
        System.out.println("Planting cheery blossom tree of " + color + " color and " + texture + " texture. at (" + xCoordinate + "," + yCoordinate + ").");
    }
}
