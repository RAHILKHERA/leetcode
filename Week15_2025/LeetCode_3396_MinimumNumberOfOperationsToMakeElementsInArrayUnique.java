package Week15_2025;

/**
     * LeetCode Problem: 3396 Minimum Number Of Operations To Make Elements In Array Unique
     * Problem Link:
     * https://leetcode.com/problems/minimum-number-of-operations-to-make-elements-in-array-distinct/?envType=daily-question&envId=2025-04-08
     * 
     * Task: Minimum number of operations to make the array unique, in each operation first 3 elements of the array can be removed.
     * 
     * Observation :
     * #1 Frequency of each element must be 1 or 0 in final array. 
     * #2 To maintain frequency, use map  num vs frequency. 
     * #3 If all elements is unique, map size will be equal to length of array. As all the elements appeared once. 
     * 
     * Approach:
     * #1 Create a element vs frequency map for the given input. 
     * #2 If the size of array equal to size of map, the array is already of unique elements  return 0. 
     * #3 Use fixed sliding window protocol, to remove elements from the map. 
     *  a) if frequency is 0, remove that element. Else update the freq. 
     *  b) Keep a counter of remaining elements, after every operation if remaining elements is equal to size of map. 
     *     The remaining array is unique array.   
     * 
     * Note : In question it is mentioned 3 elements of the array to be removed. 
     * Although the problem restricts operations to removing 3 elements, the implementation supports variable window sizes.
     * 
     * 
     * Time Complexity: O(n) => All the elements are visited twice, first while preparing map, second while performing oprations. 
     * Space Complexity: O(n) => Used map to save the frequency of each element.  
     * where n = input length
     */

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class LeetCode_3396_MinimumNumberOfOperationsToMakeElementsInArrayUnique {

    @Test
    public void test1() {
        assertEquals(2, minimumOperations(new int[] { 1, 2, 3, 4, 2, 3, 3, 5, 7 }));
    }

    public int minimumOperations(int[] nums) {
        return minimumOperations(nums, 3);
    }

    private int minimumOperations(int[] nums, int windowSize) {
        int n = nums.length;
        int operations = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.compute(num, (key, value) -> value == null ? 1 : value + 1);
        }

        if (n == map.size()) {
            return operations;
        }

        int idx = 0;
        int remainingElements = n;
        while (idx < n) {
            int windowPtr = 0;
            operations++;
            while ((idx + windowPtr) < n && windowPtr < windowSize) {
                map.compute(nums[idx + windowPtr], (key, value) -> value == 1 ? null : value - 1);
                windowPtr++;
            }
            idx += windowSize;
            remainingElements -= windowSize;
            if (remainingElements == map.size()) {
                break;
            }
        }

        return operations;
    }
}
