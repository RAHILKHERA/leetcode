import static org.junit.Assert.assertEquals;

public class LeetCode_389_FindTheDifference {
    
    public static void main(String[] args) {
        assertEquals('e', new Solution_LeetCode_389_FindTheDifference().fintTheDifference("abcd", "abcde"));
    }
}

class Solution_LeetCode_389_FindTheDifference {

    public char fintTheDifference(String s, String t) {
        //char ch ='\0';
        
        int [] chCount = new int [26];

        for (int i =0; i < s.length(); i++) {
            char ch = s.charAt(i);
            chCount[ch - 'a']++;
        }

        for (int i =0; i < t.length(); i++) {
            char ch = t.charAt(i);
            chCount[ch - 'a']--;

            if (chCount[ch - 'a'] == -1) {
                return ch; 
            }
        }

        return '\0';  
    }
}
