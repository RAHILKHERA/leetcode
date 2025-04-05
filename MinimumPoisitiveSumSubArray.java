import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class MinimumPoisitiveSumSubArray {

    @Test
    public void test1() {
        List<Integer> nums = new ArrayList<>();
        nums.add(3);
        nums.add(-2);
        nums.add(1);
        nums.add(4);
        assertEquals(1, minimumSumSubarray(nums, 2, 3));
    }

    @Test
    public void test2() {
        List<Integer> nums = new ArrayList<>();
        nums.add(-18);
        nums.add(6);
        nums.add(9);
        assertEquals(6, minimumSumSubarray(nums, 1, 3));
    }

    @Test
    public void test3() {
        List<Integer> nums = new ArrayList<>();
        nums.add(15);
        nums.add(-21);
        nums.add(16);
        assertEquals(10, minimumSumSubarray(nums, 1, 3));
    }

    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();
        int left = 0;
        int right = 0;
        int minSum = Integer.MAX_VALUE;
        int sum = 0;
        while (right < n) {

            sum += nums.get(right);
            int currentWindowSize = right - left + 1;

            if (currentWindowSize >= l && currentWindowSize <= r && sum > 0) {
                minSum = Math.min(minSum, sum);
            }

            right++;
        }

        return minSum == Integer.MAX_VALUE ? -1 : minSum;
    }
}
