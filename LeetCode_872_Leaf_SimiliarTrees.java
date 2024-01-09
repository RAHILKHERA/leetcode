import java.util.ArrayList;
import java.util.List;

public class LeetCode_872_Leaf_SimiliarTrees {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {

        List<Integer> result1 = new ArrayList<>();
        List<Integer> result2 = new ArrayList<>();

        inOrderTraversal(root1, result1);
        inOrderTraversal(root2, result2);

        return result1.equals(result2);
    }

    private void inOrderTraversal(TreeNode node, List<Integer> result) {

        if (node == null) {
            return;
        }

        inOrderTraversal(node.left, result);

        if (node.left == null && node.right == null) {
            result.add(node.val);
        }

        inOrderTraversal(node.right, result);
    }

}
