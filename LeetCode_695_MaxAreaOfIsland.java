public class LeetCode_695_MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int area = 0, max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') { // Start of the island
                    area = dfs(grid, i, j);
                    max = Math.max(area, max);
                }
            }
        }

        return max;
    }

    private int dfs(int[][] grid, int i, int j) {

        int m = grid.length;
        int n = grid[0].length;
        int sum = 0;

        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0') {
            return sum;
        }

        grid[i][j] = '0'; // Marking the cell as visited.

        sum = dfs(grid, i - 1, j) + dfs(grid, i + 1, j) + dfs(grid, i, j - 1) + dfs(grid, i, j + 1);

        return sum;
    }
}
