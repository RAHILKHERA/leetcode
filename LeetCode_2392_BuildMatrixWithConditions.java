import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class LeetCode_2392_BuildMatrixWithConditions {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {

        int[] rowIndexes = new int[k + 1];
        boolean cycle = topologicalSort(k, rowConditions, rowIndexes);

        if (cycle) {
            return new int[][] {};
        }

        int[] colIndexes = new int[k + 1];
        cycle = topologicalSort(k, colConditions, colIndexes);
        if (cycle) {
            return new int[][] {};
        }

        int[][] result = new int[k][k];

        for (int i = 1; i <= k; i++) {
            result[rowIndexes[i]][colIndexes[i]] = i;
        }

        return result;
    }

    private boolean topologicalSort(int k, int[][] conditions, int[] indexes) {

        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] condition : conditions) {
            graph.computeIfAbsent(condition[0], key -> new HashSet<>()).add(condition[1]);
        }

        int[] inorderDegree = new int[k + 1];

        for (int i = 1; i < inorderDegree.length; i++) {
            if (graph.containsKey(i)) {
                for (int node : graph.get(i)) {
                    inorderDegree[node]++;
                }
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i < inorderDegree.length; i++) {
            if (inorderDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int visited_nodes = 0;
        int index = 0;

        while (!queue.isEmpty()) {

            int node = queue.poll();
            indexes[node] = index;
            index++;
            visited_nodes++;
            Set<Integer> neighbours = graph.get(node);
            if (neighbours != null) {
                for (Integer neighbour : neighbours) {
                    if (--inorderDegree[neighbour] == 0) {
                        queue.add(neighbour);
                    }
                }
            }
        }

        // Cycle found.
        if (visited_nodes != k) {
            return true;
        }

        return false;
    }
}
