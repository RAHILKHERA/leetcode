package DesignPattern.StructuralPatterns.FlyWeight;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TreeFactory {
    
    private static final Map<String, Tree> treeCache = new ConcurrentHashMap<>();
    private static final String SEPARATOR = "_";
    private static final int ATTRIBUTES_LENGTH = 3;

    private static int treesCreated = 0;
    private static int treesReused = 0;

    public static final Tree getPlant(String treeId) throws InvalidTreeTypeException {
        if (treeCache.containsKey(treeId)) {
            treesReused++;
            return treeCache.get(treeId);
        } else {
            if (treeId.indexOf(SEPARATOR) == -1) {
                throw new InvalidTreeTypeException("Invalid tree type. Required format treeType_color_texture.");
            }
            
            String [] treeAttributes = treeId.split("_");

            if (treeAttributes.length != ATTRIBUTES_LENGTH) {
                throw new InvalidTreeTypeException("All attributes for tree plantation are not available. Required format treeType_color_texture.");
            }

            Tree tree;
            switch (TreeType.getTreeType(treeAttributes[0])) {
                case OAK:
                    tree = new OakTree(treeAttributes[1], treeAttributes[2]);
                    break;
                case PINE:
                    tree = new PineTree(treeAttributes[1], treeAttributes[2]);
                    break;
                case CHERRYBLOSSOM:
                    tree = new CherryBlossomTree(treeAttributes[1], treeAttributes[2]);
                    break;
                default:
                    throw new InvalidTreeTypeException("Invalid type of Tree.");
            }

            treeCache.put(treeId, tree);
            treesCreated++;
            return tree;
        }
    }

    public static void printTreeFactoryStats() {
        System.out.println("Total Trees Created: " + treesCreated);
        System.out.println("Total Trees Reused: " + treesReused);
    }

}
