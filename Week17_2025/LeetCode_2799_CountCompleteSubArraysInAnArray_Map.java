package Week17_2025;

import static org.junit.Assert.assertEquals;

/**
 * LeetCode Problem: 2799 Count complete Subarrays in an array. 
 * Problem Link:
 * https://leetcode.com/problems/count-complete-subarrays-in-an-array/?envType=daily-question&envId=2025-04-24
 *
 * Definition : Complete Subarray : A subarray of an array is complete 
 * if number of distinct elements in the subarray are equal to the number of distinct elements in the array.
 * 
 * Task: Count the number of complete sub-arrays for given array of positive integers. 
 * 
 * Constraints :
 *  -> 1 <= nums.length <= 1000
 *  -> 1 <= nums[i] <= 2000 
 * 
 * Observations:
 * #1. To find the distinct elements of array, set can be used. The size of the set will provide total number of distinct elements. 
 * #2. Each subarray can be considered as a section/window of one or more elements.
 *     => Sliding window protocol with dynamic window sizing can be used here. 
 *     => A subarray is complete if all the distinct elements occur atleast once. 
 *     => Once current window/subarray is complete, the window will remain complete till the last element of the array. 
 *     => Keep expanding the window until the window becomes complete. 
 *      
 * Approach:
 * 1. To find the distinct elements, traverse the array, and add all the elements to the set. 
 * 2. Size of the set gives the total number of distinct elements in the array. 
 * 3. Use map -> element vs frequencey, to check if the current window/subarray is complete. 
 *  => A subarray is complete even if there are multiple occurence of a single digit. So use map. 
 *  => If size of the map equals total number of distinct elements, then the window is complete.
 
 * 4. Again traverse the array, keep two pointers left and right. Left for shrinking the window, right for expanding. 
 *  => Add current element to the map, if already exists increase its count. 
 *  => Check if the window/subarray is complete. Size of map == size of set => map is complete. 
 *  => While map is complete, add total no. of elements (n) - right (As explain in observtion #2). 
 *     Additionaly, shrink the window using left pointer by reducing the frequency of the element pointed by left. 
 *     If frequency is reduced to 0, then remove the element. 
 *  
 *
 * Time Complexity: O(n)
 *      - Creating Set : O(n)
 *      - Sliding Window : O(n)
 *      - Map operations : O(1) asymptotically. 
 *      - Final Complexity : O(n)
 * Space Complexity: O(n)
 *      - Using set and map to store the elements and there frequency. 
 * 
 * Set-Map V/s Array 
 * -> Set-Map approach is scaleable for large values, while for low constratints array based approach is favorable,
 *    as set and map operations take an overhaul over performance.  
 * 
 * Note : For Array based implementatin refer LeetCode_2799_CountCompleteSubArraysInAnArray_Array.java
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class LeetCode_2799_CountCompleteSubArraysInAnArray_Map {

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

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int totalDistinct = set.size();
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        for (int right = 0; right < n; right++) {

            map.compute(nums[right], (key, value) -> value == null ? 1 : value + 1);
            while (map.size() == totalDistinct && left <= right) {
                count += n - right;
                map.compute(nums[left], (key, value) -> value - 1 == 0 ? null : value - 1);
                left++;
            }

        }
        return count;
    }
}
