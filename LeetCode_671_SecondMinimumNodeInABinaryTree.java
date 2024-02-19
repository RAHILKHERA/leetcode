import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LeetCode_671_SecondMinimumNodeInABinaryTree {

    @Test
    public void test() {

        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(3, node1, node2);

        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(1, node4, node5);

        TreeNode node7 = new TreeNode(1, node3, node6);

        TreeNode node8 = new TreeNode(2);
        TreeNode node9 = new TreeNode(1);
        TreeNode node10 = new TreeNode(1, node8, node9);

        TreeNode node11 = new TreeNode(1);
        TreeNode node12 = new TreeNode(1, node10, node11);

        TreeNode node13 = new TreeNode(1, node7, node12);

        TreeNode node14 = new TreeNode(3);
        TreeNode node15 = new TreeNode(8);
        TreeNode node16 = new TreeNode(3, node14, node15);

        TreeNode node17 = new TreeNode(4);
        TreeNode node18 = new TreeNode(8);
        TreeNode node19 = new TreeNode(4, node17, node18);

        TreeNode node20 = new TreeNode(3, node16, node19);

        TreeNode node21 = new TreeNode(1, node13, node20);

        assertEquals(2, findSecondMinimumValue(node21));
    }

    public int findSecondMinimumValue(TreeNode root) {

        if (root == null) {
            return -1;
        }

        if (root.left == null && root.right == null) {
            return -1;
        }

        int value = search(root, root.val);

        if (value == root.val) {
            return -1;
        } else {
            return value;
        }

    }

    public int search(TreeNode node, int lowest) {

        int leftValue = 0, rightValue = 0;

        if (node.left == null && node.right == null) {
            return node.val;
        }

        if (node.left != null) {
            if (node.left.val == lowest) {
                leftValue = search(node.left, lowest);
            } else {
                leftValue = node.left.val;
            }
        }

        if (node.right != null) {
            if (node.right.val == lowest) {
                rightValue = search(node.right, lowest);
            } else {
                rightValue = node.right.val;
            }
        }

        if (leftValue == lowest) {
            return rightValue;
        } else if (rightValue == lowest) {
            return leftValue;
        }

        if (leftValue < rightValue) {
            return leftValue;
        } else {
            return rightValue;
        }

    }
}
