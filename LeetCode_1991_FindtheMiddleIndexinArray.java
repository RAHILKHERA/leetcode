import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LeetCode_1991_FindtheMiddleIndexinArray {

    @Test
    public void test1() {
        assertEquals(3, findMiddleIndex(new int[] { 2, 3, -1, 8, 4 }));
    }

    @Test
    public void test2() {
        assertEquals(-1, findMiddleIndex(new int[] { 2, 5 }));
    }

    public int findMiddleIndex(int[] nums) {
        int n = nums.length;

        int[] prefixSum = new int[n];
        int[] suffixSum = new int[n];

        prefixSum[0] = nums[0];
        suffixSum[n - 1] = nums[n - 1];

        for (int i = 1; i < n; i++) {
            prefixSum[i] = nums[i] + prefixSum[i - 1];
        }

        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] = nums[i] + suffixSum[i + 1];
        }

        for (int i = 0; i < n; i++) {
            if (prefixSum[i] == suffixSum[i]) {
                return i;
            }
        }

        return -1;
    }
}
