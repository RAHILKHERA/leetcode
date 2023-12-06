public class LeetCode_112_PathSum {
    
}

class Solution_LeetCode_112_PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {

        return calculatSum(root, 0, targetSum);
    }

    private boolean calculatSum(TreeNode root, int currentSum, int targetSum) {
        if (root == null) {
            return false;
        } 

        currentSum += root.val;

        if (root.left == null && root.right == null) {
            return currentSum == targetSum;
        }  

        boolean found = false; 

        if (root.left != null) {
            found = calculatSum(root.left, currentSum, targetSum);
        } 

        if (!found && root.right != null) {
            found = calculatSum(root.right, currentSum, targetSum);
        }
        return found;
    }

}
