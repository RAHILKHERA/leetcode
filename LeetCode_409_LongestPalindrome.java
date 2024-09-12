public class LeetCode_409_LongestPalindrome {
    public int longestPalindrome(String s) {

        int result = 0;
        boolean hasOddFrequency = false;
        int[] lower = new int[26];
        int[] upper = new int[26];

        for (char ch : s.toCharArray()) {

            if (ch >= 'a' && ch <= 'z') {
                lower[ch - 'a']++;
            } else {
                upper[ch - 'A']++;
            }
        }

        for (int i = 0; i < 26; i++) {

            if (lower[i] > 0) {
                if (lower[i] % 2 == 0) {
                    result += lower[i];
                } else {
                    result += lower[i] - 1;
                    hasOddFrequency = true;
                }
            }

            if (upper[i] > 0) {
                if (upper[i] % 2 == 0) {
                    result += upper[i];
                } else {
                    result += upper[i] - 1;
                    hasOddFrequency = true;
                }
            }

        }

        if (hasOddFrequency) {
            return result + 1;
        }

        return result;
    }
}
