package Week17_2025;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * LeetCode Problem: 2799 Count complete Subarrays in an array.
 * Problem Link:
 * https://leetcode.com/problems/count-complete-subarrays-in-an-array/?envType=daily-question&envId=2025-04-24
 *
 * Definition : Complete Subarray : A subarray of an array is complete
 * if number of distinct elements in the subarray are equal to the number of
 * distinct elements in the array.
 * 
 * Task: Count the number of complete sub-arrays for given array of positive
 * integers.
 * 
 * Constraints :
 * -> 1 <= nums.length <= 1000
 * -> 1 <= nums[i] <= 2000
 * 
 * Observations:
 * #1 Constraints are small and elements are positive integers.
 *  => Instead of set, boolean array can be used to find total number of distinct elements.
 *  => Instead of map, integer array can be used to store the frequency of the elements.
 * #2 To find the size of the frequency array ,
 *  either first find the maximum element of the array and assign a size of maximum + 1
 *  or as maximum element value is 2000, it can be hardcoded to 2001.
 * #3. Each subarray can be considered as a section/window of one or more elements.
 *  => Sliding window protocol with dynamic window sizing can be used here.
 *  => A subarray is complete if all the distinct elements occur atleast once.
 *  => Once current window/subarray is complete, the window will remain complete till the last element of the array.
 *  => Keep expanding window till widow becomes complete, then start srinking the window.
 * 
 * 
 *Approach:
 * 1. To find the distinct elements, traverse the array, and if element is not marked then it is distinct, 
 *    so mark it and also increment the counter for total distinct elements.
 * 2. Keep a counter currentDistinct, to keep track of distinct elements in current window. 
 * 3. Traverse array, if frequency of element is 0, then it should be count as distinct element. 
 *  => increase frequency by freq[nums[right]]++.
 *  => while current window is complete i.e total distinct elements = current distinct elements, 
 *      --> count windows/subarrays by using n - right. (As explained in observation #3).
 *      --> If the current frequency of the element pointed by 'left' is one,
 *          then decrement the distinct element count, since it will no longer be present in the next window.
 *      --> Reduce the frequency of the element pointed by left. 
 *
 * Time Complexity: O(n)
 * - Finding max : O(n)
 * - Finding total distinct elements : O(n)
 * - Sliding Window : O(n)
 * - Final Complexity : O(n)
 * Space Complexity: O(n)
 * - Using boolean array and integer array to find the distinct elements and frequency of the elements. 
 * 
 * Set-Map V/s Array 
 * -> Set-Map approach is scaleable for large values, while for low constratints array based approach is favorable,
 *    as set and map operations take an overhaul over performance.  
 * 
 * Note : For set/map based implementatin refer
 * LeetCode_2799_CountCompleteSubArraysInAnArray_Map.java
 */

public class LeetCode_2799_CountCompleteSubArraysInAnArray_Array {

    @Test
    public void test1() {
        assertEquals(4, countCompleteSubarrays(new int[] {1,3,1,2,2}));
    }

    @Test
    public void test2() {
        assertEquals(10, countCompleteSubarrays(new int[] {5,5,5,5}));
    }


    public int countCompleteSubarrays(int[] nums) {
        int n = nums.length;
        int count = 0;

        /**
         * From Constraints : max(nums) = 2000.
         * Can get rid of following loop by hardcording exists and freq array to 2001.
         */

        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        boolean[] exists = new boolean[max + 1];
        int totalDistinct = 0;
        for (int num : nums) {
            if (!exists[num]) {
                exists[num] = true;
                totalDistinct++;
            }
        }

        int[] freq = new int[max + 1];
        int currentDistinct = 0;
        int left = 0;
        for (int right = 0; right < n; right++) {

            if (freq[nums[right]]++ == 0) {
                currentDistinct++;
            }

            while (currentDistinct == totalDistinct && left <= right) {
                count += n - right;
                if (freq[nums[left]]-- == 1) {
                    currentDistinct--;
                }
                left++;
            }
        }
        return count;
    }
}
