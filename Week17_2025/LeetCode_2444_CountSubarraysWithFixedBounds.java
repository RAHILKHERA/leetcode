package Week17_2025;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * LeetCode Problem: 2444 Count subarrays with fixed bounds.
 * Problem Link:
 * https://leetcode.com/problems/count-subarrays-with-fixed-bounds/description/?envType=daily-question&envId=2025-04-26
 *
 * Input :
 * - integer array nums
 * - integer minK
 * - integer maxK
 * 
 * Constraints:
 * 2 <= nums.length <= 10^5
 * 1 <= nums[i], minK, maxK <= 10^6
 * 
 * Definition: Fixed bound subarray, is a subarray whose minimum value is minK
 * and maximum value is maxK.
 * 
 * Task: Count number of fixed bound subarrays.
 * 
 * Observations:
 * #1. A subarray is valid till the minimum value of it is equal to minK and
 * maximum value is maxK.
 * #2. The challenge here is to process the elements out of range (outbound) i.e
 * x < minK and x > maxK.
 * #3. Traversing from left to right, keep track of the minK and maxK positions.
 * => Once both minK and maxK are found at position minPosition and maxPosition respectively, the subarray can be extended in both the directions.
 * => Extending in left direction, here minimum of the positions should be selected as the farther the value covers the more number of subarrays. => min(minPosition, maxPosition).
 * => In other words, starting of the subarray where one of the minK or maxK was found.
 * => Extending in right direction, If outbound element is not found, then it can be extended till last element else it will be stopped at outbound - 1 positon.
 * => Case 1 : outboundPosition < Minimum(minPoisiton, maxPosition) => count = Minimum(minPosition, maxPosition) - outboundPoistion.
 * => Case 2 : outboundPosition comes in between or after both (minPosiiton, maxPosition) => Minimum(minPosition, maxPosition) < outboundPoistion => count < 0. But count cannot be negative hence count = 0.
 * 
 * Approach:
 * 1. Four pointers are required :
 * - minPosition : position of minK element. Initialize with -1, to represent minK not found.
 * - maxPosition : position of maxK element. Initialize with -1, to represent maxK not found. 
 * - outbound : position of outbound element. Initialize with -1, to represent outbound not found.
 * - idx : current element. 
 * => Reason for initializing by -1 : The nums array is positive integers only. In case minK or maxK is not found minimum of both will be -1. Subtracting outbound from it will create a smaller negative number. 
 *    Calculate max of it and 0 will always result in 0. Number of subarrays between x,y is y - x + 1. So if all the elements of the array are in the range. Then outbound = -1 will cover that +1 element. 
 * 2. Traverse the array. 
 *  => If element is out of bound, update outbound pointer. 
 *  => If element == minK, update minPosition pointer.
 *  => If element == maxK, update maxPosition pointer. 
 *  => count = max(0, min(minPosition, maxPosition) - outbound) [max used to tackle negative counts.]
 *  
 *
 * Time Complexity: O(n)
 * - Traversing the array: O(n)
 * - Final Complexity: O(n)
 * Space Complexity: O(1)
 * - No extra space propotional to n is used.
 * n = length of the array.
 */
public class LeetCode_2444_CountSubarraysWithFixedBounds {

    @Test
    public void test1() {
        assertEquals(2, countSubarrays(new int[] { 1, 3, 5, 2, 7, 5 }, 1, 5));
    }

    @Test
    public void test2() {
        assertEquals(10, countSubarrays(new int[] { 1, 1, 1, 1 }, 1, 1));
    }

    public long countSubarrays(int[] nums, int minK, int maxK) {
        int minPosition = -1;
        int maxPosition = -1;
        int outBound = -1;
        long result = 0;
        for (int idx = 0; idx < nums.length; idx++) {
            if (nums[idx] > maxK || nums[idx] < minK) {
                outBound = idx;
            }

            if (nums[idx] == minK) {
                minPosition = idx;
            }

            if (nums[idx] == maxK) {
                maxPosition = idx;
            }

            result += (long) (Math.max(0, Math.min(minPosition, maxPosition) - outBound));
        }
        return result;
    }
}
