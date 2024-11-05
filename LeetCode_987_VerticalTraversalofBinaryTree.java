import java.util.List;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.Collections;

public class LeetCode_987_VerticalTraversalofBinaryTree {
    public List<List<Integer>> verticalTraversal(TreeNode root) {

        TreeMap<Integer, List<int[]>> map = new TreeMap<>();
        traversal(root, 0, 0, map);

        List<List<Integer>> result = new ArrayList<>();

        for (Map.Entry<Integer, List<int[]>> entry : map.entrySet()) {
            List<int[]> list = entry.getValue();
            Collections.sort(list, (a, b) -> {
                if (a[0] == b[0]) {
                    return Integer.compare(a[1], b[1]);
                }
                return Integer.compare(a[0], b[0]);

            });

            List<Integer> row = new ArrayList<>();
            for (int[] values : list) {
                row.add(values[1]);
            }
            result.add(row);

        }

        return result;
    }

    private void traversal(TreeNode node, int row, int col, TreeMap<Integer, List<int[]>> map) {

        if (node == null) {
            return;
        }

        map.computeIfAbsent(col, key -> new ArrayList<int[]>()).add(new int[] { row, node.val });
        traversal(node.left, row + 1, col - 1, map);
        traversal(node.right, row + 1, col + 1, map);
    }
}
