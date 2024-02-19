import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class LeetCode_2971_FindPlygonWiththeLongestPerimeter {

    @Test
    public void test1() {

        assertEquals(15, largestPerimeter(new int[] { 5, 5, 5 }));

    }

    @Test
    public void test2() {

        assertEquals(12, largestPerimeter(new int[] { 1, 12, 1, 2, 5, 50, 3 }));

    }

    @Test
    public void test3() {

        assertEquals(-1, largestPerimeter(new int[] { 5, 5, 50 }));

    }

    public long largestPerimeter(int[] nums) {

        Arrays.sort(nums);

        long max = -1;
        long total = 0;
        for (int i = 0; i < nums.length; i++) {
            if (total > nums[i]) {
                max = total + nums[i];
            }
            total += nums[i];
        }

        return max;
    }
}
