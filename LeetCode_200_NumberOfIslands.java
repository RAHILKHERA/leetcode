import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class LeetCode_200_NumberOfIslands {
    public static void main(String[] args) {
        new Solution_LeetCode_200_NumberOfIslands().numIslands(new char[][] {
                { '1', '1', '0', '0', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '1', '0', '0' },
                { '0', '0', '0', '1', '1' },
        });
    }
}

class Solution_LeetCode_200_NumberOfIslands {

    public int numIslands(char[][] grid) {

        Graph graph = new Graph();

        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                if (grid[i][j] == '1') {

                    Integer id = n * i + j;

                    graph.vertexList.add(id);
                    graph.visitedMap.computeIfAbsent(id, key -> false);
                    graph.adjList.computeIfAbsent(id, key -> new ArrayList<Integer>());

                    // Above
                    if (i > 0 && grid[i - 1][j] == '1') {
                        graph.adjList.get(id).add(n * (i - 1) + j);
                    }

                    // Below
                    if (i < m - 1 && grid[i + 1][j] == '1') {
                        graph.adjList.get(id).add(n * (i + 1) + j);
                    }

                    // Left
                    if (j > 0 && grid[i][j - 1] == '1') {
                        graph.adjList.get(id).add(n * i + j - 1);
                    }

                    // Right
                    if (j < n - 1 && grid[i][j + 1] == '1') {
                        graph.adjList.get(id).add(n * i + j + 1);
                    }
                }
            }
        }

        int count = 0;
        for (Integer vertex : graph.vertexList) {
            if (!graph.visitedMap.get(vertex)) {
                count++;
                bfs(graph, vertex);
            }
        }
        return count;
    }

    private void bfs(Graph graph, Integer source) {

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);

        while (!queue.isEmpty()) {
            Integer parent = queue.poll();
            graph.visitedMap.put(parent, true);
            List<Integer> adjIntegers = graph.adjList.get(parent);
            for (Integer node : adjIntegers) {
                if (!graph.visitedMap.get(node))
                    queue.offer(node);
            }
        }

    }

    private class Graph {

        private List<Integer> vertexList;
        private Map<Integer, List<Integer>> adjList;
        private Map<Integer, Boolean> visitedMap;

        Graph() {
            vertexList = new ArrayList<>();
            adjList = new HashMap<>();
            visitedMap = new HashMap<>();
        }
    }

}

class Solution_LeetCode_200_NumberOfIslands_Efficient {

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;

        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0'; // Mark the current cell as visited

        // Explore all four directions
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }

}
