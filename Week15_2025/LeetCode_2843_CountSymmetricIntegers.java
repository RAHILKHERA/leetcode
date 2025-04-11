package Week15_2025;

/**
 * LeetCode Problem: 2843 Count Symmetric Integers.
 * Problem Link:
 * https://leetcode.com/problems/count-symmetric-integers/description/?envType=daily-question&envId=2025-04-11
 * 
 * Definition:
 * Symmetric Integer (SI): A positive integer 'x' having an even number of digits, 
 * such that the sum of the first half of its digits equals the sum of the second half.
 * 
 * Task:
 * Count the total number of symmetric integers in the range [low, high] (inclusive).
 * 
 * Observations:
 * #1 If the number of digits is odd, it cannot be symmetric.
 * #2 If the sum of the first half equals the second half, then summing and subtracting
 *    corresponding digits from both halves should result in zero.
 * 
 * Approach:
 * #1 Traverse all numbers from low to high.
 * #2 For numbers with even number of digits:
 *    a) Convert to string and find the sum of the first half and subtract the sum of the second half.
 * #3 If the result is zero, increment the symmetric count.
 * 
 * Time Complexity: O(n * d) → O(n), where n = (high - low + 1), and d = number of digits (max 10 for int).
 * Space Complexity: O(n * d) → O(n), due to string conversion for each number.
 */

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class LeetCode_2843_CountSymmetricIntegers {

    @Test
    public void test1() {
        assertEquals(9, countSymmetricIntegers(1, 100));
    }

    @Test
    public void test2() {
        assertEquals(4, countSymmetricIntegers(1200, 1230));
    }

    public int countSymmetricIntegers(int low, int high) {
        int count = 0;
        for (int num = low; num <= high; num++) {
            String str = Integer.toString(num);
            int len = str.length();
            if (len % 2 != 0)
                continue;

            int sum = 0;
            for (int i = 0; i < len / 2; i++) {
                sum += str.charAt(i) - '0';
                sum -= str.charAt(i + len / 2) - '0';
            }

            if (sum == 0)
                count++;
        }
        return count;
    }
}
