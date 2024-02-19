import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class LeetCode_2149_RearrangeArrayElementsBySign {

    @Test
    public void test1() {
        assertArrayEquals(new int[] { 3, -2, 1, -5, 2, -4 }, rearrangeArray(new int[] { 3, 1, -2, -5, 2, -4 }));
    }

    @Test
    public void test2() {
        assertArrayEquals(new int[] { 1, -1 }, rearrangeArray(new int[] { -1, 1 }));
    }

    public int[] rearrangeArray(int[] nums) {

        int n = nums.length;
        int[] result = new int[n];
        int positiveIndex = 0, negativeIndex = 1;

        for (int num : nums) {
            if (num < 0) {
                result[negativeIndex] = num;
                negativeIndex += 2;
            } else {
                result[positiveIndex] = num;
                positiveIndex += 2;
            }
        }

        return result;
    }
}