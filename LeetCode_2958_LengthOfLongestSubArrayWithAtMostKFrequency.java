import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class LeetCode_2958_LengthOfLongestSubArrayWithAtMostKFrequency {

    @Test
    public void test1() {
        assertEquals(6, maxSubarrayLength(new int[] { 1, 2, 3, 1, 2, 3, 1, 2 }, 2));
    }

    @Test
    public void test2() {
        assertEquals(2, maxSubarrayLength(new int[] { 1, 2, 1, 2, 1, 2, 1, 2 }, 1));
    }

    @Test
    public void test3() {
        assertEquals(4, maxSubarrayLength(new int[] { 5, 5, 5, 5, 5, 5, 5 }, 4));
    }

    @Test
    public void test4() {
        assertEquals(2, maxSubarrayLength(new int[] { 1, 4, 4, 3 }, 1));
    }

    @Test
    public void test5() {
        assertEquals(3, maxSubarrayLength(new int[] { 2, 1, 2, 3 }, 1));
    }

    public int maxSubarrayLength(int[] nums, int k) {

        int maxLength = 0;

        Map<Integer, Integer> map = new HashMap<>();

        int left = 0, right = 0;

        while (right < nums.length) {

            int count = map.getOrDefault(nums[right], 0);
            count++;
            map.put(nums[right], count);

            while (count > k) {
                map.put(nums[left], map.get(nums[left]) - 1);
                left++;
                count = map.get(nums[right]);
            }
            maxLength = Math.max(maxLength, right - left + 1);

            right++;
        }

        return maxLength;
    }
}
