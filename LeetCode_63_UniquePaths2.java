import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class LeetCode_63_UniquePaths2 {
    @Test
    public void test1() {

        assertEquals(2, uniquePathsWithObstacles(new int[][] { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } }));
    }

    @Test
    public void test2() {

        assertEquals(1, uniquePathsWithObstacles(new int[][] { { 0, 1 }, { 0, 0 } }));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return dfs(obstacleGrid, 0, 0, dp);
    }

    private int dfs(int[][] grid, int i, int j, int[][] dp) {

        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 1) {
            return 0;
        }

        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return 1;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        dp[i][j] = dfs(grid, i + 1, j, dp) + dfs(grid, i, j + 1, dp);

        return dp[i][j];
    }
}
