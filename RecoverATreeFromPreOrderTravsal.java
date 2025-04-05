import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import org.junit.Test;

public class RecoverATreeFromPreOrderTravsal {

    @Test
    public void test1() {
        recoverFromPreorder("1-2--3---4-5--6---7");
    }

    public TreeNode recoverFromPreorder(String traversal) {
        int n = traversal.length();
        Map<Integer, Queue<Integer>> map = new HashMap<>(); // levels vs nodes for that level.
        char[] ch = traversal.toCharArray();
        int levels = 0;
        int idx = 0;
        while (idx < n) {

            if (ch[idx] == '-') {
                levels = 0;
                while (idx < n && ch[idx] == '-') {
                    levels++;
                    idx++;
                }
            } else {
                StringBuilder builder = new StringBuilder();
                while (idx < n && Character.isDigit(ch[idx])) {
                    builder.append(ch[idx]);
                    idx++;
                }
                int value = Integer.parseInt(builder.toString());
                map.computeIfAbsent(levels, key -> new LinkedList<>()).offer(value);
            }
        }

        Queue<TreeNode> queue = new LinkedList<>();
        int level = 0;
        TreeNode root = null;

        do {
            Queue<Integer> values = map.getOrDefault(level, new LinkedList<>());
            if (values.isEmpty())
                break;
            if (root == null) {
                root = new TreeNode(values.poll());
                queue.offer(root);
            } else {
                int size = queue.size();
                while (size-- > 0) {
                    TreeNode parent = queue.poll();
                    TreeNode leftChild = new TreeNode(values.poll());
                    TreeNode rightChild = !values.isEmpty() ? new TreeNode(values.poll()) : null;
                    parent.left = leftChild;
                    queue.offer(leftChild);
                    if (rightChild != null) {
                        parent.right = rightChild;
                        queue.offer(rightChild);
                    }
                }
            }
            level++;
        } while (!queue.isEmpty());

        return root;
    }
}
