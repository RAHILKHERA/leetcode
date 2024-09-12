import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class LeetCode_1509_MinimumDifferenceBetweenLargestandSmallestValueinThreeMoves {

    @Test
    public void test1() {
        assertEquals(0, minDifference(new int[] { 3, 100, 20 }));
    }

    @Test
    public void test2() {
        assertEquals(1, minDifference(new int[] { 1, 5, 0, 10, 14 }));
    }

    public int minDifference(int[] nums) {

        int n = nums.length;

        if (n <= 4) {
            return 0;
        }
        Arrays.sort(nums);

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < 4; i++) {

            if (n - 4 + i >= 0 && i < n) {
                min = Math.min(min, nums[n - 4 + i] - nums[i]);
            }
        }

        return min;
    }
}
