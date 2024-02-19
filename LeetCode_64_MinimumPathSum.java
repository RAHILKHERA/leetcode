import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class LeetCode_64_MinimumPathSum {

    @Test
    public void test1() {

        assertEquals(7, minPathSum(new int[][] { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } }));
    }

    @Test
    public void test2() {

        assertEquals(12, minPathSum(new int[][] { { 1, 2, 3 }, { 4, 5, 6 } }));
    }

    public int minPathSum(int[][] grid) {

        int[][] dp = new int[grid.length][grid[0].length];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return dfs(grid, 0, 0, dp);
    }

    private int dfs(int[][] grid, int i, int j, int[][] dp) {

        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return Integer.MAX_VALUE;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int down = dfs(grid, i + 1, j, dp);
        int right = dfs(grid, i, j + 1, dp);
        int min = Integer.MAX_VALUE;

        if (down != Integer.MAX_VALUE) {
            min = Math.min(min, down);
        }

        if (right != Integer.MAX_VALUE) {
            min = Math.min(min, right);
        }

        if (min != Integer.MAX_VALUE) {
            dp[i][j] = grid[i][j] + min;
        } else {
            dp[i][j] = grid[i][j];
        }

        return dp[i][j];
    }
}
