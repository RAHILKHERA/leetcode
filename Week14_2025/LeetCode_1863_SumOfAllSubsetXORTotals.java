package Week14_2025;

/**
 * LeetCode Problem: 1863. Sum of All Subset XOR Totals
 * Problem Link:
 * https://leetcode.com/problems/sum-of-all-subset-xor-totals/description/?envType=daily-question&envId=2025-04-05
 * 
 * Approach:
 * 
 * nums = [5, 1, 6]
 * Subsets => [5], [1], [6], [5,1], [5,6], [1,6], [5,1,6]
 * 1 => 001 5 ^ 1 => 100 = 4 1 ^ 5 ^ 6 = 2.
 * 5 => 101 1 ^ 6 => 111 = 7
 * 6 => 110 5 ^ 6 => 011 = 3
 * sum = 1 + 2 + 3 + 4 + 5 + 6 + 7 = 28 => 11100
 * 
 * Observation :
 * 1) The number of 0's in the answer is equal to n - 1. In example, n = 3 and
 * number of 0's on right = 2.
 * 2) Concentrating on most significant bits :
 * 
 * Example :
 * 1 => 001
 * 5 => 101
 * 6 => 110
 * ------------------
 * Output MSB => 111
 * 
 * Final Implication => Perform OR operations between all elements and shift it
 * by n - 1;
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1) where n = input length.
 */

public class LeetCode_1863_SumOfAllSubsetXORTotals {
    public int subsetXORSum(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result |= num;
        }

        return result << (nums.length - 1);
    }
}