
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.Test;

public class LeetCode_1235_MaximumProfitInJobScheduling {

    @Test
    public void test() {

        assertEquals(120,
                jobScheduling(new int[] { 1, 2, 3, 3 }, new int[] { 3, 4, 5, 6 }, new int[] {
                        50, 10, 40, 70 }));

        assertEquals(150,
                jobScheduling(new int[] { 1, 2, 3, 4, 6 }, new int[] { 3, 5, 10, 6, 9 },
                        new int[] { 20, 20, 100, 70, 60 }));

        assertEquals(6,
                jobScheduling(new int[] { 1, 1, 1 }, new int[] { 2, 3, 4 },
                        new int[] { 5, 6, 4 }));

    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {

        int n = startTime.length;

        Pair[] jobs = new Pair[n];
        for (int i = 0; i < n; i++) {
            jobs[i] = new Pair(startTime[i], endTime[i], profit[i]);
        }

        Arrays.sort(jobs, Comparator.comparingInt(Pair::getStartTime).thenComparingInt(Pair::getEndTime));

        int[] dp = new int[n];

        Arrays.fill(dp, -1);

        return dfs(jobs, dp, 0);
    }

    private int dfs(Pair[] jobs, int[] dp, int currentIndex) {

        if (currentIndex == jobs.length || currentIndex < 0) {
            return 0;
        }

        if (dp[currentIndex] != -1) {
            return dp[currentIndex];
        }

        int profitExclude = dfs(jobs, dp, currentIndex + 1);

        int nextJobIndex = Arrays.binarySearch(jobs, new Pair(jobs[currentIndex].endTime, -1, -1),
                Comparator.comparingInt(pair -> pair.startTime));

        int profitInclude = jobs[currentIndex].profit + dfs(jobs, dp, nextJobIndex);

        dp[currentIndex] = profitInclude > profitExclude ? profitInclude : profitExclude;

        return dp[currentIndex];
    }

    private static class Pair {
        int startTime;
        int endTime;
        int profit;

        Pair(int startTime, int endTime, int profit) {

            this.startTime = startTime;
            this.endTime = endTime;
            this.profit = profit;
        }

        public int getStartTime() {
            return startTime;
        }

        public int getEndTime() {
            return endTime;
        }

    }
}
