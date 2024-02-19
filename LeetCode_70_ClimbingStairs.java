import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class LeetCode_70_ClimbingStairs {

    @Test
    public void test() {
        assertEquals(3, climbStairs(3));
    }

    public int climbStairs(int n) {

        int dp[] = new int[n + 1];

        Arrays.fill(dp, -1);

        dp[n] = 1;
        dp[n - 1] = 1;

        return dfs(n, 0, dp);
    }

    public int dfs(int steps, int step, int[] dp) {

        if (step > steps) {
            return 0;
        }

        if (dp[step] != -1) {
            return dp[step];
        }

        int result = dfs(steps, step + 1, dp) + dfs(steps, step + 2, dp);

        dp[step] = result;

        return result;

    }
}
