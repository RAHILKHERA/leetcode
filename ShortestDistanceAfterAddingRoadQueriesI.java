import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class ShortestDistanceAfterAddingRoadQueriesI {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {

        int m = queries.length;
        List<Integer>[] adjMatrix = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            List<Integer> neigh = new ArrayList<>();
            if (i + 1 < n) {
                neigh.add(i + 1);
            }
            adjMatrix[i] = neigh;
        }

        int[] result = new int[m];
        int index = 0;
        for (int[] query : queries) {
            int source = query[0];
            int destination = query[1];
            adjMatrix[source].add(destination);
            result[index++] = bfs(adjMatrix, n - 1);
        }

        return result;
    }

    private int bfs(List<Integer>[] adjMatrix, int target) {

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        visited.add(0);
        queue.add(0);
        int len = 0;
        while (!queue.isEmpty()) {
            boolean targetFound = false;
            int size = queue.size();
            while (size-- > 0) {
                int current = queue.poll();
                if (current == target) {
                    targetFound = true;
                    break;
                }

                List<Integer> neighbours = adjMatrix[current];
                for (int neigh : neighbours) {
                    if (visited.contains(neigh)) {
                        continue;
                    }
                    visited.add(neigh);
                    queue.add(neigh);
                }
            }
            if (targetFound) {
                break;
            }
            len++;

        }
        return len;
    }
}
