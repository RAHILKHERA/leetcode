import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LeetCode_421_MaximumXORofTwo {

    @Test
    public void test1() {
        assertEquals(28, findMaximumXOR(new int[] { 3, 10, 5, 25, 2, 8 }));
    }

    @Test
    public void test2() {
        assertEquals(127, findMaximumXOR(new int[] { 14, 70, 53, 83, 49, 91, 36, 80, 92, 51, 66, 70 }));
    }

    public int findMaximumXOR(int[] nums) {

        Trie tire = new Trie();
        for (int num : nums) {
            tire.insert(num);
        }

        int maxXor = 0;

        for (int num : nums) {
            maxXor = Math.max(maxXor, tire.search(num));
        }

        return maxXor;
    }

    class Trie {

        TrieNode root;

        Trie() {
            this.root = new TrieNode();
        }

        void insert(int num) {

            TrieNode node = root;

            for (int i = 31; i >= 0; i--) {

                int ithBit = (num >> i) & 1;

                if (ithBit == 0) {

                    if (node.left == null) {
                        node.left = new TrieNode();
                    }
                    node = node.left;
                } else {

                    if (node.right == null) {
                        node.right = new TrieNode();
                    }
                    node = node.right;
                }

            }
        }

        int search(int num) {

            TrieNode node = root;
            int xorNumber = 0;
            for (int i = 31; i >= 0; i--) {

                int ithBit = (num >> i) & 1;

                if (ithBit == 0) {

                    if (node.right != null) {
                        xorNumber |= (1 << i);
                        node = node.right;
                    } else if (node.left != null) {
                        node = node.left;
                    } else {
                        break;
                    }
                } else {
                    if (node.left != null) {
                        node = node.left;
                    } else if (node.right != null) {
                        xorNumber |= (1 << i);
                        node = node.right;
                    } else {
                        break;
                    }
                }
            }
            return num ^ xorNumber;
        }
    }

    class TrieNode {

        TrieNode left;
        TrieNode right;

        TrieNode() {

        }
    }
}
