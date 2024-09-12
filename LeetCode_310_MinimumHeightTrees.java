import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class LeetCode_310_MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        List<Integer> result = new ArrayList<>();
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        for (int i = 0; i < edges.length; i++) {
            adjList.computeIfAbsent(edges[i][0], (key) -> new ArrayList<>()).add(edges[i][1]);
            adjList.computeIfAbsent(edges[i][1], (key) -> new ArrayList<>()).add(edges[i][0]);
        }

        for (int i = 0; i < edges.length; i++) {
            Set<Integer> visited = new HashSet<>();
            Queue<Integer> queue = new LinkedList<>();

            visited.add(i);
            queue.offer(i);

            while (!queue.isEmpty()) {

                int size = queue.size();

                for (int j = 0; j < size; j++) {

                    int node = queue.poll();

                    List<Integer> neg = adjList.get(node);

                    for (Integer integer : neg) {
                        if (!visited.contains(integer)) {
                            visited.add(integer);
                            queue.add(integer);
                        }
                    }

                }

            }

        }

        return result;
    }
}
