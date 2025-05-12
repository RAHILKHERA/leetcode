package Week20_2025;

/**
 * @RAHILKHERA
 * 
 * LeetCode Problem: 2094 Finding 3 digit even numbers. 
 * Problem Link:
 * https://leetcode.com/problems/finding-3-digit-even-numbers/description/?envType=daily-question&envId=2025-05-12
 *
 * Input :
 * - Input integer array digits.
 * - Each element is digit. 
 * 
 * Constraints:
 * 3 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 * 
 * Task: Generate the sorted list of 3 digit even numbers, with the frequency of each digit not exceeding that in the input array.  
 *
 * Observations:
 * #1. As the given contraints especially the length of the number to be genrated is small (3 in this case), simplest approach would be
 * to write 3 loops, one for the hundred place, one for tens place and last one for unit place. 
 *    => The frequency of a digit in a number is upper bounded by the frequency of the digit in the digits array. 
 *    => The unit place will have only 5 options, i.e. 0,2,4,6 and 8. 
 * #2. To implement a generic solution, i.e for generating number with base b (<= 10), length n and condition whether the number can be odd or even.
 *     following steps can be performed :
 *    => Using a backtracking approach. Generate all the possible combinations of length n with base b. 
 *    => This will generate b^n combinations in worst case. But applying the conditions it prune the tree. 
 *    => Number can be either even or odd, that means for the unit place we have only half the options. 
 *    => Leading zeros are not allowed, hence the options with length less than n will be removed too. 
 *    => For e.g. in this case, 0 - 99 will be not be generated. 
 *    => Additionally, the number of combinations are also capped by the frequency of the digits in the array. 
 *    => Practically, or average case will be have much smaller number of combinations than (B^N)/2.
 * #3. Start from 0 and move till base - 1 i.e. the number of digits available  in either of binary, octa or decimal systems. 
 *     => Keep track of the position in the number getting filled. 
 *     => If it is 1st position i.e. position = 0; then skip digit 0. 
 *     => Check if the current digit is available that is frequency of the digit is more than 0. 
 *     => If it is, check if the current position is last position i.e. position = n - 1 and the digit satisfies the condition.
 *     => Condition could be either odd or even check. 
 *     => Reduce the frequency of the digit, as this is being used for this position. 
 *     => On the basis of the current position, digit and base, the contribution of the digit can be calculated.
 *     => digit contribution (temp) = digit * base ^ (n - position - 1). [Using reverse positioning].
 *     => Expand the tree for the next position i.e. position + 1. 
 *     => Backtrack, to this position to try other digits, before trying other digits, increase the frequency of the current digit, 
 *        as the now digit will be again available, also reduce current number by temp i.e the amount of contribution of the current 
 *        digit to the number. 
 *     => Base Case : If the number of length n is found, then add it to the resultant list.  
 * 
 * Approach:
 * 1. Set base = 10 and as dealing with decimal. 
 * 2. Set n = 3 as three digit number is required. 
 * 3. Set predicate. digit -> (digit & 1) == 0, as even numbers are allowed only. 
 * 4. Calcuate frequency of each digit in the array. 
 * 5. Backtracking Implementation generateNumbers(position, currentSum, condition),
 *    => position : place of the digit in the number.
 *    => currentSum : Total contribution of the selected digits. 
 *    => condition : To check if the number is even or not, that depends on the last digit. 
 *    => Base Case : If position is reached equal to the required length, number is found, add to the resultant list. 
 *    => Traverse from 0 to last posible digit i.e. base - 1 = 9 in this case. 
 *    => If current position is first i.e. position = 0, then skip 0.
 *    => If frequency of current digit is 0, then skip it. 
 *    => If current position is last, check if the digit is even. 
 *    => Calculate current contribution of the digit to the number (temp). temp = digit * power(base, n - position - 1).
 *    => Reduce the frequency of the digit, as it is already used in this position. 
 *    => Expand tree : generateNumbers (position + 1, currentSum, condition).
 *    => Return to this state, to try with other digits in the same position. 
 *    => Before trying other digits in this position, increase the frequency of the current digit. 
 *    => Reduce the currentSum by temp, i.e. the contribution of the current digit. 
 * 6. As the result is required in integer array, convert the array list to integer array. 
 * 7. Use binary exponent to find the power.
 * 
 * Note : While generating the numbers, for the most significant position, lowest digit is used and moved towards highest digit. 
 *        Hence no need to sort the final result. As the result will be in the sorted order. 
 * Time Complexity: O((B^N)/2)
 *  - Base number : B in this case B = 10. 
 *  - Number of digits : N in this case N = 3.    
 * Space Complexity: O(N + M)
 *  - N : Due to recursion tree. 
 *  - M : Length of the result. 
 *
 */

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.junit.Test;

public class LeetCode_2094_FindingThreeDigitEvenNumbers {

    private int n;
    private int[] frequency;
    private List<Integer> list;
    private int base;

    @Test
    public void test1() {
        assertArrayEquals(new int[] { 102, 120, 130, 132, 210, 230, 302, 310, 312, 320 },
                findEvenNumbers(new int[] { 2, 1, 3, 0 }));
    }

    @Test
    public void test2() {
        assertArrayEquals(new int[] { 222, 228, 282, 288, 822, 828, 882 },
                findEvenNumbers(new int[] { 2, 2, 8, 8, 2 }));
    }

    @Test
    public void test3() {
        assertArrayEquals(new int[] {},
                findEvenNumbers(new int[] { 3, 7, 5 }));
    }

    @Test
    public void test4() {
        assertArrayEquals(new int[] { 202, 220},
                findEvenNumbers(new int[] { 2, 0, 2 }));
    }

    public int[] findEvenNumbers(int[] digits) {
        this.base = 10;
        return findSameParityOfNdigits(digits, 3, digit -> (digit & 1) == 0);
    }

    private int[] findSameParityOfNdigits(int[] digits, int n, Predicate<Integer> condition) {
        this.n = n;
        frequency = new int[base];
        list = new ArrayList<>();

        for (int digit : digits) {
            frequency[digit]++;
        }

        generateNumbers(0, 0, condition);

        int[] result = new int[list.size()];
        for (int pos = 0; pos < list.size(); pos++) {
            result[pos] = list.get(pos);
        }
        return result;
    }

    private void generateNumbers(int position, int currentSum, Predicate<Integer> condition) {

        if (position == n) {
            list.add(currentSum);
            return;
        }

        for (int digit = 0; digit < base; digit++) {

            // Leading zeros are not allowed.
            if (position == 0 && digit == 0) {
                continue;
            }

            if (frequency[digit] == 0) {
                continue;
            }

            // If the last digit does not have the required parity than should not continue.
            if (position == n - 1 && !condition.test(digit)) {
                continue;
            }

            frequency[digit]--;
            long temp = digit * power(base, n - position - 1);
            currentSum += temp;
            generateNumbers(position + 1, currentSum, condition);
            currentSum -= temp;
            frequency[digit]++;
        }
    }

    private long power(long a, long b) {
        long result = 1;
        while (b > 0) {
            if ((b & 1) != 0) {
                result *= a;
            }
            a = a * a;
            b >>= 1;
        }
        return result;
    }
}
