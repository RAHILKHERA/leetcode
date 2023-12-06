import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
public class LeetCode_102_BinaryTreeLevelOrderTraversal {
    
    public static void main(String[] args) {
        
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        new Solution_LeetCode_102_BinaryTreeLevelOrderTraversal().levelOrder(node1);
    }

}

class Solution_LeetCode_102_BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        List<Integer> level = new ArrayList<>();

        while (!queue.isEmpty()) {
        
            TreeNode node = queue.poll();
      
            if (node == null) {

                result.add(level);

                level = new ArrayList<>();

                if (!queue.isEmpty()) {
                    queue.offer(null);
                }
            } else {

                level.add(node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }

        return result;
    }
}