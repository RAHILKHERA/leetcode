import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class LeetCode_103_BinaryTreeZigZagLevelOrderTraversal {
    
    public static void main(String[] args) {
        // TreeNode node1 = new TreeNode(1);
        // TreeNode node2 = new TreeNode(2);
        // TreeNode node3 = new TreeNode(3);
        // TreeNode node4 = new TreeNode(4);
        // TreeNode node5 = new TreeNode(5);
        // TreeNode node6 = new TreeNode(6);
        // TreeNode node7 = new TreeNode(7);

        // node1.left = node2;
        // node1.right = node3;
        // node2.left = node4;
        // node2.right = node5;
        // node3.left = node6;
        // node3.right = node7;

        // TreeNode node1 = new TreeNode(3);
        // TreeNode node2 = new TreeNode(9);
        // TreeNode node3 = new TreeNode(20);
        // TreeNode node4 = new TreeNode(15);
        // TreeNode node5 = new TreeNode(7);
        // node1.left = node2;
        // node1.right = node3;
        // node3.left = node4;
        // node3.right = node5;

        TreeNode node1 = new TreeNode(1);
        new Solution_LeetCode_103_BinaryTreeZigZagLevelOrderTraversal().zigzagLevelOrder(node1);
    }
}

class Solution_LeetCode_103_BinaryTreeZigZagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        
        List<List<Integer>> result = new ArrayList<>();
        
        if (root == null) {
            return result;
        }
        
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        Stack<TreeNode> stack = new Stack<>();
        
        
        while(!queue.isEmpty()) {
            
            int nodesInLevel = queue.size();

            ArrayList <Integer> levelVal = new ArrayList<>();
          
            
            for (int i = 0; i < nodesInLevel; i++) {
                
                TreeNode node = queue.poll();

                if (level %2 == 0) {

                    levelVal.add(node.val);

                    if (node.left != null) {
                        queue.add(node.left);
                        stack.push(node.left);
                    }

                    if (node.right != null) {
                        queue.add(node.right);
                        stack.push(node.right);
                    }

                } else {

                    levelVal.add(stack.pop().val);

                    if (node.left != null) {
                        queue.add(node.left);
                    }

                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
                
            }

            result.add(levelVal);
            level++;
        }
        return result;
    }
}