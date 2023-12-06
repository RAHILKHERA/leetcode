import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode_199_BinaryTreeRightSideView {
    public static void main(String[] args) {

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.right = node5;
        node3.right = node4;

        new Solution_LeetCode_199_BinaryTreeRightSideView().rightSideView(node1);
    }
}

class Solution_LeetCode_199_BinaryTreeRightSideView {
     public List<Integer> rightSideView(TreeNode root) {

        if (root == null) {
            return null;
        }
        
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        TreeNode prev = null;
        while (!queue.isEmpty()) {

            TreeNode node = queue.poll();
            if (node == null) {
                result.add(prev.val);

                if (!queue.isEmpty()) {
                    queue.add(null);
                }
            } else {

                prev = node;

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
