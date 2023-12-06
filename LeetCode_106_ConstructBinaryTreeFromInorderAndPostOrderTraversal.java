import java.util.HashMap;

public class LeetCode_106_ConstructBinaryTreeFromInorderAndPostOrderTraversal {
    public static void main(String[] args) {
        new Solution_LeetCode_106_ConstructBinaryTreeFromInorderAndPostOrderTraversal()
        .buildTree( new int [] {9,15,7,20,3}, new int [] {9,3,15,20,7});
    }
}

class Solution_LeetCode_106_ConstructBinaryTreeFromInorderAndPostOrderTraversal {

    private static int index = 0;

    public TreeNode buildTree(int[] postorder, int[] inorder) {
        
        index = postorder.length;
        
        HashMap<Integer,Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        TreeNode mainRoot = build(0, inorder.length - 1, postorder, inorderMap);    
        return mainRoot;
    }

    private TreeNode build(int start, int end, int [] postorder, HashMap<Integer, Integer> map) {

        if (index == -1) {
            return null;
        }    
        index--;

        int target = postorder[index];
        TreeNode root = new TreeNode(target);
        int inOrderIndex = map.get(target);

        //right node
        int startSubTree = inOrderIndex + 1;
        int endSubTree = end;
        if (startSubTree <= endSubTree) {
           root.right = build(startSubTree, endSubTree, postorder, map);
            
        } 

        //left node
        startSubTree = start; 
        endSubTree   = inOrderIndex - 1;
        if (startSubTree <= endSubTree) {
            root.left = build(startSubTree, endSubTree, postorder, map);
        } 
        
        return root;
    }
}
