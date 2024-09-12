import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class LeetCode_140_WordBreak2 {

    @Test
    public void test1() {
        List<String> expected = new ArrayList<>();
        expected.add("cats and dog");
        expected.add("cat sand dog");

        List<String> words = new ArrayList<>();
        words.add("cat");
        words.add("cats");
        words.add("and");
        words.add("sand");
        words.add("dog");
        assertEquals(expected, wordBreak("catsanddog", words));
    }

    public List<String> wordBreak(String s, List<String> wordDict) {

        List<String> result = new ArrayList<>();
        Map<Character, List<String>> map = new HashMap<>();

        for (String word : wordDict) {
            Character key = word.charAt(0);
            map.computeIfAbsent(key, (ch) -> new ArrayList<>()).add(word);
        }

        helper(s, map, 0, result, new ArrayList<>());

        return result;
    }

    public void helper(String s, Map<Character, List<String>> map, int index, List<String> result,
            List<String> currentWords) {

        if (index == s.length()) {
            StringBuilder builder = new StringBuilder();
            for (String word : currentWords) {
                builder.append(word);
                builder.append(" ");
            }
            result.add(builder.toString().trim());
            return;
        }

        List<String> words = map.get(s.charAt(index));
        if (words == null) {
            // Log when no words are found starting with the current character
            System.out.println("No words found starting with: " + s.charAt(index));
            return; // No words starting with this character, backtrack
        }

        for (String word : words) {
            if (word.length() + index <= s.length()) {
                String subString = s.substring(index, index + word.length());
                if (subString.equals(word)) {
                    currentWords.add(word);
                    helper(s, map, index + word.length(), result, currentWords);
                    currentWords.remove(currentWords.size() - 1);
                }
            }

        }

    }

}
