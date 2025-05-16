package Week20_2025;

/**
     * @RAHILKHERA
     * 
     * LeetCode Problem: 2901. Longest Unequal Adjacent Groups Subsequence II
     * Problem Link: https://leetcode.com/problems/longest-unequal-adjacent-groups-subsequence-ii/description/?envType=daily-question&envId=2025-05-16
     *
     * Input :
     *  - String array  : words.
     *  - Integer array : groups.  
     * 
     * Constraints:
     * 1 <= n == words.length == groups.length <= 1000
     * 1 <= words[i].length <= 10
     * 1 <= groups[i] <= n
     * words consists of distinct strings.
     * words[i] consists of lowercase English letters.
     * 
     * Definition : Valid subsequence. 
     *  - Two adjacent elements of the subsequence should not belong to the same group. 
     *  - Two adjacent elements of the subsequence should have equal lengths. 
     *  - Two adjacent elements should have hamming distance equal to 1. 
     *  - Hamming distance = number of positions in which two strings are not same. 
     * 
     * Task: Generate list of the words which forms the largest valid subsequence. If multiple lists are available return any.  
     *
     * Observations: 
     * #1. This problem is extension to LeetCode 2900. That problem was solved using greedy approach. 
     *     => In this case greedy approach will fail. 
     *     => Unlike 2900, here groups array is not binary.  Hence there are multiple options. 
     *     => Also it asks for the words from largest group, i.e. a type of optimization. 
     *     => All this points to dynamic programming approach.    
     * #2. This problem can be divided into two subproblems.
     *     => 1. Get one of the largest subsequences which satisfies all the conditions. 
     *     => 2. Generate the list of all the words which contributed in creation of the above subsequence. 
     * #3. This problem can be repharshed as follows :
     *     => 1. Find the Longest Subsequence satisfying the conditions. 
     *     => 2. Create list of elements contributing to longest subsequence. 
     * #4. Here classic template of LIS, longest increasing subsequence length and actual subsequence can be used.
     *     => Here instead of checking whether in the past a smaller element was there, we have to check all the mentioned conditions. 
     * #5. To generate the list, keep an array to store the index, using which the subsequence was extended to current index. 
     *     => Using this index, backtrack from this index till last possible index and create the list of the words. 
     *     => As the above traversal, is in the reverse direction, reverse the list to obtain the final list. 
     * 
     * Approach:
     * 1. Use two integer arrays of size n, one dp and another prev.
     *    => dp[idx] = length of the largest subsequence ending at index `idx`. 
     *    => prev[idx] = index of the element from which the largest subsequence ending at idx was extended to index idx.
     * 2. Intially fill dp with 1 and prev with -1. 
     *    => dp with 1 : As all the elements are in itself valid subsequence. Hence minimum length will be 1. 
     *    => prev with -1 : As there is no valid previous index of the subsequence. Let's fill it with an invalid sequence. 
     * 3. Two pointers, i and j.
     *    => For current element words[i], check if there exists words[j] which satisfies following conditions :
     *    => 0 <= j < i. 
     *    => groups[i] != groups[j].
     *    => words[i].length ==  words[j].length. 
     *    => hammingDistance(words[i], words[j]) == 1. 
     *    => Also add the condition of dp[j] + 1 > dp[i] before checking for hammingDistance. 
     *    => As hamming distance check is computational intensive. 
     *    => dp[j] + 1 > dp[i] implies that a larger subsequence ending at `j` can be extended till `i`. 
     *    => Although all the conditions are compulsory i.e and operation between each condition, 
     *       but arranging them in order of time intensive at last will affect overall execution time. 
     * 4. If all the conditions satisfy from #3, 
     *    => dp[i] = dp[j] + 1 i.e. increase length of the subsequence ending at `i`. It will be one more than ending at `j`. As element at `i` is included. 
     *    => prev[i] = j. i.e. the subsequence was extended to `i` through element at `j` i.e. previously the sequence end at words[j] but now it will end at words[i].
     *    => Also keep the track of max index, that is the index where the largest subsequence ended. 
     * 5. Using prev, rebuild the list of the words which contributed to the largest subsequence. 
     *    => maxIndex represents last index of the sequence. 
     *    => Backtrack and traverse till the last valid index and add the words to the result list. 
     *    => At every iteration nextIndex = prev[idx], where idx is current idx. starting from maxIndex. 
     *    => This will generate sub sequence in reverse order. So reverse the resultant list. 
     * 
     * Hamming distance :
     * 1. Already both the strings are of the same length, this was checked before calling the function. 
     * 2. Traverse from the first char through the length of the string. 
     * 3. Keep track where character does not match in the both the strings this is the hamming distance (diff). 
     * 4. For early pruning, if diff gets more than 1 return false, no need to traverse remaining strings. 
     *   
     * Time Complexity: O(N^2*L)
     *      - There are two nested loops. 
     *      - 0 <= i < N
     *      - 0 <= j < i
     *      - To check the hamming distance O(L) : L length of the word. 
     *      - In worst case, For each comination of (i,j), hamming distance function may be called.  
     *      - N = array of length. 
     *      - Final Complexity = O(N * N *L) = O(N^2 * L).
     *          
     * Space Complexity: O(N)
     *      - Two integer arrays dp and prev of size N are used. 
     *      - Final Complexity = O(2N) => O(N).
     */

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class LeetCode_2901_LongestUnequalAdjacentGroupsSubsequenceII {

    @Test
    public void test1() {
        assertEquals(Arrays.asList("bab", "dab"),
                getWordsInLongestSubsequence(new String[] { "bab", "dab", "cab" }, new int[] { 1, 2, 2 }));
    }

    @Test
    public void test2() {
        assertEquals(Arrays.asList("a", "b", "c", "d"),
                getWordsInLongestSubsequence(new String[] { "a", "b", "c", "d" }, new int[] { 1, 2, 3, 4 }));
    }

     @Test
    public void test3() {
        assertEquals(Arrays.asList("abbbb"),
                getWordsInLongestSubsequence(new String[] { "abbbb" }, new int[] { 1}));
    }

    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;
        // dp[i] = length of largest subsequence ending at index i.
        int[] dp = new int[n];
        // prev[i] = index of the previous element of subsequence ending at index i.
        int[] prev = new int[n];
        // Minimum length of largest subsequence is 1, the element itself.
        Arrays.fill(dp, 1);
        // No previous index, so starting with an invalid index -1.
        Arrays.fill(prev, -1);

        int maxLength = 1, maxIndex = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (groups[i] != groups[j]
                        && dp[j] + 1 > dp[i]
                        && words[i].length() == words[j].length()
                        && isHammingDistanceEqualOne(words[i], words[j])) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                    if (maxLength < dp[i]) {
                        maxLength = dp[i];
                        maxIndex = i;
                    }
                }
            }
        }

        List<String> result = new ArrayList<>();
        for (int i = maxIndex; i >= 0; i = prev[i]) {
            result.add(words[i]);
        }

        Collections.reverse(result);
        return result;
    }

    private boolean isHammingDistanceEqualOne(String word1, String word2) {
        int diff = 0;
        for (int pos = 0; pos < word1.length(); pos++) {
            if (word1.charAt(pos) != word2.charAt(pos)) {
                if (++diff > 1) {
                    return false;
                }
            }
        }
        return diff == 1;
    }
}
