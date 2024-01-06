import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class LeetCode_45_JumpGame2 {

    @Test
    public void test() {
        assertEquals(2, jump(new int[] { 2, 3, 1, 1, 4 }));
        assertEquals(0, jump(new int[] { 0 }));
        assertEquals(3, jump(new int[] { 1, 2, 1, 1, 1 }));
        assertEquals(2, jump(new int[] { 7, 0, 9, 6, 9, 6, 1, 7, 9, 0, 1, 2, 9, 0, 3 }));
    }

    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);

        return dfs(nums, dp, 0);
    }

    private int dfs(int[] nums, int[] dp, int index) {
        if (index >= nums.length - 1) {
            return 0;
        }

        if (dp[index] != Integer.MAX_VALUE) {
            return dp[index];
        }

        int jumps = Integer.MAX_VALUE;

        for (int i = 1; i <= nums[index]; i++) {
            int subJumps = dfs(nums, dp, index + i);
            if (subJumps != Integer.MAX_VALUE) {
                jumps = Math.min(jumps, subJumps + 1);
            }
        }

        dp[index] = jumps;
        return jumps;
    }

}
