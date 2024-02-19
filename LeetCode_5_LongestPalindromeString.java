import java.util.Arrays;

import org.junit.Test;

public class LeetCode_5_LongestPalindromeString {

    @Test
    public void test() {
        System.out.println(longestPalindrome("ccc"));
    }

    @Test
    public void test1() {
        System.out.println(longestPalindrome("aacabdkacaa"));
    }

    @Test
    public void test2() {
        System.out.println(longestPalindrome("babad"));
    }

    @Test
    public void test3() {
        System.out.println(longestPalindrome("cbbd"));
    }

    int max = -1, maxI = 0, maxJ = 0;

    public String longestPalindrome(String s) {

        int n = s.length();
        int[][] dp = new int[n][n];

        for (int[] is : dp) {
            Arrays.fill(is, -1);
        }

        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = 1;
        }

        search(s.toCharArray(), 0, s.length() - 1, dp);

        // for (int i = 0; i < dp.length; i++) {
        // for (int j = i + 1; j < dp[0].length; j++) {
        // if (dp[i][j] == 1) {
        // if (max < j - i + 1) {
        // max = j - i + 1;
        // maxI = i;
        // maxJ = j;
        // }
        // }
        // }
        // }

        return s.substring(maxI, maxJ + 1);

    }

    private int search(char[] charArray, int i, int j, int[][] dp) {

        if (i >= charArray.length || j < 0) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (charArray[i] != charArray[j]) {
            dp[i][j] = 0;
            dp[j][i] = 0;
            search(charArray, i + 1, j, dp);
            search(charArray, i, j - 1, dp);

        } else {

            int isRemainingPalindrome = j - i > 1 ? search(charArray, i + 1, j - 1, dp) : 1;
            if (isRemainingPalindrome == 1) {
                dp[i][j] = 1;
                dp[j][i] = 1;
                setMaxIndices(i, j);
            } else {
                dp[i][j] = 0;
                dp[j][i] = 0;
                search(charArray, i + 1, j, dp);
                search(charArray, i, j - 1, dp);
            }
        }
        return dp[i][j];
    }

    public void setMaxIndices(int i, int j) {

        if (max < Math.abs(j - i) + 1) {
            max = Math.abs(j - i) + 1;
            if (i < j) {
                maxI = i;
                maxJ = j;
            } else {
                maxI = j;
                maxJ = i;
            }

        }
    }
}
