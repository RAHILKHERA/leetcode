import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class LeetCode_2416_SumofPrefixScoresofStrings {

    @Test
    public void test1() {
        assertArrayEquals(new int[] { 5, 4, 3, 2 }, sumPrefixScores(new String[] { "abc", "ab", "bc", "b" }));
    }

    public int[] sumPrefixScores(String[] words) {

        Tire tire = new Tire();

        for (String word : words) {
            tire.insert(word);
        }

        int[] result = new int[words.length];
        int index = 0;
        for (String word : words) {
            result[index++] = tire.search(word);
        }

        return result;

    }

    class TireNode {
        int count;
        TireNode[] children;

        TireNode() {
            this.children = new TireNode[26];
        }
    }

    class Tire {

        TireNode root;

        Tire() {
            this.root = new TireNode();
        }

        void insert(String word) {

            TireNode node = root;

            for (char ch : word.toCharArray()) {

                int idx = ch - 'a';
                if (node.children[idx] == null) {
                    node.children[idx] = new TireNode();
                }
                node.children[idx].count++;
                node = node.children[idx];

            }
        }

        int search(String word) {

            TireNode node = root;

            int prefix = 0;
            for (char ch : word.toCharArray()) {

                int idx = ch - 'a';

                if (node.children[idx] == null) {
                    return prefix;
                }

                prefix += node.children[idx].count;

            }
            return prefix;
        }

    }
}
