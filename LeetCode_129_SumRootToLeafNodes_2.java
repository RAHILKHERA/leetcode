import java.util.ArrayList;
import java.util.List;

public class LeetCode_129_SumRootToLeafNodes_2 {
    public int sumNumbers(TreeNode root) {

        List<Integer> paths = new ArrayList<>();

        pathTraversal(root, paths, 0);

        int sum = 0;
        for (Integer integer : paths) {
            sum += integer;
        }
        return sum;
    }

    private void pathTraversal(TreeNode node, List<Integer> paths, int currentSum) {

        if (node == null) {
            return;
        }

        currentSum = 10 * currentSum + node.val;

        if (node.left == null && node.right == null) {
            paths.add(currentSum);
        }

        pathTraversal(node.left, paths, currentSum);
        pathTraversal(node.right, paths, currentSum);

    }

}
