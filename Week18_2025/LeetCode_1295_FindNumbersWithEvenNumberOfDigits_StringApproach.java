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
 * #1. Converting the integer to its string representation will help here. 
 * #2. Find the length and check if it even, here AND operation is used. 
 * #3. Performing AND operation with 1, will return 0 for even number as all the even numbers has unset least significant bit. 
 * #4. Increment the count for all the string representations of integer whose length is even. 
 * 
 * 
 * Approach:
 * 1. Traverse the input array.
 * 2. Convert to string.
 * 3. Find the length of the string.
 * 4. Perform AND operation with 1 to check if the length is even or not. 
 * 5. If even increase the count. 
 * 
 * Time Complexity: O(n), n = length of the array.  
 * Space Complexity: O(1), no extra space propotional to input size is used. 
 *         
 * Note : Unlike Range check approach, this approach is scalable but slower as it requires to convert to the string representation. 
 * 
 * Other Approaches : 
 * LeetCode_1295_FindNumbersWithEvenNumberOfDigits_RangeCheckApproach.java
 * LeetCode_1295_FindNumbersWithEvenNumberOfDigits_LogApproach.java
 */
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class LeetCode_1295_FindNumbersWithEvenNumberOfDigits_StringApproach {
    
    
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
            if ((Integer.toString(num).length() & 1) == 0) {
                count++;
            }
        } 
        return count;   
    }
}
