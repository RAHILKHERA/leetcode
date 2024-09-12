public class LeetCode_2370_LongestIdealSubsequence {
    public int longestIdealString(String s, int k) {

        /**
         * Dynamic Programming
         * !important
         * https://www.youtube.com/watch?v=01nYV8eqxm8&t=2s&ab_channel=codestorywithMIK
         */

        int N = s.length();
        int[] dp = new int[26];
        int result = 0;

        for (int i = 0; i < N; i++) {

            int idx = s.charAt(i) - 'a';
            int left = Math.max(0, idx - k);
            int right = Math.min(25, idx + k);
            int longest = 0;

            for (int j = left; j <= right; j++) {
                longest = Math.max(longest, dp[j]);
            }

            dp[idx] = Math.max(dp[idx], longest + 1);
            result = Math.max(result, dp[idx]);
        }
        return result;
    }

}
