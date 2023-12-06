public class LeetCode_222_CountCompleteTreeNodes {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;

        int height = new Solution_LeetCode_222_CountCompleteTreeNodes().countNodes(node1);
        System.out.println(height);

        
    }
}

class Solution_LeetCode_222_CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int leftHeight = 0, rightHeight = 0;
        TreeNode left = root.left, right = root.right;

        while (left != null) {
            leftHeight++;
            left = left.left;
        }

        while (right != null) {
            rightHeight++;
            right = right.right;
        }

        if (leftHeight == rightHeight) {
            return (int) Math.pow(2, leftHeight+1) - 1;
        } 

        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
