public class LeetCode_530_MinimumAbsoluteDifferenceinBST {
    
}

class Solution_LeetCode_530_MinimumAbsoluteDifferenceinBST {
    
    private int minDiff;
    private TreeNode prev;

    public int getMinimumDifference(TreeNode root) {
        
        minDiff = Integer.MAX_VALUE;
        prev = null;
        inorder(root);
        return minDiff;
    }

    private void inorder(TreeNode node) {

        if (node.left != null) {
            inorder(node.left);
        }

        if (prev != null) {
            minDiff = Math.min(minDiff, Math.abs(node.val - prev.val)); 
        }

        prev = node;

        if (node.right != null) {
            inorder(node.right);
        }
    }


}
