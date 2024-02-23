import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class LeetCode_787_CheapestFlightsWithKStops {

    private int[][] costs;
    private int[][] dp;
    private boolean isInit = false;

    /**
     * 
     */
    @Test
    public void test1() {

        assertEquals(700,
                findCheapestPrice(4,
                        new int[][] { { 0, 1, 100 }, { 1, 2, 100 }, { 2, 0, 100 }, { 1, 3, 600 }, { 2, 3, 200 } }, 0,
                        3,
                        1));
    }

    @Test
    public void test2() {

        assertEquals(6,
                findCheapestPrice(4,
                        new int[][] { { 0, 1, 1 }, { 0, 2, 5 }, { 1, 2, 1 }, { 2, 3, 1 } }, 0,
                        3,
                        1));
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        if (!isInit) {
            init(n, flights, k);
        }

        if (k < 0) {
            return -1;
        }

        if (src == dst) {
            return 0;
        }

        if (k == 0) {
            dp[src][k] = costs[src][dst];
            return costs[src][dst];
        }

        if (dp[src][k] != -1) {
            return dp[src][k];
        }

        /**
         * k > 0
         */

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (costs[src][i] > -1) {
                int remainingCost = findCheapestPrice(n, flights, i, dst, k - 1);
                if (remainingCost > -1) {
                    min = Math.min(min, costs[src][i] + remainingCost);
                }

            }
        }
        dp[src][k] = min == Integer.MAX_VALUE ? -1 : min;

        return dp[src][k];
    }

    private void init(int n, int[][] flights, int k) {

        costs = new int[n][n];
        dp = new int[n][k + 1];

        for (int[] cost : costs) {
            Arrays.fill(cost, -1);
        }

        for (int[] flight : flights) {
            costs[flight[0]][flight[1]] = flight[2];
        }

        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        isInit = true;

    }

}