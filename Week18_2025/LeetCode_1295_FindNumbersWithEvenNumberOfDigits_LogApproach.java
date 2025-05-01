package Week18_2025;

/**
 * 
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
 * #1. Finding the log to the base 10 of an integer gives number of digits. => digits = log10(x) + 1
 * #2. Two ways to find the log, either log(x)/log(10) or use log10(x).
 *      => log(x)/log(10) can give wrong answers were x is multiple of 10. The reason is due to floating point operations. 
 *      => Avoid approach 1, instead use log10(x). 
 * #3. Check if the number of digits is even/odd by performing AND OPERATION between number and 1. 
 * 
 * Approach:
 * 1. Traverse the input array.
 * 2. Calculate number of digits in number by taking integer part of log to the base 10 of the integer and adding 1 to it. 
 * 3. Check if the number of digits is even/odd by performing AND operation between number of digits and 1. 
 * 4. If even increase the count. 
 * 
 * Time Complexity: O(n), n = length of the array.  
 * Space Complexity: O(1), no extra space propotional to input size is used. 
 *        
 * Note : As log10(x) takes constant time, this approach is faster compare to string approach and also scalable too. 
 * 
 * Other Approaches : 
 * LeetCode_1295_FindNumbersWithEvenNumberOfDigits_RangeCheckApproach.java
 * LeetCode_1295_FindNumbersWithEvenNumberOfDigits_StringApproach.java
 */
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class LeetCode_1295_FindNumbersWithEvenNumberOfDigits_LogApproach {
    
    
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
            int digits = (int)Math.log10(num) + 1;
            if ((digits & 1) == 0) {
                count++;
            }
        } 
        return count;   
    }
}
