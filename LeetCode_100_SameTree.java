public class LeetCode_100_SameTree {
    
}

class Solution_LeetCode_100_SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        
        if (p == null && q == null) {
            return true;    
        } else if ((p == null && q!= null) || (p!= null && q == null)) {
            return false;
        } else if (p.val == q.val) {

            boolean leftTree = isSameTree(p.left, q.left);
            boolean rightTree = isSameTree(p.right, q.right);

            return leftTree && rightTree;

        } else {
            return false;
        }
        
    }
}