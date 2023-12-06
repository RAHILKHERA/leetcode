import java.util.HashMap;

public class LeetCode_105_ConstructBinraryTreeFromPreOrderAndInorderTraversal {
    
    public static void main(String[] args) {
        new Solution_LeetCode_105_ConstructBinraryTreeFromPreOrderAndInorderTraversal()
            .buildTree( new int [] {-1}, new int [] {-1});
    }
}

class Solution_LeetCode_105_ConstructBinraryTreeFromPreOrderAndInorderTraversal {

    private static int index = 0;
 
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        index = -1;
        HashMap<Integer,Integer> inorderMap = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        TreeNode mainRoot = build(0, inorder.length - 1, preorder, inorderMap);    
        return mainRoot;
    }

    private TreeNode build(int start, int end, int [] preorder, HashMap<Integer, Integer> map) {

        if (index == preorder.length -1) {
            return null;
        }    
        index++;

        int target = preorder[index];
        TreeNode root = new TreeNode(target);
        int inOrderIndex = map.get(target);

        //left node
        int startSubTree = start; 
        int endSubTree   = inOrderIndex -1;
        if (startSubTree <= endSubTree) {
            root.left = build(startSubTree, endSubTree, preorder, map);
        } 

        //right node
        startSubTree = inOrderIndex + 1;
        endSubTree = end;
        if (startSubTree <= endSubTree) {
           root.right = build(startSubTree, endSubTree, preorder, map);
            
        } 
        
        return root;
    }
}