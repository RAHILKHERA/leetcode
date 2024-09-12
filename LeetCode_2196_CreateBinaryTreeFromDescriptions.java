import java.util.HashMap;
import java.util.Map;

class TreeNodeExtend extends TreeNode {

    TreeNodeExtend() {
    }

    TreeNodeExtend(int val) {
        super(val);
    }

    TreeNodeExtend(int val, TreeNodeExtend left, TreeNodeExtend right) {
        super(val, left, right);
    }

    boolean hasParent = false;

    public boolean hasParent() {
        return hasParent;
    }

    public void setHasParent() {
        hasParent = true;
    }
}

public class LeetCode_2196_CreateBinaryTreeFromDescriptions {
    public TreeNode createBinaryTree(int[][] descriptions) {

        Map<Integer, TreeNodeExtend> map = new HashMap<>();

        for (int[] description : descriptions) {

            int parent = description[0];
            int child = description[1];

            TreeNodeExtend parentNode = map.containsKey(parent) ? map.get(parent) : new TreeNodeExtend(parent);
            TreeNodeExtend childNode = map.containsKey(child) ? map.get(child) : new TreeNodeExtend(child);

            if (description[2] == 1) {
                parentNode.left = childNode;
            } else {
                parentNode.right = childNode;
            }
            childNode.setHasParent();
            map.put(parent, parentNode);
            map.put(child, childNode);

        }

        for (Map.Entry<Integer, TreeNodeExtend> entry : map.entrySet()) {

            if (!entry.getValue().hasParent()) {
                return entry.getValue();
            }
        }

        return null;
    }
}
