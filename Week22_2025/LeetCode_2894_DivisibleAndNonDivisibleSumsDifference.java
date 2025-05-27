package Week22_2025;

/**
 * @RAHILKHERA
 *
 * LeetCode Problem: 2894 Divisible and nondivisible sums difference. 
 * Problem Link: https://leetcode.com/problems/divisible-and-non-divisible-sums-difference/description/?envType=daily-question&envId=2025-05-27
 *
 * Input:
 * - Positive Integer n
 * - Positive Integer m
 *
 * Constraints:
 * 1 <= n, m <= 1000
 * 
 * Definition : 
 * -> num1: The sum of all integers in the range [1, n] (both inclusive) that are not divisible by m.
 * -> num2: The sum of all integers in the range [1, n] (both inclusive) that are divisible by m.
 *
 * Task: Compute num1 - num2.
 *
 * Observations: 
 * #1. If sum = summation of [1,n] = n * (n + 1) /2 , then num1 = sum - num2. 
 *     => sum will have contribution of numbers that are divisible by m and that are not divisible by m. 
 *     => removing sum of the divisble by m (num2), will leave us with num1.
 *     => num1 = (n * (n + 1)/2) - num2 ---------------- equation 1.
 * #2. num2 = summation of numbers divisible by m but less than n.
 *     => num2 = m + 2m + 3m + .... + km. Suppose there are k multiples of m less than equal to n. 
 *     => num2 = m * (1 + 2 + 3 + ... + k)
 *     => num2 = m * k * (k + 1)/2, where k = floor (n/m) ------------ equation 2. 
 * #3. From equation 1 and 2,
 *     => num1 - num2 = sum - num2 - num2
 *     => num1 - num2 = sum - 2 * num2
 *     => num1 - num2 = (n * (n + 1)/2) - 2 * (m * k * (k + 1) / 2)
 *     => num1 - num2 = (n * (n + 1)/2) - (m * k * (k + 1))
 *     => num1 - num2 = (n * (n + 1)/2) - (m * (n/m) * ((n/m) + 1))
 * #4. Don't resolve m * (n/m) to n. as n/m will generate fraction, but as it is int, its floor value will be taken. hence m * (n/m) won't be equal to n in every case. 
 * 
 * Approach:
 * 1. Implement equation (n * (n + 1)/2) - (m * (n/m) * ((n/m) + 1)). 
 *  
 * Time Complexity: O(1)
 * |          Component                                    |   Time                             |
 * | ----------------------------------------------------- | ---------------------------------- |
 * | Compute the equation                                  | O(1)                               |
 * |-------------------------------------------------------|------------------------------------|
 * | Total Complexity                                      | O(1)                               |
 * 
 * 
 * Space Complexity: O(1)
 * |          Component                                    |   Time                             |
 * | ----------------------------------------------------- | ---------------------------------- |
 * | No extra space is utilized.                           | O(1)                               |
 * |-------------------------------------------------------|------------------------------------|
 * | Total Complexity                                      | O(1)                               |
 *
 */

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LeetCode_2894_DivisibleAndNonDivisibleSumsDifference {

    @Test
    public void test1() {
        assertEquals(19, differenceOfSums(10, 3));
    }

    @Test
    public void test2() {
        assertEquals(15, differenceOfSums(5, 6));
    }

    @Test
    public void test3() {
        assertEquals(-15, differenceOfSums(5, 1));
    }

    public int differenceOfSums(int n, int m) {
        return n * (n + 1) / 2 - m * (n / m) * ((n / m) + 1);
    }
}
