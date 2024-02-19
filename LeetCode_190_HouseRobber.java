import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class LeetCode_190_HouseRobber {

    @Test
    public void test1() {

        assertEquals(4, rob(new int[] { 1, 2, 3, 1 }));
    }

    @Test
    public void test2() {

        assertEquals(12, rob(new int[] { 2, 7, 9, 3, 1 }));
    }

    @Test
    public void test3() {

        assertEquals(4, rob(new int[] { 2, 1, 1, 2 }));
    }

    public int rob(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] dp = new int[nums.length];

        Arrays.fill(dp, -1);

        int dfs0 = dfs(nums, dp, 0);
        int dfs1 = dfs(nums, dp, 1);

        return Math.max(dfs0, dfs1);
    }

    private int dfs(int[] nums, int[] dp, int index) {

        if (index >= nums.length) {
            return 0;
        }

        if (index == nums.length - 1 || index == nums.length - 2) {
            return nums[index];
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        int max = 0;

        for (int i = index + 1; i < nums.length; i++) {

            if (i - index != 1) {
                max = Math.max(max, nums[index] + dfs(nums, dp, i));
            }

        }

        dp[index] = max;
        return max;
    }
}
