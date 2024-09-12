import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LeetCode_2441_LargestPositiveIntegerThatExistsWithItsNegative {

    @Test
    public void test1() {
        assertEquals(7, findMaxK(new int[] { -1, 10, 6, 7, -7, 1 }));
    }

    @Test
    public void test2() {
        assertEquals(-1, findMaxK(new int[] { 12, -18, 14, 36, -45, -34, -19, -37, -9, -5 }));
    }

    public int findMaxK(int[] nums) {
        int maxK = -1;
        boolean[] mapPositive = new boolean[1001];
        boolean[] mapNegative = new boolean[1001];

        for (int i : nums) {

            // If current number is negative
            if (i < 0) {
                // If k exists, check for maxK
                if (mapPositive[-i]) {
                    maxK = Math.max(maxK, -i);
                }
                mapNegative[-1 * i] = true;

            } else {
                // If number is positive, check if -k exists
                if (mapNegative[i]) {
                    maxK = Math.max(maxK, i);
                }
                mapPositive[i] = true;
            }
        }

        return maxK;
    }
}
