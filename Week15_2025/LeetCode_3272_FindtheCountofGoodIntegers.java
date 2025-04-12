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
 * 1) Find all the k-palindromic integers from start to end. Convert number into
 * string for easiness of opertion.
 * 2) To calculate good integer for each k-palindrome, calculate permutation.
 * a) If there are n distinct digits, it will be n!.
 * b) Find the freq of each digit, this will be used to calculate permutations.
 * c) As the number is palindromic, all the digits will be with even frequency
 * except atmost one digit with odd frequency. Hence, permutation = n!/(product
 * of freq!), where freq! is factorial of frequency of each digit.
 * d) Preceeding zeros are not allowed. So for the first position in the number,
 * only non-zero digits are available. So permutation for single k-palindrome =
 * non-zero * (n-1)!/ (product
 * of freq!)
 * 
 * 
 * Time Complexity: O(10^n log n). where 10^n = digits and due to sorting it
 * will n log n.
 * Space Complexity: O(10^n).
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