public class LeetCode_623_AddOneRowToTree {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {

        if (depth == 1) {
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }

        addRow(root, val, depth, 1);

        return root;
    }

    private void addRow(TreeNode node, int val, int depth, int currentDepth) {

        if (node == null) {
            return;
        }

        if (currentDepth == depth - 1) {
            TreeNode leftSubTree = node.left;
            TreeNode rightSubTree = node.right;
            TreeNode newLeftSubTree = new TreeNode(val);
            TreeNode newRightSubTree = new TreeNode(val);
            newLeftSubTree.left = leftSubTree;
            newRightSubTree.right = rightSubTree;
            node.left = newLeftSubTree;
            node.right = newRightSubTree;
            return;
        }

        addRow(node.left, val, depth, currentDepth + 1);
        addRow(node.right, val, depth, currentDepth + 1);

    }
}
