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
 * #1 With every index `idx` two numbers need to be deal, the current value and the new value obtained using that value and the relationship. 
 *  => result[idx] = nums[nums[idx]].
 *  => old number/present number = nums[idx].
 *  => new number = nums[nums[idx]]
 * #2. Think of the way that from a single number both old number and new number can be calculated. 
 * #3. All the numbers are distinct and varies from [0, n-1]. 
 *     => There will be one to one relation between old number, new number and the encoded one. 
 * #4. One way to encode is oldNumber * n + newNumber = encoding 
 *      => oldNumber = encoding / n.
 *      => newNumber = encoding % n. 
 * #5. Now as this is in place approach, the input array is getting modified
 *     => For given index idx, To identify that nums[nums[idx]] is encoding or original value, newValue should be greater than equal to n. 
 *     => It is already given that the original values are in range [0, n-1].
 *     => If newValue >= n, newValue = newValue/n. This remove the remainder from the encoding and get the original value from nums. 
 *     => The above encoding approach, will always produce encoding greater than equal to n except for 0. 
 *     => In case of 0, It will fail as the encoding will be reduce to newNumber only, and the decoding is applied only when newNumber > n-1.
 *     => To handle this, if oldNumber is 0, assign it n before calculating encoding. 
 *     => This won't affect final result, as the new number is calcuated using modulo operation with n.
 *     => But assigning n to oldNumber in case of 0, can create issue in future computations. 
 *     => As now there is a newNumber = n, which is not allowed. So here reverse check will be done if newNumber >=  n and newNumber/n = n,
 *     => Then newNumber = 0. 
 * 
 * #6. Once all the numbers are encode, retraverse it, and the final array can be build by performing modulo operation over each element. 
 * 
 *   
 * Approach:
 * 1. Traverse the array and calculate the encoding for each index (idx). 
 * 2. If newNumber that is nums[nums[idx]] > n - 1
 *     => This is an ecoding of previous number. 
 *     => Fetch oldnumber from it. Encoding/n
 *     => If oldNumber produced is = n, means it was 0 and was assigne n, to mark it as an encoding. Hence newNumber = 0. 
 *     => If current/present number = 0, assign n, to keep encoding >=n. 
 *     => Calculate the encoding : encoding = oldNumber * n + newNumber. 
 * 3. At this stage, all the elements are replaced by their encodings, 
 *     => Remember encoding was of form oldNumber * n + newNumber. 
 *     => newNumber = encoding % n. 
 *     => generate new Number for each encoding and assign itself. 
 * 4. Return the input array. 
 * 
 * Time Complexity: O(n) 
 *      - Travrerse the array and generate the encoding -> O(n)
 *      - Traverse the array and decode it -> O(n)
 *      - Final Complexity -> O(2 * n) => O(n)
 *      
 * Space Complexity: O(1)
 *      - No extra space is used which is propotional to input size. 
 * 
 * Note : In this approach, two passes were used to build the array, one for the encoding and another for decoding. 
 * Hence this is slower compare to the direct extra space approach. But here no extra space propotional to input size is used. 
 * This approach is only possible in case the input array can be modified. If this relaxation is not provided. This approach is not possible. 
 *  
 * Other Approaches : 
 * LeetCode_1920_BuildArrayFromPermutation_ApproachDirectExtraSpace.java
 * 
 */

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class LeetCode_1920_BuildArrayFromPermutation_ApproachInPlace {

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
        for (int idx = 0; idx < n; idx++) {
            int oldNum = nums[idx];
            int newNum = nums[nums[idx]];

            if (newNum > n - 1) {
                newNum = newNum/n;
                if (newNum == n) {
                    newNum = 0;
                }
            }

            if (oldNum == 0) {
                oldNum = n;
            }
            nums[idx] = oldNum * n + newNum;
        }

        for (int idx=0; idx < n; idx++) {
            nums[idx] %= n;
        }

        return nums;
    }
}
