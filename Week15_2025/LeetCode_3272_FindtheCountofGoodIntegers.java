package Week15_2025;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode Problem: 3272 Find the count of good integers
 * Problem Link:
 * https://leetcode.com/problems/find-the-count-of-good-integers/description/?envType=daily-question&envId=2025-04-12
 * 
 * Definitions :
 * #1 K- Palindrome : Integer is palindrome and it is divisible by k.
 * #2 Good Integer : If integer's digits can be rearranged to form K-palindrome.
 * 
 * Task : To count number of good integers for given n (number of digits) and k.
 * Note : Preceeding 0s are not allowed.
 * 
 * Observation :
 * #1 A Palindrom number can be of two types :
 * a. Even -> even number of digits. In this case, if number is partitioned from
 * middle, right half is mirror image of left half.
 * b. Odd -> odd number of digits. In this case, if number is partitioned from
 * middle, right half is mirror image of left half except last element of left
 * half.
 * #2. From #1 it is clear that only half of digits is required to generate all
 * the palindromes.
 * #3. n -> no of digits is given. From this starting and ending of range can be
 * calcualated. Start = 10^(digits-1). Ending = 10^digits - 1. e.g digits = 3 =>
 * start = 10^(3-1) = 100 end = 10^3 - 1 = 1000 - 1 = 999.
 * #4. Different permutations of digits of an integer can result in same
 * k-palidrome. So sort the number by digits and save it in set. To avoid
 * duplicates.
 * 
 * 
 * Approach:
 * 1)
 * 
 * Time Complexity: O(n^2). It will still be O(n^2), but this will be faster
 * compare to top-down approach due to absence of recursion overhead.
 * Space Complexity: O(n) where n = input length.
 */

public class LeetCode_3272_FindtheCountofGoodIntegers {

    private static final int[] factorial = new int[11];

    static {
        factorial[0] = 1;
        for (int num = 1; num < 11; num++) {
            factorial[num] = num * factorial[num - 1];
        }
    }

    public long countGoodIntegers(int n, int k) {
        int digits = (n + 1) / 2;
        int start = (int) Math.pow(10, digits - 1);
        int end = start * 10 - 1; // Math.pow(10,digits) - 1
        Set<String> set = new HashSet<>();
        // Generate All the palindroms of length n.
        for (int num = start; num <= end; num++) {
            String leftHalf = Integer.toString(num);
            String rightHalf = n % 2 == 0 ? new StringBuilder(leftHalf).reverse().toString()
                    : new StringBuilder(leftHalf.substring(0, digits - 1)).reverse().toString();

            String number = leftHalf + rightHalf;
            long palindromeNumber = Long.parseLong(number);
            /**
             * Different palindrom numbers having same frequency of the digits e.g. 121 and
             * 112 will yeild same results i.e. duplicate results.
             * To find the common point, it is better to sort it and add it to set. Hence
             * one pattern of number appears only once.
             */
            if (palindromeNumber % k == 0) {
                char ch[] = number.toCharArray();
                Arrays.sort(ch);
                set.add(new String(ch));
            }
        }

        // Count permutations for each k- palindromic number.
        long result = 0;
        for (String number : set) {

            int[] freq = new int[10];
            for (char ch : number.toCharArray()) {
                freq[ch - '0']++;
            }

            // Leading Zeros are not allowed. So for the first position, number of available
            // options will be reduced by the zero count.
            int nonZeroCount = n - freq[0];
            long ans = (long) nonZeroCount * factorial[n - 1];

            // Permutation Formula : If duplicates are available : n!/ Product of factorial
            // of each frequency.
            for (int f : freq) {
                ans /= factorial[f];
            }

            result += ans;

        }
        return result;
    }
}