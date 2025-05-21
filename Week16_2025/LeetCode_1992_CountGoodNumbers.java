package Week16_2025;

/**
 * LeetCode Problem: 1992 Count Good Numbers.
 * Problem Link:
 * https://leetcode.com/problems/count-good-numbers/?envType=daily-question&envId=2025-04-13
 * 
 * Definitions :
 * #1 Good Integer : It should have following properties :
 * a) Even digits at even indexes. (0,2,4,6,8)
 * b) Prime digits at odd indexes. (2,3,5,7)
 * 
 * Task : To count number of good integers for given n (number of digits).
 * Note : Preceeding 0s are allowed.
 * 
 * Observation :
 * #1 Each integer of n digits will have n/2 odd indexes. For each of them,
 * there are 4 options to fill (2,3,5,7).
 * #2 Each integer of n digits will have (n+1)/2 even indexes e.g.
 * if n = 5, there will be 3 even index to fill (0,2,4) i.e. (5 + 1)/2 = 3.
 * if n = 4, there will be 2 even index to fill (0,2) i.e (4 + 1) / 2 = 2.5 ~ 2
 * For each of these even indexes, there are 5 options to fill (0,2,4,6,8).
 * #3 As preceeding 0s are allowed and any digit can be used any number of
 * times, from permutation theroy, good numbers can be counted as follows :
 * count = 5 ^ ((n+1)/2) * 4 ^(n/2)
 * #4. As the numbers can be too large, use fast exponent.
 * 
 * Approach:
 * 1) Find possibilites for even indexes (x) : 5 ^ ((n+1)/2).
 * 2) Find possibilites for odd indexes (y) : 4 ^ (n/2).
 * 3) return x * y.
 * 
 * Time Complexity: O(log n). where n = digits and time complexity for fast
 * exponent is O(log n).
 * Space Complexity: O(1). No extra space is being used. As Iterative version of
 * fast exponent is used.
 */

public class LeetCode_1992_CountGoodNumbers {
    private static final long MOD = 1_000_000_007;

    public int countGoodNumbers(long n) {
        return (int) ((powIterative(5, (n + 1) / 2) * powRecursive(4, n / 2)) % MOD);
    }

    private long powRecursive(long x, long y) {

        if (y == 0) {
            return 1;
        }

        long half = powRecursive(x, y / 2);
        long result = (half * half) % MOD;

        if (y % 2 == 1) {
            result = (result * x) % MOD;
        }

        return result;
    }

    private long powIterative(long x, long y) {
        long result = 1;
        while (y > 0) {
            if (y % 2 == 1) {
                result = (result * x) % MOD;
            }
            x = (x * x) % MOD;
            y /= 2;
        }
        return result;
    }
}