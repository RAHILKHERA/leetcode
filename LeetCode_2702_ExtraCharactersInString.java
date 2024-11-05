import java.util.Set;

import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

public class LeetCode_2702_ExtraCharactersInString {

    @Test
    public void test1() {
        assertEquals(1, minExtraChar("leetscode", new String[] { "leet", "code", "leetcode" }));
    }

    public int minExtraChar(String s, String[] dictionary) {

        Set<String> set = new HashSet<>(Arrays.asList(dictionary));
        int n = s.length();
        int[] dp = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {

            // Escape the current character.
            dp[i] = 1 + dp[i + 1];

            // Check if the substring starting with the current character existis in the
            // dictionary.

            for (int j = i; j < n; j++) {

                String substring = s.substring(i, j + 1);
                if (set.contains(substring)) {
                    dp[i] = Math.min(dp[i], dp[j + 1]);
                }

            }

        }

        return dp[0];
    }

    private int solve(String s, Set<String> dic, int i, int n) {

        if (i >= n) {
            return 0;
        }

        // Escape the current char;
        int result = 1 + solve(s, dic, i + 1, n);

        // Check if the substring starting from current char is present in dict.

        for (int j = i; j < n; j++) {

            String substring = s.substring(i, j + 1);
            if (dic.contains(substring)) {
                result = Math.min(result, solve(s, dic, j + 1, n));
            }

        }

        return result;
    }
}
