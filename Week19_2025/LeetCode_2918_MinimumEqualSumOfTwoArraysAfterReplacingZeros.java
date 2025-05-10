package Week19_2025;

/**
 * @RAHILKHERA
 * 
 * LeetCode Problem: 2918 Minimum equal sum of two arrays after replacing zeros.  
 * Problem Link: https://leetcode.com/problems/minimum-equal-sum-of-two-arrays-after-replacing-zeros/description/?envType=daily-question&envId=2025-05-10
 * 
 * Input : 
 *  - Integer 1D array nums1 with positive integers. 
 *  - Integer 1D array nums2 with positive integer. 
 * 
 * Definition : Equal Sum, after replacing each of the 0's in both the array with strictly positive integers, 
 *              such that sum of all the elements of both arrays are equal. 
 * 
 * Constraints:
 * 1 <= nums1.length, nums2.length <= 10^5
 * 0 <= nums1[i], nums2[i] <= 10^6
 * 
 * Task: Find minimum equal sum if possible else return -1. 
 *
 * Observations:
 * #1. 0's need to be replaced by a strictly positive integer and the sum should be minimum. 
 *     => Moving greedily, the lowest positive integer is 1. So replacing 0's by 1.
 *     => All zeros should be replaced. There is no option.
 *     => So the minimum sum of an array would be summation of all the non- zero elements and number of zeros. 
 * #2. Arrays are of positive numbers and zeros need to be replaced by the positive numbers.
 *     => Summation of the elements of the array before replacement cannot be reduced. 
 *     => As replacement, will only increase the summation. 
 * #3. As summation can only increase,
 *     => Assume summation of nums1 = x and Assume summation of nums2 = y. 
 *     => If x < y, try to increase x to  be y. If y < x, try to increase y to be x. 
 * #4. Increasing is only possible if the array with lower summation has atleast one zero else it is not possible.  
 * #5. Proof of concept : If atleast one zero is available then it can be replaced by larger sum - smaller sum and both the array's element summation will be equal.
 *  
 * Approach:
 * 1. Need 4 variables, 
 *    => one variable for each array for maintaining summation while replacing 0's by one.
 *    => one variable for each array for keep count of number of zeros. 
 * 2. After replacement of zeros by 1.
 *    => Summation of elements in nums1 = minSum1, count of zeros in nums1 = zeros1.
 *    => Summation of elements in nums2 = minSum2, count of zeros in nums2 = zeros2.   
 *    => If minSum1 < minSum2 and zeros1 == 0 return -1. As minSum1 cannot be increased to minSum2. 
 *    => If y < x and zeros2 == 0 return -1. As minSum2 cannot be increased to minSum1.
 *    => minimum equal answer = max(minSum1, minSum2).  
 * 
 * Time Complexity: O(N + M)
 *      - N = number of elements in nums1
 *      - M = number of elements in nums2
 *      - One traversal for each array. 
 *      - Final Complexity : O(N + M).
 *      
 * Space Complexity: O(1)
 *      - Except four integer variables no extra space which grows with input size is used. 
 */

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LeetCode_2918_MinimumEqualSumOfTwoArraysAfterReplacingZeros {

    @Test
    public void test1() {
        assertEquals(12, minSum(new int[] { 3, 2, 0, 1, 0 }, new int[] { 6, 5, 0 }));
    }

    @Test
    public void test2() {
        assertEquals(-1, minSum(new int[] { 2, 0, 2, 0 }, new int[] { 1, 4 }));
    }

    @Test
    public void test3() {
        assertEquals(1, minSum(new int[] { 0 }, new int[] { 0 }));
    }

    @Test
    public void test4() {
        assertEquals(6, minSum(new int[] { 1, 2, 3 }, new int[] { 1, 2, 3 }));
    }

    @Test
    public void test5() {
        assertEquals(-1, minSum(new int[] { 10, 20 }, new int[] { 1, 2, 3 }));
    }

    public long minSum(int[] nums1, int[] nums2) {
        long minSum1 = 0;
        int zeros1 = 0;
        long minSum2 = 0;
        int zeros2 = 0;

        for (int num : nums1) {
            minSum1 += Math.max(num, 1);
            if (num == 0)
                zeros1++;
        }

        for (int num : nums2) {
            minSum2 += Math.max(num, 1);
            if (num == 0)
                zeros2++;
        }

        if (minSum1 > minSum2 && zeros2 == 0) {
            return -1;
        }

        if (minSum2 > minSum1 && zeros1 == 0) {
            return -1;
        }

        return Math.max(minSum1, minSum2);
    }
}
