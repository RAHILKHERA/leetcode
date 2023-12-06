import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode_515_FindLargestValueinEachTreeRow {
    
}

class Solution_LeetCode_515_FindLargestValueinEachTreeRow {

    public List<Integer> largestValues(TreeNode root) {
        
        List<Integer> result = new ArrayList<Integer>();
        
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            
            int level = queue.size();
            int max = Integer.MIN_VALUE;

            for (int i = 0; i < level; i++) {

                TreeNode node = queue.poll();

                if (max < node.val) {
                    max = node.val;
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }

            }

            result.add(max);
        }

        return result;
    }
}