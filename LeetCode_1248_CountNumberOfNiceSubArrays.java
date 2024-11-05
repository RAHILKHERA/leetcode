import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LeetCode_1248_CountNumberOfNiceSubArrays {

    @Test
    public void test1() {
        assertEquals(2, numberOfSubarrays(new int[] { 1, 1, 2, 1, 1 }, 3));
    }

    public int numberOfSubarrays(int[] nums, int k) {
        int atMostK = atMostK(nums, k);
        int atMostKminus1 = atMostK(nums, k - 1);
        return atMostK - atMostKminus1;
    }

    private int atMostK(int[] nums, int k) {

        int left = 0;
        int windowSize = 0;
        int count = 0;
        int n = nums.length;
        for (int right = 0; right < n; right++) {
            windowSize += (nums[right] & 1);

            while (windowSize > k && left < n) {
                windowSize -= (nums[left++] & 1);
            }
            count += right - left + 1;
        }
        return count;
    }
}