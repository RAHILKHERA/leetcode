package Week22_2025;

/**
 * @RAHILKHERA
 *
 * LeetCode Problem: 2942 Find words containing character.
 * Problem Link: https://leetcode.com/problems/longest-palindrome-by-concatenating-two-letter-words/description/?envType=daily-question&envId=2025-05-25
 *
 * Input:
 * - String array: words.
 *
 * Constraints:
 * 1 <= words.length <= 10^5
 * words[i].length == 2
 * words[i] consists of lowercase English letters.
 * 
 * Definition : A palindrome is a string that reads the same forward and backward.
 *
 * Task: Compute the length of the longest palindrome that can be created. 
 *
 * Observations: 
 * #1. There are two cases : 
 *  -> 1) both characters are different.
 *  -> 2) both characters are same. 
 * #2. To create a palidrome string using a word `s`, it's reverse `r` should be available. 
 *  -> The frequency of reverse word should be greater than 0. 
 * #3. If reverse is available, 
 *  => Increase the length of the string by 4. As both the word and it's reverse will be added to the the palindrome string. 
 *  => Reduce the frequency of the reverse word, as a word can be used only once.
 *  => If reverse is not available, increase the frequency of the word by 1. So if in future it's reverse is encountered, it can contribute to palindrome string.    
 *  => This is appicable for both the cases, that is same and different characters. 
 * #4. Special Case : As words are of length 2 and in case of same characters,
 *  => The word can be still be used without its reverse i.e. without it's another occurence. 
 *  => This word can be inserted in middle of valid palindrome and still resultant string will be palindrome. 
 *  => The resultant palindrome length will increase by 2.  
 * 
 * Approach:
 * 1. Use a 2D array `frequency` of size 26 x 26 to keep the frequency of the words and their reverse. 
 *  => This is possible as length of the word is 2.
 *  => If word is "ab", then frequency of "ab" will be in frequency[0][1] and frequency of "ba" will be [1][0]. 
 * 2. Use palindromeLength to track the length of longest palindrome.
 * 3. For each word,
 *  => Check if frequency[char at index 1][char at index 0] is greater than 0. This is equaivalent to check if reverse word exists.  
 *  => If frequency is greater than 0, increase palindrome by 4. Reduce frequency as a word can be used by only once. 
 *  => If reverse word is not available, increase the frequency of word by 1. 
 * 4. For each word with same characters,
 *  => There are only 26 options. 
 *  => Even if one word is available, increase the palindrome length by 2. 
 *  => But only one such word can be used. Hence terminate the loop here.
 *  
 * Time Complexity: O(n)
 * |          Component                                    |   Time                             |
 * | ----------------------------------------------------- | ---------------------------------- |
 * | Traverse the string array to compute the length       | O(n)                               |
 * | Handle same character word case                       | O(26)                              |
 * |-------------------------------------------------------|------------------------------------|
 * | Total Complexity                                      | O(n + 26) => O(n)                  |
 * 
 * 
 * Space Complexity: O(1)
 * |          Component                                    |   Time                             |
 * | ----------------------------------------------------- | ---------------------------------- |
 * | Using 2D array to trak frequency(remains constant)    | O(26 * 26) => O(676) => O(1)       |
 * |-------------------------------------------------------|------------------------------------|
 * | Total Complexity                                      | O(1)                               |
 *
 *  Note : Due to array, this approach is not scalable but much faster than map approach. 
 *  => Overhead of map operations is not applicable. 
 *  => No need to reverse the words. 
 *  => In case of same character special case, only 26 iterations will happen, while it can be O(n) in case of map approach. 
 *  => This approach is not scalable in terms of character set and length of the word.  
 * 
 *  Other Approaches : LeetCode_2131_LongestPalindromeByConcatenatingTwoLetterWords_ApproachMap. 
 */

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LeetCode_2131_LongestPalindromeByConcatenatingTwoLetterWords_ApproachArray {

    @Test
    public void test1() {
        assertEquals(6, longestPalindrome(new String[] { "lc", "cl", "gg" }));
    }

    @Test
    public void test2() {
        assertEquals(8, longestPalindrome(new String[] { "ab", "ty", "yt", "lc", "cl", "ab" }));
    }

    @Test
    public void test3() {
        assertEquals(2, longestPalindrome(new String[] { "cc", "ll", "xx" }));
    }

    public int longestPalindrome(String[] words) {
        int[][] frequency = new int[26][26];
        int palindromeLength = 0;
        for (String word : words) {
            int firstCharIndex = word.charAt(0) - 'a';
            int secondCharIndex = word.charAt(1) - 'a';
            if (frequency[secondCharIndex][firstCharIndex] > 0) {
                palindromeLength += 4;
                frequency[secondCharIndex][firstCharIndex]--;
            } else {
                frequency[firstCharIndex][secondCharIndex]++;
            }
        }

        for (int idx = 0; idx < 26; idx++) {
            if (frequency[idx][idx] > 0) {
                palindromeLength += 2;
                break;
            }
        }
        return palindromeLength;
    }
}
