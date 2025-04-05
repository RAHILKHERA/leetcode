import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class ReverseOddLevelsOfBinaryTree {
    public TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        int level = 0;
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                // Perfect tree so no need to check null for both child nodes.
                if (node.left != null) {
                    queue.offer(node.left);
                    queue.offer(node.right);
                }

                if (level % 2 == 0) {
                    deque.offerFirst(node.left.val);
                    deque.offerFirst(node.right.val);
                } else {
                    node.val = deque.pollFirst();
                }

            }
            level++;
        }

        return root;
    }
}
