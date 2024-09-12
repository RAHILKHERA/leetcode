import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class LeetCode_75_SortColors {

    @Test
    public void test1() {
        int[] nums = new int[] { 2, 0, 2, 1, 1, 0 };
        int[] expected = new int[] { 0, 0, 1, 1, 2, 2 };
        sortColors(nums);
        assertArrayEquals(expected, nums);
    }

    @Test
    public void test2() {
        int[] nums = new int[] { 2, 0, 1 };
        int[] expected = new int[] { 0, 1, 2 };
        sortColors(nums);
        assertArrayEquals(expected, nums);
    }

    @Test
    public void test3() {
        int[] nums = new int[] { 2, 0, 0 };
        int[] expected = new int[] { 0, 0, 2 };
        sortColors(nums);
        assertArrayEquals(expected, nums);
    }

    public void sortColors(int[] nums) {

        /**
         * Left pointer -> the pointer to place 0.
         * Right pointer -> the pointer to place 2
         */
        int n = nums.length;

        int left = 0, right = n - 1;
        int i = 0;

        while (left < n && nums[left] == 0) {
            left++;
            i++;
        }

        if (left == n || i > right) {
            return;
        }

        while (right >= 0 && nums[right] == 2) {
            right--;
        }

        if (right < 0) {
            return;
        }

        while (i <= right) {

            while (left < n && nums[left] == 0) {
                left++;
                i++;
            }

            if (i > right) {
                break;
            }

            if (nums[i] == 2) {
                nums[i] = nums[right];
                nums[right] = 2;
            }

            if (nums[i] == 0) {
                nums[i] = nums[left];
                nums[left] = 0;
                left++;
            }

            i++;
            while (right >= 0 && nums[right] == 2) {
                right--;
            }

        }
    }
}
