package Week18_2025;

/**
 * LeetCode Problem: 3392 Count subarrays of length three with a conditon.
 * Problem Link:
 * https://leetcode.com/problems/count-subarrays-of-length-three-with-a-condition/description/?envType=daily-question&envId=2025-04-27
 *
 * Input : Integer array nums. 
 * 
 * Constraints:
 * 3 <= nums.length <= 100
 * -100 <= nums[i] <= 100
 * 
 * Task:
 * Count number of subarrays of length 3 such that summation of first and third number is equal to half of the second number. 
 *
 * Observations:
 * #1. Length of the subarray is fixed => Sliding window protocol with fixed window can be used. 
 * #2. If current element index is idx, then idx - 1 and idx - 2 will form the potential subarray. 
 * #3. Condition to satisfy :  nums[idx - 2] + nums[idx] = nums[idx - 1]/2.
 *      => 2 * (nums[idx - 2] + nums[idx])  = nums[idx - 1]. (Multiplying by 2 on both sides, to avoid floating point operations).
 *
 * Approach:
 * 1. Traverse the array, start from 2 as previous two elements are required. 
 * 2. For each index idx check the condition, 2 * (nums[idx - 2] + nums[idx]) == nums[idx - 1]. 
 *    If satisfied,increase the count. 
 *
 * Time Complexity: O(n) 
 *     - n = length of the array. 
 *     - Traversing the given array only once. 
 *
 * Space Complexity: O(1)
 *      - No extra space proportional to input is used. 
 */

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LeetCode_3392_CountSubarraysOfLengthThreeWithACondition {

    @Test
    public void test1() {
        assertEquals(1, countSubarrays(new int[] { 1, 2, 1, 4, 1 }));
    }

    @Test
    public void test2() {
        assertEquals(0, countSubarrays(new int[] { 1, 1, 1 }));
    }

    @Test
    public void test3() {
        assertEquals(1, countSubarrays(new int[] { 0, 0, 0 }));
    }

    @Test
    public void test4() {
        assertEquals(0, countSubarrays(new int[] { -5, -10, -5 }));
    }

    public int countSubarrays(int[] nums) {
        int count = 0;
        for (int idx = 2; idx < nums.length; idx++) {
            int doubleSumOfFirstAndThird = 2 * (nums[idx - 2] + nums[idx]);
            if (doubleSumOfFirstAndThird == nums[idx - 1]) {
                count++;
            }
        }
        return count;
    }
}
