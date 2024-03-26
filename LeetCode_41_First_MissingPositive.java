import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LeetCode_41_First_MissingPositive {

    @Test
    public void test1() {

        assertEquals(2, firstMissingPositive(new int[] { 3, 4, -1, 1 }));

    }

    @Test
    public void test2() {

        assertEquals(2, firstMissingPositive(new int[] { 1 }));

    }

    public int firstMissingPositive(int[] nums) {

        // Step 1: Remove all the negative numbers.
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                nums[i] = 0;
            }
        }

        // Step 2: switch all the index numbers to negative numbers
        for (int i = 0; i < nums.length; i++) {

            int idx = Math.abs(nums[i]);
            if (1 <= idx && idx <= nums.length) {

                if (nums[idx - 1] >= 0) {
                    nums[idx - 1] = nums[idx - 1] == 0 ? Integer.MIN_VALUE : -1 * nums[idx - 1];
                }
            }
        }

        // Step 3 Find the first non - negative number, return index + 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > -1) {
                return i + 1;
            }
        }

        return nums.length + 1;
    }
}
