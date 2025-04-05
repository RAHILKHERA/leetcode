import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MaximumValueofOrderedTriplet1 {

    @Test
    public void test1() {
        assertEquals(133, maximumTripletValue(new int[] { 1, 10, 3, 4, 19 }));
    }

    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        int[] nextMinimum = new int[n];
        int[] nextMaximum = new int[n];
        nextMinimum[n - 2] = n - 1;
        nextMaximum[n - 2] = n - 1;
        long maxValue = 0;
        for (int idx = n - 3; idx >= 0; idx--) {

            long a = nums[idx];

            if (nums[nextMinimum[idx + 1]] > nums[idx + 1]) {
                nextMinimum[idx] = idx + 1;
            } else {
                nextMinimum[idx] = nextMinimum[idx + 1];
            }

            if (nums[nextMaximum[idx + 1]] < nums[idx + 1]) {
                nextMaximum[idx] = idx + 1;
            } else {
                nextMaximum[idx] = nextMaximum[idx + 1];
            }

            int x = nextMinimum[idx];
            int y = nextMaximum[x];
            long b = nums[x];
            long c = nums[y];
            maxValue = Math.max(maxValue, (a - b) * c);
        }
        return maxValue;
    }
}
