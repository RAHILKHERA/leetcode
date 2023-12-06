import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;


public class LeetCode_637_AverageOfLevelsInBinaryTree {
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

        new Solution_LeetCode_637_AverageOfLevelsInBinaryTree().averageOfLevels(node1);

    }
}

class Solution_LeetCode_637_AverageOfLevelsInBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        
        Queue<TreeNode> queue = new LinkedList<>();
        List <Double> avgs = new ArrayList<>();
        double sum = 0;
        double count = 0;
        queue.offer(root);
        queue.offer(null);
        while(!queue.isEmpty()) {

            TreeNode node = queue.poll();
            if (node == null) {
                avgs.add(sum/count);
                sum = 0;
                count = 0;

                if (!queue.isEmpty()) queue.offer(null);
                 
                
            } else {
                sum = sum + node.val;
                count++;
                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return avgs;
    }
}
