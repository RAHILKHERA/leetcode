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
 * Follow up Question : Can this be done in a single pass using only constant extra space? 
 *
 * Observations:
 * #1 This can be solved by counting sort. 
 *    => Count object of each color. 
 *    => Overwrite array with total number of red (0's), then white (1's) and followed by blue (2's).
 *    => But this will be a two pass solution. 
 *    => Keep the follow up question into consideration, try to perform this task in one pass. 
 * #2. The collection has only 3 colors :
 *    => Partitioning the red color on left and blue on the right will do the trick. 
 *    => As two are seperated, third color group is automatically formed. 
 * #3. This can be solved using 3 pointeres.
 *    => left pointer : pointer to keep the track where next red (0) will appear. 
 *    => right pointer : pointer to keep the track where next blue (1) will appear. 
 *    => idx : pointer to current element.
 * #4. If current object is red, and a place on left is available then swap. 
 * #5. If current object is blue, and a place on right is available then swap. 
 * 
 * Approach:
 * 1. Create three pointers : 
 *    => left = 0 : To keep track where next 0 will appear, as segregating red on left. 
 *    => right = n - 1 : To keep track where next 2 will appear, as segregating blue on right. 
 *    => idx = 0 : To keep track of current element. 
 * 2. Traverse through the array, 
 *    => If nums[idx] == 0 and idx >= left, perform swap(nums[idx], nums[left]).
 *    => If nums[idx] == 2 amd idx <= right, perform swap(nums[idx], nums[right]).
 *   
 * Time Complexity: O(N)
 *  - Each red and blue object is access at most twice, once during traversal and another during swap. 
 *  - Each white object is accessed only once that is during traversal. 
 *  - Final Complexity : O(N).
 * 
 * Space Complexity: O(1)
 *  - No extra space is used which grows in propotion to the size of the input array. 
 * 
 * Note : This approach is not scalable for higher number of colors. 
 * 
 * Other Approaches : LeetCode_1550_ThreeConsecutiveOdds_ApproachSlidingWindow.java
 */

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class LeetCode_75_SortColor_SinglePass {

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
        int low = 0, mid = 0, high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low++, mid++);
            } else if (nums[mid] == 1) {
                mid++;
            } else { // nums[mid] == 2
                swap(nums, mid, high--);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}