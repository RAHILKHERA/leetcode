import static org.junit.Assert.assertEquals;

// import java.util.ArrayList;
// import java.util.List;

import org.junit.Test;

public class LeetCode_1026_MaximumDifferenceBetweenNodeAndAncestor {

    @Test
    public void test1() {

        TreeNode node4 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        TreeNode node6 = new TreeNode(6, node4, node7);
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3, node1, node6);
        TreeNode node13 = new TreeNode(13);
        TreeNode node14 = new TreeNode(14, node13, null);
        TreeNode node10 = new TreeNode(10, null, node14);
        TreeNode node8 = new TreeNode(8, node3, node10);

        ;
        assertEquals(7, maxAncestorDiff(node8));
    }

    @Test
    public void test2() {

        TreeNode node3 = new TreeNode(3);
        TreeNode node0 = new TreeNode(0, node3, null);
        TreeNode node2 = new TreeNode(2, null, node0);
        TreeNode node1 = new TreeNode(1, node2, null);

        maxAncestorDiff(node1);
        assertEquals(3, maxAncestorDiff(node1));
    }

    // private int max = -1;

    // public int maxAncestorDiff(TreeNode root) {
    // postOrderTraversal(root, new ArrayList<>());
    // return max;
    // }

    // private void postOrderTraversal(TreeNode node, List<Integer> list) {

    // if (node == null) {
    // return;
    // }

    // for (int i = 0; i < list.size(); i++) {
    // int diff = Math.abs(node.val - list.get(i));
    // max = max > diff ? max : diff;
    // }

    // list.add(node.val);

    // postOrderTraversal(node.left, list);

    // postOrderTraversal(node.right, list);

    // list.remove(list.size() - 1);

    // }

    public int maxAncestorDiff(TreeNode root) {
        return postOrderTraversal(root, root.val, root.val);
    }

    private int postOrderTraversal(TreeNode node, int min, int max) {
        if (node == null) {
            return max - min;
        }

        // Update min and max values encountered so far
        min = Math.min(min, node.val);
        max = Math.max(max, node.val);

        // Recursively check left and right subtrees
        int leftDiff = postOrderTraversal(node.left, min, max);
        int rightDiff = postOrderTraversal(node.right, min, max);

        // Return the maximum difference found in the subtree
        return Math.max(leftDiff, rightDiff);
    }
}
