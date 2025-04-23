package Week17_2025;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * LeetCode Problem: 2338 Count Number of Ideal Arrays.
 * Problem Link:
 * https://leetcode.com/problems/count-the-number-of-ideal-arrays/description/
 * 
 * Input : Integers n and maxValue.
 *
 * Definition : Array `arr` of length n is considered ideal if all the elements
 * of the array satisfies following conditions :
 * i) 1 <= arr[i] <= maxValue
 * ii) arr[i] is divisible by arr[i-1].
 * 
 * Constraints :
 * i) 2 <= n <=10^4
 * ii) 1 <= maxValue <= 10^4.
 * 
 * Task: Return number of distinct ideal arrays of length n.
 * 
 * Observations:
 * #1. There are n positions to fill, starting from index 0 to n - 1. For each
 * position, the available value is from 1 to maxValue.
 * #2. As there are options for each position, this implies to dynammic
 * programming.
 * #3. To high constraints, classic dynammic programming approach of recursion +
 * memoization won't work. It will require optimization.
 * #4. For every index idx, arr[idx] % arr[idx - 1] = 0 => arr[idx] =
 * k*arr[idx-1] => arr[idx - 1] <= arr[idx] => ideal array will be non -
 * decreasing.
 * #5. So, the first element of the sequence controls, which and how many
 * sequences are created.
 * #6. This problems requires to be solved in two sections
 * a) First creating sets of all the valid options.
 * b) Counting number of ideal arrays with each set of options.
 * #7. An array of size n, can be partitioned in maximum n - 1 ways. i.e. one
 * partition after each element.
 * Assuming the length of the current set to be len and if assumed that all the
 * elements of the set needs to be utilized.
 * Then there are (n-1)C(len-1) possibilites for the generating the ideal array.
 * This is explained in below example.
 * n = 5, Set = {1, 2, 4} => 2 is divisible by 1 and 4 is divisble by 2 => len =
 * 3.
 * __ __ __ __ __ => n = 5
 * __ | __ | __ | __ | __ => | represents maximum possible partitions.
 * 1 1 # 2 # 4 4 => one possible ideal arry => Total possibilites for this set
 * will be (n-1)C(len-1) = 4C2 = 4!/2!(4-2)! = 6.
 * #8. In #7, it was assumed, that all the elements are need to be utilized.
 * This can be assumed as the element which needs to be kept optional for
 * creation of array, can be kept outside of the set.
 * From above example valid sets with n = 5 and maxValue = 5
 * => {1}, {2}, {3}, {4}, {5}, {1, 2}, {1,3}, {1,4} {1,5}, {2,4}, {1,2,4}
 * => It is clear that above sets will include all the ideal arrays which can be
 * generated if above assumption was not done.
 * #9. Important : Total number of possibilites depends on n and len => all the
 * sets of same length will have same number of possibilites.
 * => So, a count array wil be maintain for each length of the set. So only
 * calculating ((n-1)C(len-1)) once is sufficient, multiply this by number of
 * sets with same length.
 * => 2^13 = 8192 and 2^14 = 16,384. So the maximum length of the set could be
 * 15. Hence length of count array will be 15.
 * => To formula to calculate nCr = n!/r!(n-r)! => There is need to find the
 * factorial. This will be precomputed for all the values from 1 to n.
 * => Also all the calculatioins can result in large numbers, hence modulation
 * by 10^9 + 7 is recommended.
 * => modular nCr is required. This can be implemented using Fermat's Little
 * Theorem.
 * => Now, Fermat's Little Theorem needs to find power, here too, the large
 * number will appear. So binary exponent requires to be used.
 * #10. Creation of Sets : Creating all the sets will not be feasible as there
 * will be too many sets. But following observations can be used
 * => If last element of the set is x and if length of the set till 2nd last
 * element is know, then length of set ending with x will be one more than the
 * length of set ending with 2nd last element.
 * For e.g. if last element is 16 then some of the previous values could be
 * 2,4,8. If length of array ending at 8 is len than that array can be extend by
 * adding 16. Now the length of the set will be len + 1.
 * If set is {1, 2, 4, 8} => length of set ending at 8 is 4 => new set
 * {1,2,4,8,16} => length of set ending at 16 will be 5.
 * => So above example is applicable for all the divisors of the current value.
 * => Here, dynamic programming can be used. dp[value][len] => number of sets
 * ending at 'value' of length 'len'.
 * e.g. {1,8}, {2,8}, {4,8}, {8,8} Here dp[8][2] = 4 => 4 sets with ending 8.
 * All these sets can be extended to 16.
 * => {1,8,16}, {2,8,16}, {4,8,16}, {8,8,16} => dp[16][3] = dp[8][2];
 * => dp[value][len] += dp[value/divisor][len + 1]; (only if value % divisor ==
 * 0)
 * => dp[value][len] also represents same value as count[len] i.e. number of
 * sets of length len.
 * => dp[value][1] = 1 i.e. only one set of ending at value with length = 1 can
 * be formed.
 * 
 * Fermat's Little Theorem : if (a/b) % M needs to find out,
 * (a/b) % M => (a * b^-1) % M then b^-1 can be replaced by b^(M-2) % M.
 * 
 * Approach:
 * 1. Find the count of all the sets ending at 'value' and of length 'len'.
 * value = [1, maxValue] and len = [1, 14]
 * 2. Pre compute all the factorials till n. This will be used in Modular nCr.
 * 3. For all lengths [1, 14], if there are sets of that length i.e. count[len]
 * != 0, calculate possibilites using modular nCr and multiply by count[len].
 * 4. Summation of all the possibilites is final result.
 * 
 * Find Sets ending at value `val`:
 * a) Start from 2 till val, check if it is divisor of val.
 * b) If it is divisor, then get count of sets ending in val/divisior as
 * following results exists
 * => dp[value][len] += dp[value/divisor][len + 1]; (only if value % divisor ==
 * 0)
 * c) Also update count[len].
 * => dp[value][len] also represents same value as count[len] i.e. number of
 * sets of length len.
 * 
 * Note : At every stage of mathematical computation, perform % MOD.
 * 
 * Time Complexity: O(maxValue * log(maxValue))
 * - [1, maxValue] findSets is called.
 * - Compute findSets for val => O(log(maxValue))
 *
 * Space Complexity: O(maxValue)
 * - dp -> maxValue * 15
 * - count -> 15
 * - Final -> O(maxValue * 15 + 15) => O(maxValue).
 * 
 * The following solution is directly implemented based on this YouTube video:
 * https://www.youtube.com/watch?v=-3O4xMNjnUs&t=855s&ab_channel=codestorywithMIK
 */ 

