public class LeetCode_543DiameterOfBinaryTree {

    private int max;

    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return max;
    }

    private int helper(TreeNode node) {

        if (node == null) {
            return 0;
        }

        int left = helper(node.left);
        int right = helper(node.right);
        max = Math.max(max, left + right);

        return Math.max(left, right) + 1;
    }
}
