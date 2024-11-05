import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LeetCode_713_SubarrayProductLessThanK {

    @Test
    public void test1() {
        assertEquals(8, numSubarrayProductLessThanK(new int[] { 10, 5, 2, 6 }, 100));
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {

        if (k <= 1) {
            return 0;
        }

        int totalCount = 0;
        int product = 1;

        for (int left = 0, right = 0; left < nums.length && right < nums.length; right++) {

            product *= nums[right];

            while (product >= k) {
                product /= nums[left++];
            }

            totalCount += right - left + 1;
        }

        return totalCount;
    }
}
