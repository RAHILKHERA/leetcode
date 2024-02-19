import java.util.Arrays;

public class LeetCode_1143_LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {

        int len1 = text1.length();
        int len2 = text2.length();

        char[] charArray1 = text1.toCharArray();
        char[] charArray2 = text2.toCharArray();

        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i = len1 - 1; i >= 0; i--) {

            for (int j = len2 - 1; j >= 0; j--) {

                if (charArray1[i] == charArray2[j]) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }

        /*
         * if (charArray1[i] == charArray2[j]) {
         * 
         * dp[i][j] = 1 + search(i+1, j+1);
         * 
         * } else {
         * dp[i][j] = Math.max(search(i+1,j), search(i, j+1));
         * }
         * 
         * 
         * 
         */

        return dp[0][0];
    }

    public int longestCommonSubsequence(String text1, String text2, boolean topDown) {

        int len1 = text1.length();
        int len2 = text2.length();

        char[] charArray1 = text1.toCharArray();
        char[] charArray2 = text2.toCharArray();

        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int[] is : dp) {
            Arrays.fill(is, -1);
        }

        search(charArray1, charArray2, len1, len2, 0, 0, dp);

        // for (int i = len1 - 1; i >= 0; i--) {

        // for (int j = len2 - 1; j >= 0; j--) {

        // if (charArray1[i] == charArray2[j]) {
        // dp[i][j] = 1 + dp[i + 1][j + 1];
        // } else {
        // dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
        // }
        // }
        // }

        /*
         * if (charArray1[i] == charArray2[j]) {
         * 
         * dp[i][j] = 1 + search(i+1, j+1);
         * 
         * } else {
         * dp[i][j] = Math.max(search(i+1,j), search(i, j+1));
         * }
         * 
         * 
         * 
         */

        return dp[0][0];
    }

    private int search(char[] charArray1, char[] charArray2, int len1, int len2, int i, int j, int[][] dp) {

        if (i >= len1 || j >= len2) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (charArray1[i] == charArray2[j]) {
            dp[i][j] = 1 + search(charArray1, charArray2, len1, len2, i + 1, j + 1, dp);
        } else {
            dp[i][j] = Math.max(search(charArray1, charArray2, len1, len2, i + 1, j, dp),
                    search(charArray1, charArray2, len1, len2, i, j + 1, dp));
        }
        return dp[i][j];
    }
}
