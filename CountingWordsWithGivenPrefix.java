import static org.junit.Assert.assertEquals;

import org.junit.Test;

class Node {
    private Node[] children;

    Node() {
        children = new Node[26];
    }

    public boolean contains(char ch) {
        return children[ch - 'a'] != null;
    }

    public void add(char ch, Node node) {
        children[ch - 'a'] = node;
    }

    public Node nextChild(char ch) {
        return children[ch - 'a'];
    }
}

class Trie {

    Node root;

    Trie() {
        root = new Node();
    }

    public void insert(char[] word) {

        Node node = root;
        int n = word.length;
        for (int i = 0; i < n; i++) {
            if (!node.contains(word[i])) {
                node.add(word[i], new Node());
            }
            node = node.nextChild(word[i]);
        }
    }

    public boolean search(char[] word, int len) {

        Node node = root;
        int i = 0;
        while (node != null && i < len) {
            if (!node.contains(word[i])) {
                return false;
            }
            node = node.nextChild(word[i]);
            i++;
        }
        return true;
    }
}

public class CountingWordsWithGivenPrefix {

    @Test
    public void test1() {
        assertEquals(2, prefixCount(new String[] { "pay", "attention", "practice", "attend" }, "at"));
    }

    public int prefixCount(String[] words, String pref) {

        Trie prefix = new Trie();
        prefix.insert(pref.toCharArray());
        int count = 0;
        int len = pref.length();
        for (String word : words) {

            if (word.length() < len)
                continue;

            if (prefix.search(word.toCharArray(), len)) {
                count++;
            }
        }
        return count;
    }
}
