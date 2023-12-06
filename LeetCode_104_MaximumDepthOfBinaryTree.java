public class LeetCode_104_MaximumDepthOfBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        int height = new Solution_LeetCode_104_MaximumDepthOfBinaryTree().maxDepth(root);
        System.out.println(height);
    }
    
}


 
 
class Solution_LeetCode_104_MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }
        
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        
    }
}