public class LeetCode_2265_CountNodesEqualToAverageOfSubTree {
    
}

class Solution_LeetCode_2265_CountNodesEqualToAverageOfSubTree {

    private int count = 0;

    public int averageOfSubtree(TreeNode root) {

        preOrder(root);
        return count; 
    }

    private int[] preOrder (TreeNode node) {

        int[] sumN;
        int[] leftsumN = new int[]{0,0};
        int[] rightsumN = new int[]{0,0};

        if (node.left != null) {
            leftsumN = preOrder(node.left);
        }

        if (node.right != null) {
            rightsumN = preOrder(node.right);
        }

        sumN = new int [] { leftsumN[0] + rightsumN[0] + node.val, leftsumN[1] + rightsumN[1] + 1};
        
        if (sumN[0]/sumN[1] == node.val) {
            count++;
        }
         

        return sumN;
    } 
}