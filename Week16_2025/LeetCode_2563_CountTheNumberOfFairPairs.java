package Week16_2025;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

/**
 * LeetCode Problem: 2563 Count The Number Of Fair Pairs.
 * Problem Link:
 * https://leetcode.com/problems/count-the-number-of-fair-pairs/submissions/1451938742/?envType=daily-question&envId=2025-04-19
 * 
 * 
 * Defination :
 * Fair Pair : (i,j) is fair if
 * #1 0 <= i < j < n
 * #2 lower <= nums[i] + nums[j] <= upper.
 * 
 * Task : Count number of fair pairs.
 * 
 * Observation :
 * #1 lower <= nums[i] + nums[j] <= upper
 * ==> lower - nums[i] <= nums[j] <= upper - nums[i]
 * --------------------------|##################################|
 * lower-nums[i] upper-nums[i]
 * #2 From above number line representation, it is clear if number of elements
 * less than upper - nums[i] + 1 = x and number of elements less than lower -
 * nums[i] = y. Then x - y is the count of fair paris for ith element.
 * #3 Both x and y can be searched using binary search (lower_bound).
 * #4 As nums[i] + nums[j] = nums[j] + nums[i], The array can be sorted and
 * binary search can performed.
 * 
 * 
 * Approach:
 * 1) Sort the array.
 * 2) For each element find y by finding lower_bound with target = lower -
 * nums[idx].
 * 3) For each element find x by finding lower_bound with target = upper -
 * nums[idx] + 1. +1 ensures that we include pairs where sum == upper, since
 * lower_bound returns the index of the first element >= target.
 * 4) sum the count of fair pairs (x - y) at each index.
 * 
 * To count number of elements less than target', use binary search.
 * 1) If nums[mid] < target, at least till mid all the elements are less than
 * target, so move left to mid + 1, else move right to mid - 1.
 * 2) After last iteration, left will be pointing to the number of elements less
 * than target.
 *
 * Time Complexity: O(nlogn). Sorting takes O(nlogn) and then executing binary
 * search (O(logn))for each of the n elements.
 * Hence O(nlogn + nlogn) => O(nlogn).
 * 
 * Space Complexity : O(n) => Sorting takes O(n) space.
 */

public class LeetCode_2563_CountTheNumberOfFairPairs {

    @Test
    public void test1() {

        assertEquals(6, countFairPairs(new int[] { 0, 1, 7, 4, 4, 5 }, 3, 6));
    }

    @Test
    public void test2() {

        assertEquals(1, countFairPairs(new int[] { 1, 7, 9, 2, 5 }, 11, 11));
    }

    private int lowerBound(int[] nums, int left, int right, int element) {

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < element) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public long countFairPairs(int[] nums, int lower, int upper) {
        int n = nums.length;
        long count = 0;
        Arrays.sort(nums);
        for (int idx = 0; idx < n; idx++) {

            int lowerLimitElements = lowerBound(nums, idx + 1, n - 1, lower - nums[idx]);
            int upperLimitElements = lowerBound(nums, idx + 1, n - 1, upper - nums[idx] + 1);
            count += (long) (upperLimitElements - lowerLimitElements);

        }
        return count;
    }
}
