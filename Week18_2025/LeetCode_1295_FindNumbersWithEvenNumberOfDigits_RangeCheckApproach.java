package Week18_2025;
/**
 * LeetCode Problem: 1295 Find numbers with even number of digits.
 * Problem Link: https://leetcode.com/problems/find-numbers-with-even-number-of-digits/description/
 *
 * Input : 
 *  - Integer array nums.
 * 
 * Constraints:
 * 1 <= nums.length <= 500
 * 1 <= nums[i] <= 10^5
 * 
 * Task:
 * Count the number of integers with even number of digits. 
 *
 * Observations:
 * #1. The range of number is small. 
 * #2. Integer in range [10, 99], [1000, 9999] and 100000 are to be counted. 
 * #3. Directly check if the number is in the range or edge case equals to 10^5 then increase the count. 
 * 
 * 
 * Approach:
 * 1. Traverse the input array.
 * 2. For each integer, check if it is in range [10,99], [1000, 9999] or equal to 10^5.
 *    => If it is, increase the count. 
 * 
 * Time Complexity: O(n), n = length of the array.  
 * Space Complexity: O(1), no extra space propotional to input size is used. 
 *         
 * Note : Although this approach is fast, it is not scalable. 
 * 
 * Other Approaches : 
 * LeetCode_1295_FindNumbersWithEvenNumberOfDigits_LogApproach.java
 * LeetCode_1295_FindNumbersWithEvenNumberOfDigits_StringApproach.java
 */
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class LeetCode_1295_FindNumbersWithEvenNumberOfDigits_RangeCheckApproach {
    
    
    @Test
    public void test1(){
        assertEquals(2, findNumbers(new int[] {12,345,2,6,7896}));
    }

    @Test
    public void test2(){
        assertEquals(1, findNumbers(new int[] {555,901,482,1771}));
    }

    @Test
    public void test3(){
        assertEquals(1, findNumbers(new int[] {1000}));
    }
    
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if ((num > 9 && num < 100) || (num > 999 && num < 10000) || num == 100000) {
                count++;
            }
        }
        return count;
    }
}
