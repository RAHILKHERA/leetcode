public class LeetCode_101_SymmetricTree {
    
}

class Solution_LeetCode_101_SymmetricTree {

    public boolean isSymmetric(TreeNode root) {

       if (root == null) {
        return true;
       }

       return isMirror(root.left, root.right);

    }

    private boolean isMirror(TreeNode leftNode, TreeNode rightNode) {

       if (leftNode == null && rightNode == null) {
        return true;
       }

       if (leftNode == null || rightNode == null) {
        return false;
       }
       
       if (leftNode.val != rightNode.val) {
        return false;
       }

       return isMirror(leftNode.left, rightNode.right) && isMirror(leftNode.right, rightNode.left);
        
    }
}
