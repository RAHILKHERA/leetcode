public class LeetCode_404_SumOfLeftLeaves {

    private int sum = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        helper(root, false);
        return sum;
    }

    private void helper(TreeNode node, boolean isLeft) {

        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null && isLeft) {
            sum += node.val;
            return;
        }

        helper(node.left, true);
        helper(node.right, false);

    }
}
