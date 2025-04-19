package Week16_2025;

/**
 * LeetCode Problem: 2824 Count Pairs whose sum is less than target.
 * Problem Link:
 * https://leetcode.com/problems/count-pairs-whose-sum-is-less-than-target/
 *  
 * Task : Count pairs (i,j) such that nums[i] + nums[j] < target and 0 <= i < j < n.
 * 
 * Observation :
 * #1 nums[i] + nums[j] < target => nums[j] < target - nums[i] => nums[j] < target'
 * #2 The problem is reduced to finding count of all the numbers smaller than target'. Hence, sorted array will be useful. 
 * #3 If array is sorted, binary search can be used to get count of all the elements smaller than target - currentElement. 
 * #4 To satisfy the condition i < j, subtract current number of elements. 
 * 
 * Approach: 
 * 1) Sort the array. 
 * 2) For each element find count of number of elements less than target - element. (target')
 * 3) Subtract  total elements till now i.e. i + 1 from count. 
 * 
 * To count number of elements less than target', use binary search. 
 * 1) If nums[mid] < target', at least till mid all the elements are less than target, so move left to mid + 1, else move right to mid - 1. 
 * 2) After last iteration, left will be pointing to the number of elements less than target.
 * 
 *
 * Time Complexity: O(nlogn). Sorting takes O(nlogn) and then executing binary search (O(logn))for each of the n elements. 
 * Hence O(nlogn + nlogn) => O(nlogn).
 * 
 * Space Complexity : O(n) => Sorting takes O(n) space. 
 */

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class LeetCode_2824_CountPairsWhoseSumIsLessThanTarget {

    @Test
    public void test1() {
        List<Integer> list = Arrays.asList(-1, 1, 2, 3, 1);
        assertEquals(3, countPairs(list, 2));
    }

    @Test
    public void test2() {
        List<Integer> list = Arrays.asList(-6, 2, 5, -2, -7, -1, 3);
        assertEquals(10, countPairs(list, -2));
    }

    @Test
    public void testEdgeCases() {
        List<Integer> emptyList = Arrays.asList();
        assertEquals(0, countPairs(emptyList, 5));

        List<Integer> singleElementList = Arrays.asList(1);
        assertEquals(0, countPairs(singleElementList, 2));
    }

    private int lowerBound(List<Integer> nums, int low, int high, int target) {

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public int countPairs(List<Integer> nums, int target) {
        int n = nums.size();
        Collections.sort(nums);
        int count = 0;

        for (int i = 0; i < n; i++) {
            count += lowerBound(nums, i + 1, n - 1, target - nums.get(i)) - i - 1;
        }
        return count;
    }
}