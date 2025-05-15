package Week20_2025;

 /**
     * @RAHILKHERA
     * 
     * LeetCode Problem: 2900 Longest unequal adjacent groups subsequence. 
     * Problem Link: https://leetcode.com/problems/longest-unequal-adjacent-groups-subsequence-i/?envType=daily-question&envId=2025-05-15
     *
     * Input :
     *  - String array  : words.
     *  - Integer array : groups.  
     * 
     * Constraints:
     * 1 <= n == words.length == groups.length <= 100
     * 1 <= words[i].length <= 10
     * groups[i] is either 0 or 1.
     * words consists of distinct strings.
     * words[i] consists of lowercase English letters.
     * 
     * Definition : 
     *  - Alternating subsequence, There are two types of words, either with group value of 0 or 1. 
     *  - The valid sequence is the sequence of the words with alternating groups. 
     *  - At index idx, groups[idx] represents group of words[idx]. 
     * 
     * Task: Find largest valid subsequence.  
     *
     * Observations: 
     * #1. The final sequence needs that the group of the choosen words has alternating group values. 
     * #2. As groups is binary, concept of parity can be used, if last selected word's group is x, then next word's group must be 1 - x.  
     * 
     * Approach:
     * 1. Maintain a variable `group`, to save the group of the last selected word. 
     * 2. Traverse words array, If word with 1 - group is available 
     *     - Add the word to resultant list. 
     *     - Assign the group of the current word. 
     * 
     * Time Complexity: O(N)
     *      - words array is traveresd only once. 
     *      - N = array of length. 
     *          
     * Space Complexity: O(1)
     *      - In addition to the return value, no extra space is required.
     */

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class LeetCode_2900_LongestUnequalAdjacentGroupsSubsequenceI {

    @Test
    public void test1() {
        assertEquals(Arrays.asList("e", "b"),
                getLongestSubsequence(new String[] { "e", "a", "b" }, new int[] { 0, 0, 1 }));
    }

    @Test
    public void test2() {
        assertEquals(Arrays.asList("a", "b", "c"),
                getLongestSubsequence(new String[] { "a", "b", "c", "d" }, new int[] { 1, 0, 1, 1 }));
    }

    @Test
    public void test3() {
        assertEquals(Arrays.asList("c"),
                getLongestSubsequence(new String[] { "c" }, new int[] { 0 }));
    }

    @Test
    public void test4() {
        assertEquals(Arrays.asList("d"),
                getLongestSubsequence(new String[] { "d" }, new int[] { 1 }));
    }

    @Test
    public void test5() {
        assertEquals(Arrays.asList("h", "vv", "kp"),
                getLongestSubsequence(new String[] { "h", "vv", "kp" }, new int[] { 0, 1, 0 }));
    }

    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;

        int currentgroup = groups[0];
        List<String> result = new ArrayList<>();
        result.add(words[0]);

        for (int i = 1; i < n; i++) {
            if (currentgroup == 1 - groups[i]) {
                result.add(words[i]);
                currentgroup = groups[i];
            }
        }
        return result;
    }
}
