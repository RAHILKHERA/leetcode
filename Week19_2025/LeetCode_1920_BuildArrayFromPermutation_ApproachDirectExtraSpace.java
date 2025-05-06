package Week19_2025;

/**
 * @RAHILKHERA
 * 
 * LeetCode Problem: 1920 Build array from permutation.
 * Problem Link: https://leetcode.com/problems/build-array-from-permutation/description/?envType=daily-question&envId=2025-05-06
 *
 * Input : 
 *  - Integer array nums of length n. 
 *
 * 
 * Definition :
 *  - For index idx, result[idx] = nums[nums[idx]]. 
 *  - Zero based permutation array : An array of distinct integers in range [0, n-1] 
 *    
 * Constraints:
 * 1 <= nums.length <= 1000
 * 0 <= nums[i] < nums.length
 * The elements in nums are distinct.
 * 
 * Task:
 * -> Build the array of size n from the input array using the provided relation. 
 *
 * Observations:
 * #1 Simply do as it is asked. 
 *  
 * Approach:
 * 1. Create a resultant array of size n. 
 * 2. Traverse input array and for each index idx, generate result on the basis of relation provided.
 *     result[idx] = nums[nums[idx]].
 * 
 * Time Complexity: O(n) 
 *      - Travrerse the array and generate the resultant array. 
 *      
 * Space Complexity: O(n)
 *      - If resultant array space is considered - O(n)
 *      - In most cases, resultant array is not considered as extra space - O(1)
 * 
 * 
 * Note : In this approach, separate array is used to store the build array. Following follow up question is mentioned :
 * Can you solve it without using an extra space (i.e., O(1) memory)? That approach is mentioned in other approaches. 
 * This is the fastest solution. 
 * 
 * Other Approaches : 
 * LeetCode_1920_BuildArrayFromPermutation_ApproachInPlace.java
 * 
 */

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class LeetCode_1920_BuildArrayFromPermutation_ApproachDirectExtraSpace {

    @Test
    public void test1() {
        assertArrayEquals(new int [] {0,1,2,4,5,3}, buildArray(new int[] {0,2,1,5,3,4}));
    }

    @Test
    public void test2() {
        assertArrayEquals(new int [] {4,5,0,1,2,3}, buildArray(new int[] {5,0,1,2,3,4}));
    }


    public int[] buildArray(int[] nums) {
        int n = nums.length;
        int [] result = new int [n];
        for(int idx =0; idx < n; idx++) {
            result[idx] = nums[nums[idx]];
        }
        return result; 
    }
}
