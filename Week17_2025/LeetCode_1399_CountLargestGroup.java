package Week17_2025;

/**
 * LeetCode Problem: 1399 Count Largest Group
 * Problem Link:
 * https://leetcode.com/problems/count-largest-group/description/?envType=daily-question&envId=2025-04-23
 *
 * Definition : Given integer n, each number from 1 to n is grouped according to sum of its digits. 
 * 
 * Task: Return count of the groups that have the largest size. 
 * 
 * Observations:
 * #1. Constraints: 1 <= n <= 10^4 => 9999 will generate largest sum of digits = 36. 
 * #2. Due to low constraints, here array of size 37 can be used to store the count of the sum of the digits. 
 * #3. If want a scalable solution, instead of array, use map of sum of digits vs count. 
 *
 * Approach:
 * 1. For each number from 1 to n, calculate sum of digits(sum).
 *    a) number % 10 will provide least significant digit. 
 *    b) number /10 will allow to get rid of the last digit. 
 *    c) keep separating and adding the digits until number becomes 0. 
 * 2. For sum, increase the frequency. 
 * 3. If the current sum frequency is greater then largest frequency seen till now, then first group with largest sum is found. 
 * If the current sum frequency is equal to largest frequency, then increase the count. 
 *
 * Time Complexity: O(nlogn)
 *   - O(log n) to find the sum of digits of a number. 
 *   - O(n) to traverse from 1 to n. 
 *   => Final: O(nlogn)
 *
 * Space Complexity: O(1)
 *   - Using an array of size (37) for storing the frequency of the sum. => O(37) = O(1).
 */


import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class LeetCode_1399_CountLargestGroup {


    @Test
    public void test1() {
        assertEquals(4, countLargestGroup(13));
    }

    public int countLargestGroup(int n) {

        int maxGroupSize = 0;
        int count = 0;
        int [] sumFrequency = new int [37];
        for (int number = 1; number <= n; number++) {
            int sum = digitSum(number);
            sumFrequency[sum]++;
            if (maxGroupSize < sumFrequency[sum]) {
                maxGroupSize = sumFrequency[sum];
                count = 1;
            } else if (maxGroupSize == sumFrequency[sum]) {
                count++;
            }
        }

        return count;
    }

    private int digitSum(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}