public class LeetCode_938_RangeSumOfBST {
    
}

class Solution_LeetCode_938_RangeSumOfBST {
    
    private int sum = 0;
    
    public int rangeSumBST(TreeNode root, int low, int high) {
        inorder(root, low, high);
        return sum;
    }

    private void inorder(TreeNode node, int low, int high) {

        if (node == null) {
            return;
        }

        inorder(node.left, low, high);

        if ((node.val <= high) && (node.val >= low)) {
            sum += node.val;
        }

        inorder(node.right, low, high);
    }
}