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
 * 1. Use hashmap to keep track of words and their frequency. 
 * 2. Use palindromeLength to track the length of longest palindrome.
 * 3. For each word,
 *  => Reverse the word. 
 *  => Check if the reverse word is present in the map,
 *      -> If reverse word is present, add 4 to the palindromeLength. Reduce the frequency of reverse word. If frequency is 0, remove reverse word from map. 
 *      -> Else i.e. reverse word is not present, add word to the map with frequecy 1. 
 * 4. Traverse the map, 
 * => If there exists a word with equal characters, add 2 to the palindromeLength. 
 * => This word can be inserted in the middle of the palindorme  string. 
 * => But only one such word can be used. Hence terminate the loop here. 
 *  
 *
 * Time Complexity: O(n)
 * |          Component                                    |   Time                             |
 * | ----------------------------------------------------- | ---------------------------------- |
 * | Traverse the string array to compute the length       | O(n)                               |
 * | Handle same character word case                       | O(n)                               |
 * |-------------------------------------------------------|------------------------------------|
 * | Total Complexity                                      | O(n + n) => O(2*n) => O(n)         |
 * 
 * 
 * Space Complexity: O(n)
 * |          Component                                    |   Time                             |
 * | ----------------------------------------------------- | ---------------------------------- |
 * | Use hashmap for tracking word vs frequency            | O(n)                               |
 * |-------------------------------------------------------|------------------------------------|
 * | Total Complexity                                      | O(n)                               |
 *
 *  Note : Due to map, this approach is scalable but slower compare another approach. 
 * 
 *  Other Approaches : LeetCode_2131_LongestPalindromeByConcatenatingTwoLetterWords_ApproachArray. 
 */


import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class LeetCode_2131_LongestPalindromeByConcatenatingTwoLetterWords_ApproachMap {

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
        int n = words.length;
        Map<String, Integer> frequencyMap = new HashMap<>();
        int palindromeLength = 0;
        for (int idx = 0; idx < n; idx++) {
            String word = words[idx];
            String reverseWord = new StringBuilder(word).reverse().toString();
            if (frequencyMap.getOrDefault(reverseWord, 0) > 0) {
                palindromeLength += 4;
                frequencyMap.compute(reverseWord, (key, value) -> value == 1 ? null : value - 1);
            } else {
                frequencyMap.compute(word, (key, value) -> value == null ? 1 : value + 1);
            }
        }

        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
            String word = entry.getKey();
            if (word.charAt(0) != word.charAt(1)) {
                continue;
            }

            if (entry.getValue() > 0) {
                palindromeLength += 2;
                break;
            }
        }

        return palindromeLength;
    }
}
