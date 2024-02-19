public class LeetCode_242_ValidAnagram {
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        int[] count = new int[26];

        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();

        for (int i = 0; i < sChar.length; i++) {
            count[sChar[i] - 'a']++;
            count[tChar[i] - 'a']--;
        }

        // for (int i = 0; i < s.length(); i++) {
        // count[s.charAt(i) - 'a']++;
        // count[t.charAt(i) - 'a']--;
        // }

        for (int i : count) {
            if (i != 0) {
                return false;
            }
        }

        return true;
    }
}
