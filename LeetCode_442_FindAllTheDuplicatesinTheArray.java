import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class LeetCode_442_FindAllTheDuplicatesinTheArray {

    @Test
    public void test1() {

        List<Integer> expected = new ArrayList<>();
        expected.add(2);
        expected.add(3);
        assertEquals(expected, findDuplicates(new int[] { 4, 3, 2, 7, 8, 2, 3, 1 }));

    }

    public List<Integer> findDuplicates(int[] nums) {

        /**
         * Constraints : array contents ranges from 1 to n where n is size of the array.
         * Each number appears once or twice.
         * It should be done in linear time complexity and constanst space complexity.
         * 
         * Tip : As the content of array ranges from 1 to n. It can be used as index of
         * the array.
         * 
         * Intitution : As the duplicate number appears at most twice, we can have a
         * switching arrangment, in which we will negate the number (multiply by -1)
         * present on current
         * index -1 (as array range is from 0 to n-1). So if the same number is
         * encountered again, then the number at that index -1 will be negative.
         * 
         * Caution : Make sure to take the absolute of the current number as it could be
         * a negative due to previous number.
         *
         */

        List<Integer> result = new ArrayList<>();

        if (nums.length == 1) {
            return result;
        }

        for (int i = 0; i < nums.length; i++) {
            int idx = Math.abs(nums[i]);
            // int idx = nums[i] < 0 ? -1 * nums[i] : nums[i];
            if (nums[idx - 1] < 0) {
                result.add(idx);
            }
            nums[idx - 1] *= -1;
        }

        return result;
    }
}
