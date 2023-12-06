public class LeetCode_26_InvertBinaryTree {
    
}

class Solution_LeetCode_26_InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        
        if(root == null) {
            return root;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);
        
        return root;
    }
}