package Week21_2025;

/**
 * @RAHILKHERA
 *
 * LeetCode Problem: 2942 Find words containing character.
 * Problem Link: https://leetcode.com/problems/find-words-containing-character/description/?envType=daily-question&envId=2025-05-24
 *
 * Input:
 * - String array: words.
 * - char: x.
 *
 * Constraints:
 * 1 <= words.length <= 50
 * 1 <= words[i].length <= 50
 * x is a lowercase English letter.
 * words[i] consists only of lowercase English letters.
 *
 * Task: Generate a list of the indices of words containing the character x.
 *
 * Approach:
 * 1. Traverse the words array.
 *    => For each word, check if the character is part of the word. If it is, add the index to the final list.
 *
 * Time Complexity:
 * |          Component             |   Time                             |
 * | ------------------------------ | ---------------------------------- |
 * | Number of words                | O(n)                               |
 * | Check if char x exists         | O(m)                               |
 * |--------------------------------|------------------------------------|
 * | Total Complexity               | O(n*m) => O(N),                    |
 * |                                | N = n * m,                         |
 * |                                | total number of characters in array|
 *
 * Space Complexity: O(1)
 * - No extra space proportional to the input is used. The space required for the result is not included in the calculation.
 *
 */

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class LeetCode_2942_FindWordsContainingCharacter {

    @Test
    public void test1() {
        assertEquals(Arrays.asList(0, 1), findWordsContaining(new String[] { "leet", "code" }, 'e'));
    }

    @Test
    public void test2() {
        assertEquals(Arrays.asList(0, 2), findWordsContaining(new String[] { "abc", "bcd", "aaaa", "cbc" }, 'a'));
    }

    @Test
    public void test3() {
        assertEquals(Arrays.asList(), findWordsContaining(new String[] { "abc", "bcd", "aaaa", "cbc" }, 'z'));
    }

    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].indexOf(x) >= 0) {
                indices.add(i);
            }
        }
        return indices;
    }
}
