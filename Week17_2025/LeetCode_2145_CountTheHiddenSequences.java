package Week17_2025;

/**
 * LeetCode Problem: 2145 Count the hidden sequences. 
 * Problem Link:
 * https://leetcode.com/problems/count-the-hidden-sequences/description/?envType=daily-question&envId=2025-04-21
 * 
 * Definition:
 * Differences array : differences between each pair of consecutive integers. 
 * differences[i] = hidden[i + 1] - hidden[i]
 *
 * Task:
 * Count the number of hidden sequences of n + 1 length that can be created for the given difference array of size n, 
 * and whose each element is in the range [lower, upper].
 *
 * Observations:
 * #1. differences[i] = hidden[i + 1] - hidden[i]
 * => hidden[i + 1] = hidden[i] + differences[i]
 * #2. Assume given difference array is [d0, d1, d2] and  if first element of sequence is x then other elements can be calculated as follows:
 *      x + d[0], x + d[0] + d[1], x + d[0] + d[1] + d[2]. 
 * #3. (d[0], d[0] + d[1], d[0] + d[1] + d[2]) is a prefix sum pattern. 
 * #4. Shifting prefix sum D[i] (D[i] = D[i-1] + d[i]) of each difference by value 'x' will result in the hidden sequence, and this to be valid all the elements should be in [lower, upper].
 * => lower <= x + D[i] <= upper (For every prefix sum this should hold.)
 * => lower <= x + min (D[i]) and max(D[i]) + x <= upper (Generalize form)
 * => lower - min(D[i]) <= x and x <= upper - max(D[i]).
 * => x should be in range of [lower - min(D[i]), upper - max(D[i])].
 * => Total counts = (upper - max(D[i])) - (lower - min(D[i])) + 1.
 * => Total counts = (upper - lower) - (max(D[i]) - min(D[i])) + 1.
 * => If at any point (max(D[i]) - min(D[i])) > (upper - lower), then return 0 as for that element sequence cannot be generated. 
 * 
 * Approach:
 * 1. Traverse through the difference array, past prefix sum are not required. Keep a variable to store prefix sum of diffs till current element. 
 * 2. In additon to calculating prefix sum, keep track of minimum and maximum prefix sum seen. 
 * 3. If at any point difference between maximum and minimum prefix is more than difference of upper and lower, then no sequence can be found, return 0.
 * 4. Return  (max(D[i]) - min(D[i])) > (upper - lower), 
 *      where D[i] = prefix sum till ith element, 
 *      max = maximum of all the prefix sums,
 *      min = minimum of all the prefix sums.
 * 
 * Time Complexity: O(n), n = no. of differences. 
 * 
 * Space Complexity: O(1)
 *   - Except few variables, no extra space is used. 
 */

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LeetCode_2145_CountTheHiddenSequences {

    @Test
    public void test1() {
        assertEquals(2, numberOfArrays(new int[] { 1, -3, 4 }, 1, 6));
    }

    @Test
    public void test2() {
        assertEquals(4, numberOfArrays(new int[] { 3, -4, 5, 1, -2 }, -4, 5));
    }

    @Test
    public void test3() {
        assertEquals(0, numberOfArrays(new int[] { 4, -7, 2 }, 3, 6));
    }

    @Test
    public void testEmptyDiff() {
        assertEquals(6, numberOfArrays(new int[] {}, 5, 10));
    }

    @Test
    public void testSingleRange() {
        assertEquals(1, numberOfArrays(new int[] {}, 4, 4));
    }

    /**
     * Calculates the number of valid hidden sequences whose consecutive differences
     * match the given array,
     * and all values are within [lower, upper].
     */

    public int numberOfArrays(int[] differences, int lower, int upper) {
        int min = 0;
        int max = 0;
        int currDiffSum = 0;
        int allowedRange = upper - lower;
        for (int diff : differences) {
            currDiffSum += diff;
            min = Math.min(min, currDiffSum);
            max = Math.max(max, currDiffSum);
            if ((max - min) > allowedRange) {
                return 0;
            }
        }

        return (allowedRange) - (max - min) + 1;
    }
}
