package DesignPattern.StructuralPatterns.FlyWeight;

public class Demo {
    public static void main(String[] args) throws InvalidTreeTypeException {
    

        Tree oakRedBlood1 = TreeFactory.getPlant("Oak_Red_Blood");
        oakRedBlood1.plantTree(100
        , 100);
        
        Tree oakRedBlood2 = TreeFactory.getPlant("Oak_Red_Blood");
        oakRedBlood2.plantTree(50
        , 50);

        Tree pineRedWood1 = TreeFactory.getPlant("Pine_Red_Wood");
        pineRedWood1.plantTree(200
        , 200);
        
        Tree pineRedWood2 = TreeFactory.getPlant("Pine_Red_Wood");
        pineRedWood2.plantTree(250
        , 250);

        Tree cheeryBlossomBrownSandal1 = TreeFactory.getPlant("CherryBlossom_Brown_Sandal");
        cheeryBlossomBrownSandal1.plantTree(100
        , 100);
        
        Tree cheeryBlossomBrownSandal2 = TreeFactory.getPlant("CherryBlossom_Brown_Sandal");
        cheeryBlossomBrownSandal2.plantTree(50
        , 50);

        TreeFactory.printTreeFactoryStats();
    }
}
