public class LeetCode_2108_FindFirstPalindromicStringInArray {
    public String firstPalindrome(String[] words) {

        for (String word : words) {
            if (isPalindrome(word)) {
                return word;
            }
        }

        return "";
    }

    private boolean isPalindrome(String word) {

        int len = word.length();

        int left = 0, right = len/2;

        if (len % 2 == 0) {
            left = right - 1;
        } else {
            left = right;
        }

        while (left >= 0 && right < len) {
            if (word.charAt(left) != word.charAt(right)) {
                return false;
            }
            left--;
            right++;
        }
        return true;
    }
}
