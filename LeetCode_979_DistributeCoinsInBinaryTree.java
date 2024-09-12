public class LeetCode_979_DistributeCoinsInBinaryTree {

    int moves = 0;

    public int distributeCoins(TreeNode root) {
        traversal(root);
        return moves;
    }

    private int traversal(TreeNode node) {

        if (node == null) {
            return 0;
        }

        int leftExtraCoins = traversal(node.left);
        int rightExtraCoins = traversal(node.right);

        moves += Math.abs(leftExtraCoins) + Math.abs(rightExtraCoins);

        return node.val + leftExtraCoins + rightExtraCoins - 1;

    }
}
