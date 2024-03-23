import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LeetCode_513_FindBottomLeftTreeValue {
    public int findBottomLeftValue(TreeNode root) {

        int bottomLeft = root.val;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        List<Integer> level;
        while (!queue.isEmpty()) {
            level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                    level.add(currentNode.left.val);
                }

                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                    level.add(currentNode.right.val);
                }
            }

            if (level.size() > 0) {
                bottomLeft = level.get(0);
            }
        }

        return bottomLeft;
    }

}