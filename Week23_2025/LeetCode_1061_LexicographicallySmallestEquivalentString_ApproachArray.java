package Week23_2025;

/**
 * @RAHILKHERA
 *
 * LeetCode Problem: 1061 Lexicographically Smallest Equivalent String. 
 * 
 * Problem Link:
 * https://leetcode.com/problems/lexicographically-smallest-equivalent-string/description/?envType=daily-question&envId=2025-06-05
 * 
 * Input:
 * - String s1
 * - String s2
 * - String baseStr
 * 
 * Constraints:
 * 1 <= s1.length, s2.length, baseStr <= 1000
 * s1.length == s2.length
 * s1, s2, and baseStr consist of lowercase English letters.
 *            
 * Definition: s1[i] and s2[i] are equivalent characters.
 * For example, if s1 = "abc" and s2 = "cde", then we have 'a' == 'c', 'b' == 'd', and 'c' == 'e'. ---------- Equation (1)
 * Equivalent characters follow the usual rules of any equivalence relation:
 * Reflexivity: 'a' == 'a'.
 * Symmetry: 'a' == 'b' implies 'b' == 'a'.
 * Transitivity: 'a' == 'b' and 'b' == 'c' implies 'a' == 'c'.
 * 
 * Task: Compute the lexicographically smallest equivalent string of baseStr by using the equivalency information from s1 and s2. 
 * 
 * Observations:
 * #1. The characters at the same positions in strings s1 and s2 form the equivalence relation. 
 *     => If characters are connected by an equivalence relation, then they can be replaced by each other to generate an equivalent string. 
 *     => From the above example, "acd" and "aab" are equivalent strings for baseStr = "eed" from equation 1.
 *     => All the characters bound by a single equivalence relation can be combined in a single group. 
 *     => For the above example, (a, c, e) and (b, d) will make two groups. 
 * #2. The requirement is to get the lexicographically smallest equivalent string of baseStr. 
 *     => The length of the two equivalent strings is the same. Hence, for this case, to find the lexicographically smallest, length will not come into the picture.
 *     => If the group of characters is replaced by the smallest character present in the group, the task can be achieved. 
 *     => The group leader will be the smallest character of the group. 
 * #3. For example, there are two groups, (a, b) and (c, d),
 *     => for index idx, s1[idx] = `b` and s2[idx] = `d`. 
 *     => Here b is in a group with group leader `a` and d is in a group with group leader `c`. 
 *     => Both the groups need to be merged to maintain the `b` == `d` equivalence relation. 
 *     => The group with the bigger leader should be merged into the group with the smaller leader. 
 *     => After merge (a, b, c, d) where `a` is the group leader. 
 *
 * Data Structure:
 * groups: 1D array of size 26, to store the group of each character. Initialize it by -1 (character does not belong to any group.)
 * groupId: An integer variable, identification to distinguish the groups. 
 * groupLeader: A map of groupId vs lowest character in each group. 
 *    
 * Approach:
 * 1. Grouping and Merging, for each character in s1 and s2 at index `idx`:
 *  => If both the characters are not part of any group, assign both of them the current groupId and increase the groupId. So it can be assigned to another possible group. 
 *  => If one of the characters is part of a group, assign the character not having the group to the group of the other character. 
 *  => If both the characters are part of different groups, then merge both groups. 
 *   -> Change the groupId of each of the members of the group with the bigger parent to the groupId of the lower value parent/group leader.
 * 
 * 2. For each character in baseStr, 
 *    -> Find the groupId of the character from the groups array. 
 *    -> If it is -1, then append the character as it is. 
 *    -> Else, find the group leader from the groupLeader map. 
 *    -> Append the group leader to the string buffer. 
 * 
 * 3. Convert the string buffer to a string. This is the target equivalent string.     
 * 
 *    
 * Time Complexity: O(N)  
 *             
 * |                       Component                            |                Time               |
 * | ---------------------------------------------------------- |---------------------------------- |
 * |  Grouping and Merging                                      |      O(26n) => O(n)               |
 * |   -> In worst case, for each character of s1 and s2        |                                   |
 * |      groups will be merged. Each merge requires looping     |                                   |    
 * |      over all 26 characters.                               |                                   |
 * |  Group Leader                                              |       O(26) => O(1)               |
 * |  Transformation, m = number of characters in baseStr       |       O(m)                        |
 * |------------------------------------------------------------|-----------------------------------|
 * |                  Total Complexity                          |   O(26n + 26 + m) => O(n + m)     |
 * 
 * 
 * Space Complexity: O(1)
 * |                        Component                           |                  Space            |
 * | ---------------------------------------------------------- |---------------------------------- |
 * | 1D integer array of groups of size 26                      |            O(26)  => O(1)         |
 * | Group Leader hashmap, one group for each character         |            O(26)                  |
 * |----------------------------------------------------------- |-----------------------------------|
 * | Total Complexity                                           |   O(26 + 26) => O(52) => O(1)     |
 *
 */

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class LeetCode_1061_LexicographicallySmallestEquivalentString_ApproachArray {

    @Test
    public void test1() {
        assertEquals("makkek", smallestEquivalentString("parker", "morris", "parser"));
    }

    @Test
    public void test2() {
        assertEquals("hdld", smallestEquivalentString("hello", "world", "hold"));
    }

    @Test
    public void test3() {
        assertEquals("aauaaaaada", smallestEquivalentString("leetcode", "programs", "sourcecode"));
    }

    @Test
    public void test4() {
        assertEquals("auqpqxmnajphtiserneattymtrydomxnwonfhfjlzzrfhosjct",
                smallestEquivalentString("aabbbabbbbbabbbbaabaabbaaabbbabaababaaaabbbbbabbaa",
                        "aabbaabbbabaababaabaababbbababbbaaaabbbbbabbbaabaa",
                        "buqpqxmnajphtisernebttymtrydomxnwonfhfjlzzrfhosjct"));
    }

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int n = s1.length();
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
        char[] baseChar = baseStr.toCharArray();
        StringBuilder builder = new StringBuilder();

        int groupId = 0;
        int[] groups = new int[26];
        Arrays.fill(groups, -1);
        Map<Integer, Integer> groupLeader = new HashMap<>();

        for (int idx = 0; idx < n; idx++) {
            int groupA = groups[ch1[idx] - 'a'];
            int groupB = groups[ch2[idx] - 'a'];
            if (groupA == -1 && groupB == -1) {
                groups[ch1[idx] - 'a'] = groupId;
                groups[ch2[idx] - 'a'] = groupId;
                groupId++;
            } else if (groupA == -1) {
                groups[ch1[idx] - 'a'] = groups[ch2[idx] - 'a'];
            } else if (groupB == -1) {
                groups[ch2[idx] - 'a'] = groups[ch1[idx] - 'a'];
            } else if (ch1[idx] < ch2[idx]) {
                for (int i = 0; i < 26; i++) {
                    if (groups[i] == groupB) {
                        groups[i] = groupA;
                    }
                }
            } else if (ch2[idx] < ch1[idx]) {
                for (int i = 0; i < 26; i++) {
                    if (groups[i] == groupA) {
                        groups[i] = groupB;
                    }
                }
            }
        }

        for (int i = 0; i < 26; i++) {
            if (groups[i] != -1) {
                final int idx = i;
                groupLeader.computeIfAbsent(groups[i], key -> idx);
            }
        }

        for (int idx = 0; idx < baseChar.length; idx++) {
            char ch = baseChar[idx];
            groupId = groups[ch - 'a'];
            if (groupId == -1) {
                builder.append(ch);
            } else {
                builder.append((char) (groupLeader.get(groupId) + 'a'));
            }
        }

        return builder.toString();

    }
}
