import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class LeetCode_576_OutOfBoundaryPaths {

    @Test
    public void test1() {
        assertEquals(6, findPaths(2, 2, 2, 0, 0));
    }

    @Test
    public void test2() {
        assertEquals(12, findPaths(1, 3, 3, 0, 1));
    }

    @Test
    public void test3() {
        assertEquals(1104, findPaths(2, 3, 8, 1, 0));
    }

    @Test
    public void test4() {
        assertEquals(0, findPaths(10, 10, 0, 5, 5));
    }

    @Test
    public void test5() {
        assertEquals(914783380, findPaths(8, 50, 23, 5, 26));
    }

    private static final int MOD = 1000000007;
    private int[][][] dp;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {

        dp = new int[m][n][maxMove + 1];

        for (int[][] is : dp) {
            for (int[] is2 : is) {
                Arrays.fill(is2, -1);
            }

        }

        dfs(maxMove, startRow, startColumn);

        return dfs(maxMove, startRow, startColumn);
    }

    private int dfs(int maxMove, int i, int j) {

        if (i == dp.length || j == dp[0].length || i < 0 || j < 0) {
            return 1;
        }

        if (maxMove == 0) {
            return 0;
        }

        if (dp[i][j][maxMove] != -1) {
            return dp[i][j][maxMove];
        }

        int up = dfs(maxMove - 1, i - 1, j) % MOD;
        int down = dfs(maxMove - 1, i + 1, j) % MOD;
        int left = dfs(maxMove - 1, i, j - 1) % MOD;
        int right = dfs(maxMove - 1, i, j + 1) % MOD;

        dp[i][j][maxMove] = ((up + down) % MOD + (left + right) % MOD) % MOD;

        return dp[i][j][maxMove];

    }
}