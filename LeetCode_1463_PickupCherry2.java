import java.util.Arrays;

public class LeetCode_1463_PickupCherry2 {

    public int cherryPickup(int[][] grid) {

        int ROWS = grid.length;
        int COLS = grid[0].length;
        int[][][] dp = new int[ROWS][COLS][COLS];

        for (int[][] is : dp) {
            for (int[] is2 : is) {
                Arrays.fill(is2, -1);
            }
        }

        return dfs(grid, dp, 0, 0, COLS - 1);
    }

    private int dfs(int[][] grid, int[][][] dp, int r, int c1, int c2) {

        int ROWS = grid.length;
        int COLS = grid[0].length;

        if (c1 == c2 || Math.min(c1, c2) < 0 || Math.max(c1, c2) == COLS) {
            return 0;
        }

        if (dp[r][c1][c2] != -1) {
            return dp[r][c1][c2];
        }

        if (r == ROWS - 1) {
            return grid[r][c1] + grid[r][c2];
        }

        int result = 0;

        for (int c1_d : new int[] { -1, 0, 1 }) {
            for (int c2_d : new int[] { -1, 0, 1 }) {
                result = Math.max(result, dfs(grid, dp, r + 1, c1 + c1_d, c2 + c2_d));
            }
        }

        dp[r][c1][c2] = result + grid[r][c1] + grid[r][c2];
        return dp[r][c1][c2];
    }
}
