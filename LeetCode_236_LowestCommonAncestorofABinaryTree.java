import java.util.ArrayList;
import java.util.List;

public class LeetCode_236_LowestCommonAncestorofABinaryTree {
    public static void main(String[] args) {

        TreeNode node1 = new TreeNode(3); 
        TreeNode node2 = new TreeNode(5); 
        TreeNode node3 = new TreeNode(1); 
        TreeNode node4 = new TreeNode(6); 
        TreeNode node5 = new TreeNode(2); 
        TreeNode node6 = new TreeNode(0); 
        TreeNode node7 = new TreeNode(8); 
        TreeNode node8 = new TreeNode(7); 
        TreeNode node9 = new TreeNode(4); 

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node5.left = node8;
        node5.right = node9;

        TreeNode LCA = new Solution_LeetCode_236_LowestCommonAncestorofABinaryTree().lowestCommonAncestor(node1, node2, node9);
        System.out.println(LCA.val);
    }
    
}

class Solution_LeetCode_236_LowestCommonAncestorofABinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if (root == null) {
            return new TreeNode(0);
        }

        if (root.val == p.val || root.val == q.val) {
            return root;
        }

        List<TreeNode> pPath = new ArrayList<TreeNode> ();
        List<TreeNode> qPath = new ArrayList<TreeNode> ();

        searchPath(root, p, pPath, false, q, qPath, false);
        
        int n = pPath.size() > qPath.size() ? qPath.size() : pPath.size();

        TreeNode LCA = root;
        for (int i = 0; i < n; i++) {
            if (pPath.get(i).val == qPath.get(i).val) {
                LCA = pPath.get(i);
            }
        }
        return LCA;        
    }

    private boolean[] searchPath(TreeNode node, 
                            TreeNode p, 
                            List<TreeNode> pPath, 
                            boolean pFound, 
                            TreeNode q,
                            List<TreeNode> qPath, 
                            boolean qFound) {

        if (pFound && qFound) {
            return new boolean[ ] {pFound, qFound};
        }

        if(!pFound) {
            pFound = p.val == node.val;
            pPath.add(node);    
        }        
        
        if(!qFound) {
            qFound = q.val == node.val;
            qPath.add(node);
        }

        if (node.left == null && node.right == null) {
            if(!pFound) pPath.remove(node);
            if(!qFound) qPath.remove(node);
            return new boolean[ ] {pFound, qFound};
        } 
        
        if (!pFound || !qFound) {
            if (node.left != null) {
                boolean [] status =   searchPath(node.left, p, pPath, pFound, q, qPath, qFound);
                pFound = status[0];
                qFound = status[1];
            }
        } else {
            return new boolean[ ] {pFound, qFound};
        }
         
        if (!pFound || !qFound) {
            if (node.right != null) {

                boolean [] status =  searchPath(node.right, p, pPath, pFound, q, qPath, qFound);
                pFound = status[0];
                qFound = status[1];
            }
        } else {
            return new boolean[ ] {pFound, qFound};
        }
        
        if (!pFound) {
            pPath.remove(node);
        }

         if (!qFound) {
            qPath.remove(node);
        }

        return new boolean[ ] {pFound, qFound};
    }

}