import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class LeetCode_1335_MinimumDifficultyOfJobSchedule {

    @Test
    public void test() {

        assertEquals(7, minDifficulty(new int[] { 6, 5, 4, 3, 2, 1 }, 2));

    }

    public int minDifficulty(int[] jobDifficulty, int d) {

        /**
         * If the number of jobs are less than number of days. Then all the days won't
         * be having the jobs to perform.
         */
        if (jobDifficulty.length < d)
            return -1;

        /**
         * If the number of jobs is equal to number of days. Then we have 1 job per day.
         * Hence the summation of the job difficulty will be the min Difficulty.
         */
        if (jobDifficulty.length == d) {
            int ans = 0;

            for (int job : jobDifficulty) {
                ans += job;
            }

            return ans;
        }

        int[][] dp = new int[d + 1][jobDifficulty.length];
        for (int[] row : dp)
            Arrays.fill(row, -1);

        return dfs(jobDifficulty, d, dp, 0);
    }

    private int dfs(int[] jobDifficulty, int d, int[][] dp, int idx) {

        if (dp[d][idx] != -1)
            return dp[d][idx];

        if (d == 1) {
            int max = 0;
            while (idx < jobDifficulty.length) {
                max = Math.max(max, jobDifficulty[idx++]);
            }
            return max;
        }

        int max = 0;
        int result = Integer.MAX_VALUE;
        for (int i = idx; i < jobDifficulty.length - d + 1; i++) {

            max = Math.max(max, jobDifficulty[i]);
            result = Math.min(result, max + dfs(jobDifficulty, d - 1, dp, i + 1));
        }

        dp[d][idx] = result;

        return result;
    }
}
