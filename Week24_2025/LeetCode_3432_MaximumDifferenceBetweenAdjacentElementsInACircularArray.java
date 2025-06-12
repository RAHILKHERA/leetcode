package Week24_2025;

/**
 * @RAHILKHERA
 *
 * LeetCode Problem: 3432 Maximum difference between adjacent elements in a circular array.
 * 
 * Problem Link: https://leetcode.com/problems/maximum-difference-between-adjacent-elements-in-a-circular-array/description/?envType=daily-question&envId=2025-06-12
 * 
 * Input:
 * - Integer array nums of length n. 
 * 
 * Constraints:
 * 2 <= nums.length <= 100
 * -100 <= nums[i] <= 100
 * 
 * Definition : In a circular array, the first and last elements are adjacent.
 *            
 * Task: Given a circular array nums, find the maximum absolute difference between adjacent elements.
 * 
 * Approach:
 * 1. Use a variable `maxDiff` to track the maximum absolute difference between adjacent elements.
 *    => Initialize it with |nums[0] - nums[n-1]|, as this is a circular array, so the first and last elements are adjacent.
 * 2. For each index `idx`, calculate |nums[idx] - nums[idx + 1]| and update `maxDiff`.
 * 3. Return maxDiff.    
 * 
 * Time Complexity: O(n)
 * |                       Component                            |                Time               |
 * | ---------------------------------------------------------- |---------------------------------- |
 * | Traverse all the integers                                  |   O(n)                            |
 * |------------------------------------------------------------|-----------------------------------|
 * |                  Total Complexity                          |   O(n)                            |
 * 
 * 
 * Space Complexity: O(1)
 * |                        Component                           |                  Space            |
 * | ---------------------------------------------------------- |---------------------------------- |
 * |   No extra space proportional to input size is used.        |        O(1)                       |
 * |----------------------------------------------------------- |-----------------------------------|
 * | Total Complexity                                           |        O(1)                       |
 *
 */

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LeetCode_3432_MaximumDifferenceBetweenAdjacentElementsInACircularArray {
    
    @Test
    public void test1() {
        assertEquals(3, maxAdjacentDistance(new int[] { 1, 2, 4 }));
    }
    
     @Test
    public void test2() {
        assertEquals(5, maxAdjacentDistance(new int[] {-5,-10,-5}));
    }

    public int maxAdjacentDistance(int[] nums) {
        int n = nums.length;
        int maxDiff = Math.abs(nums[0] - nums[n - 1]);
        for (int pos = 0; pos < n - 1; pos++) {
            maxDiff = Math.max(maxDiff, Math.abs(nums[pos] - nums[pos + 1]));
        }
        return maxDiff;
    }
}
