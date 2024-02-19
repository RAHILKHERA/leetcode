import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LeetCode_1457_PseudoPalindromicPathsinBinaryTree {

    @Test
    public void test1() {

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(3, node3, node2);
        TreeNode node5 = new TreeNode(1, null, node1);
        TreeNode node6 = new TreeNode(2, node4, node5);

        assertEquals(2, pseudoPalindromicPaths(node6));
    }

    public int pseudoPalindromicPaths(TreeNode root) {

        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        return preorderTraversal(root, new int[10]);
    }

    private int preorderTraversal(TreeNode node, int[] freq) {

        int total = 0;

        freq[node.val]++;

        if (node.left != null) {
            total += preorderTraversal(node.left, freq);
        }

        if (node.right != null) {
            total += preorderTraversal(node.right, freq);
        }

        if (node.left == null && node.right == null) {
            if (checkPseudoPalindrome(freq)) {
                total++;
            }
        }

        freq[node.val]--;

        return total;
    }

    private boolean checkPseudoPalindrome(int[] freq) {

        boolean foundOdd = false;

        for (int i : freq) {
            if (i != 0) {
                if (i % 2 != 0) {
                    if (foundOdd) {
                        return false;
                    } else {
                        foundOdd = true;
                    }
                }
            }
        }
        return true;
    }
}
