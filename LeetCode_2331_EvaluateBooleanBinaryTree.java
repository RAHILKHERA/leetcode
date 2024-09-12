public class LeetCode_2331_EvaluateBooleanBinaryTree {

    public boolean evaluateTree(TreeNode root) {

        if (root.left == null && root.right == null) {
            return root.val == 1;
        }

        boolean left = evaluateTree(root.left);
        boolean right = evaluateTree(root.right);

        if (root.val == 2) {
            return left || right;
        } else {
            return left && right;
        }

    }
}