public class LeetCode_2338_CountNumberOfIdealArrays {


    @Test
    public void test1() {
        assertEquals(10, idealArrays(2, 5));
    }

    @Test
    public void test2() {
        assertEquals(11, idealArrays(5, 3));
    }


    private static final int MOD = 1_000_000_000 + 7;

    private long power(long a, long b) {

        long result = 1;
        while (b > 0) {
            if ((b & 1) == 1) { //Check if b is odd. 
                result = (result * a) % MOD;
            }
            a =  (a * a) % MOD;
            b >>= 1; //Divide b by 2. 
        }
        return result;
    }

    private int modularNcR(int n, int r, long[] fact) {
        if (r < 0 || r > n) {
            return 0;
        }
        long b = (fact[r] * fact[n - r] )% MOD;
        int result = (int) ((fact[n] * power(b, MOD - 2)) % MOD);
        return result;
    }

    public int idealArrays(int n, int maxValue) {
        int[][] dp = new int[maxValue + 1][15];
        int[] count = new int[15];

        for (int val = 1; val <= maxValue; val++) {
            findSets(val, count, dp);
        }

        long fact[] = new long[n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
        }

        long result = 0;

        for (int len = 1; len < 15; len++) {
            if (n < len) break;
            if (count[len] != 0) {
                long possibilites = modularNcR(n - 1, len - 1, fact);
                result = (result + (count[len] * possibilites) % MOD) % MOD;    
            }
        }

        return (int) result;
    }

    private void findSets(int val, int[] count, int[][] dp) {
        if (dp[val][1] != 0) {
            return;
        }

        dp[val][1] = 1;
        count[1]++;

        for (int div = 2; div <= val; div++) {
            if (val % div == 0) {
                findSets(val / div, count, dp);
                for (int len = 1; len < 15; len++) {
                    if (dp[val / div][len] != 0) {
                        dp[val][len + 1] = (dp[val][len + 1] + dp[val / div][len]) % MOD;
                        count[len + 1] = (count[len + 1] + dp[val / div][len]) % MOD;
                    }
                }
            }

        }
    }
}
