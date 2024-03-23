import java.util.ArrayDeque;
import java.util.Queue;

public class LeetCode_1609_EvenOddTree {
    public boolean isEvenOddTree(TreeNode root) {

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        boolean evenLevel = true;

        while (!queue.isEmpty()) {

            int size = queue.size();
            int prev = evenLevel ? Integer.MIN_VALUE : Integer.MAX_VALUE;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (evenLevel && (node.val <= prev || node.val % 2 == 0)) {
                    return false;
                } else if (node.val >= prev || node.val % 2 != 0) {
                    return false;
                }
                prev = node.val;

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            evenLevel = !evenLevel;
        }
        return true;
    }

}
