public class LeetCode_98_Validate_BTS {
    
}

class Solution_LeetCode_98_Validate_BFS {
    

    private TreeNode prev;
    private boolean isValid;
  
    
    public boolean isValidBST(TreeNode root) {

        if (root == null) {
            return true;
        }

        prev = null;
        isValid = true;

        inOrder(root);

        return isValid;
       
    }

    private void inOrder(TreeNode node) {
        
        if (!isValid) {
            return;
        }


        if (node == null) {
            isValid = true;
            return;
        }

       inOrder(node.left);
        
        if (prev != null) {
            isValid = prev.val < node.val; 
        }

        prev = node;

       inOrder(node.right);
        
    }
    
}
