import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class LeetCode_1530_NumberofGoodLeafNodesPairs {
    public int countPairs(TreeNode root, int distance) {

        Map<TreeNode, List<TreeNode>> map = new HashMap<>();
        Set<TreeNode> leafNodes = new HashSet<>();
        int result = 0;

        traversal(root, null, leafNodes, map);

        for (TreeNode leafNode : leafNodes) {

            Queue<TreeNode> queue = new LinkedList<>();
            Set<TreeNode> visited = new HashSet<>();

            queue.add(leafNode);
            visited.add(leafNode);

            for (int i = 0; i <= distance; i++) {

                int size = queue.size();

                for (int j = 0; j < size; j++) {

                    TreeNode currNode = queue.poll();

                    if (leafNodes.contains(currNode) && currNode != leafNode) {
                        result++;
                    }

                    if (map.containsKey(currNode)) {

                        for (TreeNode neighbour : map.get(currNode)) {
                            if (!visited.contains(neighbour)) {
                                queue.add(neighbour);
                                visited.add(neighbour);
                            }
                        }

                    }

                }

            }
        }

        return result;
    }

    private void traversal(TreeNode node, TreeNode parent, Set<TreeNode> leafNodes, Map<TreeNode, List<TreeNode>> map) {

        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            leafNodes.add(node);
        }

        if (parent != null) {
            map.computeIfAbsent(parent, k -> new ArrayList<>()).add(node);
            map.computeIfAbsent(node, k -> new ArrayList<>()).add(parent);
        }

        traversal(node.left, node, leafNodes, map);
        traversal(node.right, node, leafNodes, map);
    }
}
