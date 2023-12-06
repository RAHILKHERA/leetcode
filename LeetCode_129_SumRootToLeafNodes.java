import java.util.ArrayList;

public class LeetCode_129_SumRootToLeafNodes {

    public static void main(String[] args) {
        
        // TreeNode node1 = new TreeNode(1);
        // TreeNode node2 = new TreeNode(2);
        // TreeNode node3 = new TreeNode(3);

        // node1.left = node2;
        // node1.right = node3;

        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(0);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(1);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;

        new Solution_LeetCode_129_SumRootToLeafNodes().sumNumbers(node1);
    }
    
}

class Solution_LeetCode_129_SumRootToLeafNodes {
    
    public int sumNumbers(TreeNode root) {
        
        ArrayList <Integer> pathSum = new ArrayList<>();

        pathTraversal(root, 0, pathSum);
        
        int sum = 0;

        for (int num : pathSum) {
            sum += num;
        }
        return sum;    
    }

    private void pathTraversal(TreeNode node, int prevsum, ArrayList<Integer> pathSum) {

        int sum = prevsum * 10 + node.val;

        if (node.left == null  && node.right == null) {
            pathSum.add(sum);
        }

        if (node.left != null) {
            pathTraversal(node.left, sum, pathSum);
        }

        if (node.right != null) {
            pathTraversal(node.right, sum, pathSum);
        }

    }
}