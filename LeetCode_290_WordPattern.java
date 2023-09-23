import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.Map;
import java.util.HashMap;

public class LeetCode_290_WordPattern {
    public static void main(String[] args) {

        Solution_LeetCode_290_WordPattern solution = new Solution_LeetCode_290_WordPattern();

        System.out.println("Testing...");
        assertTrue(solution.wordPattern("abba", "dog cat cat dog"));
        System.out.println("Test case 1 passed");
        assertFalse(solution.wordPattern("abba", "dog cat cat fish"));
        System.out.println("Test case 2 passed");
        assertFalse(solution.wordPattern("aaaa", "dog cat cat dog"));
        System.out.println("Test Case 3 passed");

    }
}

class Solution_LeetCode_290_WordPattern {
    public boolean wordPattern(String pattern, String s) {

        //Generating all the words from string s. 
        String[] words = s.split(" ");
        Map<Character, String> map = new HashMap<Character, String> ();


        // Each letter from patter should match with each word in the string s.
        if (words.length != pattern.length()) {
            return false; 
        }

        for (int i = 0; i < pattern.length(); i++) {

            char ch = pattern.charAt(i);
            if (map.containsKey(ch)) {
                if (!map.get(ch).equals(words[i])) {
                       return false; 
                }

            } else if (map.containsValue(words[i])) {
                return false; 
            } else {
                map.put(ch, words[i]);
            }


        }
        return true;
        
    }
}
