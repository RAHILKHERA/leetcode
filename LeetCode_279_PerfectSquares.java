import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class LeetCode_279_PerfectSquares {

    private static int[] squareList = new int[101];

    static {
        for (int i = 0; i < squareList.length; i++) {
            squareList[i] = i * i;
        }
    }

    @Test
    public void test1() {
        assertEquals(3, numSquares(12));
    }

    @Test
    public void test2() {
        assertEquals(2, numSquares(13));
    }

    @Test
    public void test3() {
        assertEquals(4, numSquares(23));
    }

    public int numSquares(int n) {

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        dfs(n, dp);

        return dp[n];
    }

    private int dfs(int n, int[] dp) {

        if (n <= 0) {
            return 0;
        }

        int sqrt = (int) Math.sqrt(n);

        if (sqrt * sqrt == n) {
            dp[n] = 1;
            return dp[n];
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        int result = Integer.MAX_VALUE;

        for (int i = 1; i < 101; i++) {

            if (squareList[i] < n) {
                result = Math.min(result, 1 + dfs(n - squareList[i], dp));
            } else {
                break;
            }

        }

        dp[n] = result;

        return result;
    }

}
