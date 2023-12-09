import java.util.ArrayList;
import java.util.List;
//import java.util.Stack;

public class LeetCode_94_BinaryTreeInorderTraversal {
    
}

class Solution {

    List<Integer> result = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        
         if (root == null) {
            return result;
         }   
       
         inorderTraversal(root.left);
         result.add(root.val);
         inorderTraversal(root.right);

         return result;
        
        // List<Integer> result = new ArrayList<>();

        // //inorderTraversal(root, result);

        // if (root == null) {
        //     return result;
        // }

        // TreeNode current = root; 
        // Stack<TreeNode> stack = new Stack<>();
        // while (current != null || !stack.isEmpty()) {

        //     while (current != null) {

        //         stack.push(current);
        //         current = current.left;
        //     }
        //     current = stack.pop();
        //     result.add(current.val);
        //     current = current.right;
        // }

        // return result;
    }
    
    // private void  inorderTraversal(TreeNode node, List<Integer> list) {

    //     if (node == null) {
    //         return;
    //     }

    //     inorderTraversal(node.left, list);

    //     list.add(node.val);

    //     inorderTraversal(node.right, list);
    
    // }
}