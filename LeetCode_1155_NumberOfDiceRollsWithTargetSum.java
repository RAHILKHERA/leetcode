import java.util.Arrays;

public class LeetCode_1155_NumberOfDiceRollsWithTargetSum {
    public int numRollsToTarget(int n, int k, int target) {

        int[][] dp = new int[n + 1][target + 1];

        for (int[] i : dp) {
            Arrays.fill(i, -1);
        }

        dfs(n, k, target, dp);

        return dp[n][target];

    }

    private int dfs(int n, int k, int target, int[][] dp) {

        if (n < 0 || target < 0)
            return 0;

        if (n == 0 && target == 0) {
            return 1;
        }

        if (dp[n][target] != -1) {
            return dp[n][target];
        }

        int totalWays = 0;

        for (int i = 1; i <= k; i++) {
            if (i <= target) {
                totalWays = (totalWays + dfs(n - 1, k, target - i, dp)) % 1000000007;
            }
        }

        dp[n][target] = totalWays;
        return totalWays;
    }
}
