import java.util.Arrays;

public class LeetCode_91_DecodeWays {

    public static void main(String[] args) {
        new LeetCode_91_DecodeWays().numDecodings("10");
    }

    public int numDecodings(String s) {

        int n = s.length();

        int[] dp = new int[n + 1];

        Arrays.fill(dp, -1);

        dp[n] = countWays(s, dp, 0);

        return dp[n];
    }

    private int countWays(String s, int[] dp, int i) {

        if (dp[i] != -1) {
            return dp[i];
        }

        if (i == s.length()) {
            return 1;
        }

        if (s.charAt(i) == '0') {
            return 0;
        }

        dp[i] = countWays(s, dp, i + 1);

        if (i + 1 < s.length() && Integer.parseInt(s.substring(i, i + 2)) <= 26) {

            dp[i] += countWays(s, dp, i + 2);
        }

        return dp[i];
    }
}
