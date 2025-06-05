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
 * #4. The following points indicate the use of DisjointSet:
 *     => Groups.
 *     => Group Leader.
 *     => Merging of Groups.
 *
 * Approach:
 * 1. Implement DisjointSet class:
 *     => The parent array will be of size 26 as the strings are only lowercase English letters.
 *        -> Initially, each character will be in its own group and be the group leader.
 *        -> During transformation, the character is required, hence the value of the parent array will represent a character.
 *     => The find operation should be implemented with path compression.
 *        -> Only the first time, the group leader needs to be resolved for all the members on the path.
 *        -> This improves performance, as when the next time the group leader for a particular member is required, it can be fetched in O(1).
 *     => Union operation: For combining two groups,
 *        -> If the group leader/parent of both characters is the same, no need to perform any operation.
 *        -> The group having the bigger parent value will be merged into the group having the smaller parent value.
 * 2. For each index idx, perform union between the pair s1[idx] and s2[idx].
 * 3. For each character of baseStr, find the group they belong to, and append to the string builder.
 * 4. The final string will be present in the builder.
 *
 * Time Complexity: O(Nα(n))
 *
 * |                       Component                            |                Time               |
 * | ---------------------------------------------------------- |---------------------------------- |
 * |  find(x) with path compression                             |           O(α(n)) amortized       |
 * |  union(x, y)                                               |           O(α(n)) amortized       |
 * |  initialization n = 26                                     |           O(1)                    |
 * |  Grouping and transformation                               |           O(Nα(n))                |
 * |                                                            | N = n + m, where n = length of s1 |
 * |                                                            |  and s2 and m = length of baseStr.|
 * |------------------------------------------------------------|-----------------------------------|
 * | Total Complexity                                           |            O(Nα(n))               |
 *
 * Space Complexity: O(1)
 * |                        Component                           |                  Space            |
 * | ---------------------------------------------------------- |---------------------------------- |
 * | Parent 1D integer array of 26 is used.                     |            O(26)  => O(1)         |
 * |----------------------------------------------------------- |-----------------------------------|
 * | Total Complexity                                           |            O(1)                   |
 *
 */


import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LeetCode_1061_LexicographicallySmallestEquivalentString_ApproachUnion {


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
        assertEquals("aauaaaaada", smallestEquivalentString("leetcode","programs","sourcecode"));
    }

    @Test
    public void test4() {
        assertEquals("auqpqxmnajphtiserneattymtrydomxnwonfhfjlzzrfhosjct",
                smallestEquivalentString("aabbbabbbbbabbbbaabaabbaaabbbabaababaaaabbbbbabbaa",
                        "aabbaabbbabaababaabaababbbababbbaaaabbbbbabbbaabaa",
                        "buqpqxmnajphtisernebttymtrydomxnwonfhfjlzzrfhosjct"
        ));
    }


    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int n = s1.length();
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
        char[] baseChar = baseStr.toCharArray();
        StringBuilder builder = new StringBuilder();
        DisjointSet disjointSet = new DisjointSet();

        for (int idx = 0; idx < n; idx++) {
            disjointSet.union(ch1[idx] - 'a', ch2[idx] - 'a');
        }

        for (int idx = 0; idx < baseChar.length; idx++) {
            char groupLeader = (char) (disjointSet.find(baseChar[idx] - 'a') + 'a');
            builder.append(groupLeader);
        }

        return builder.toString();

    }
    
    private class DisjointSet {
    
        private int[] parent;

        DisjointSet() {
            parent = new int[26];
            for (int i = 0; i < 26; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (parent[x] == x) {
                return x;
            }

            int root = find(parent[x]);
            int current = x;
            while (current != root) {
                int next = parent[current];
                parent[current] = root;
                current = next;
            }
            return root;
        }

        public void union(int u, int v) {
            int parentU = find(u);
            int parentV = find(v);
            
            if (parentU == parentV) {
                return;
            }


            if (parentU < parentV) {
                parent[parentV] = parentU;   
            } else {
                parent[parentU] = parentV;
            }
        }
    }
}
