package Week20_2025;

/**
 * @RAHILKHERA
 * 
 * LeetCode Problem: 75 Sort Color
 * Problem Link: https://leetcode.com/problems/sort-colors/?envType=daily-question&envId=2025-05-17
 *
 * Input :
 * - Input integer array nums.
 * 
 * Defination : 
 * - Array contains objects of 3 colors red, white and blue. 
 * - Red, White and Blue are represented by 0, 1, and 2. 
 * 
 * Constraints:
 * n == nums.length
 * 1 <= n <= 300
 * nums[i] is either 0, 1, or 2.
 * 
 * Task: Sort the colors array, and it should be performed in-place.
 * 
 *
 * Observations:
 * #1 This can be solved by counting sort. 
 *    => Count object of each color. 
 *    => Overwrite array with total number of red (0's), then white (1's) and followed by blue (2's).
 *    => But this will be a two pass solution.  
 * 
 * Approach:
 * 1. Create an integer array of size 3, to keep the frequencey of each object. 
 *    - Traverse the array, and update the frequency. 
 * 2. Overwrite the original array, first with the red count, then with white count and finally with blue count. 
 *   
 * Time Complexity: O(N)
 *  - Collection is traversed twice, 
 *  - 1) To count the frequency of each color. 2) To overwrite the array. 
 *  - Although nested loops are used, but idx just traverse from 0 to n. Hence overwrite take O(number of color * N) => O(3 * N) => O(N).
 * 
 * Space Complexity: O(1)
 *  - colorCount of size 3 is taken for 3 colors. 
 *  - Final Complexity : O(3) => O(1)
 *  - Complexity directly depends on the number of colors. 
 *  
 * 
 * Note : This approach is scalable but takes two pass. 
 * 
 * Other Approaches : LeetCode_75_SortColor_SinglePass.java
 */

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class LeetCode_75_SortColor_CountingSort {

    @Test
    public void test1() {
        int[] nums = new int[] { 2, 0, 2, 1, 1, 0 };
        sortColors(nums);
        assertArrayEquals(new int[] { 0, 0, 1, 1, 2, 2 }, nums);
    }

    @Test
    public void test2() {
        int[] nums = new int[] { 2, 0, 1 };
        sortColors(nums);
        assertArrayEquals(new int[] { 0, 1, 2 }, nums);
    }

    @Test
    public void test3() {
        int[] nums = new int[] { 0 };
        sortColors(nums);
        assertArrayEquals(new int[] { 0 }, nums);
    }

    @Test
    public void test4() {
        int[] nums = new int[] { 0, 1 };
        sortColors(nums);
        assertArrayEquals(new int[] { 0, 1 }, nums);
    }

    @Test
    public void test5() {
        int[] nums = new int[] { 1, 2, 0 };
        sortColors(nums);
        assertArrayEquals(new int[] { 0, 1, 2 }, nums);
    }

    public void sortColors(int[] nums) {
       
        int[] colorCount = new int[3];
        for (int num : nums) {
            colorCount[num]++;
        }

        int idx = 0;
        for (int color = 0; color < colorCount.length; color++) {
            for (int i = 0; i < colorCount[color]; i++) {
                nums[idx++] = color;
            }
        } 
    }
}