public class LeetCode_230_KthSmallestElementinaBST {
    
}

class Solution_LeetCode_230_KthSmallestElementinaBST {
    
    private int current = 0;
    private int ans = -1; 
    
    public int kthSmallest(TreeNode root, int k) {
    
        if (root.left != null) {
            kthSmallest(root.left, k);
        }

        current++;

        if (current == k) {
            ans = root.val;
            return ans;
        }

        if (root.right != null) {
            kthSmallest(root.right, k);
        }


        return ans;
    }



}
