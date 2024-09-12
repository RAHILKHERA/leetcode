import java.util.ArrayList;
import java.util.List;

public class LeetCode_1110_DeleteNodesAndReturnForest {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {

        Pair[] map = new Pair[1001];
        map[root.val] = new Pair(null, root);
        traversal(root, map);

        for (int del : to_delete) {

            TreeNode parent = map[del].parentNode;
            TreeNode node = map[del].node;
            if (parent != null) {
                if (parent.left != null && parent.left.val == node.val) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            }

            if (node.left != null) {
                map[node.left.val].parentNode = null;
            }

            if (node.right != null) {
                map[node.right.val].parentNode = null;
            }

            node.left = null;
            node.right = null;
            map[del] = null;
        }

        List<TreeNode> result = new ArrayList<>();

        for (int i = 0; i < map.length; i++) {

            if (map[i] != null && map[i].parentNode == null) {
                result.add(map[i].node);
            }
        }

        return result;
    }

    private void traversal(TreeNode node, Pair[] map) {

        if (node.left != null) {
            map[node.left.val] = new Pair(node, node.left);
            traversal(node.left, map);
        }

        if (node.right != null) {
            map[node.right.val] = new Pair(node, node.right);
            traversal(node.right, map);
        }

    }

    class Pair {

        TreeNode parentNode;
        TreeNode node;

        Pair(TreeNode parentNode, TreeNode node) {
            this.parentNode = parentNode;
            this.node = node;
        }
    }
}
