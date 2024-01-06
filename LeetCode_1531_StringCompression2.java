import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class LeetCode_1531_StringCompression2 {

    @Test
    public void testCase1() {

        assertEquals(4, getLengthOfOptimalCompression("aaabcccd", 2));
    }

    public int getLengthOfOptimalCompression(String s, int k) {

        int n = s.length();

        if (k == n) {
            return 0;
        }

        int dp[][] = new int[k + 1][n];
        String prev[][] = new String[k + 1][n];
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < prev[0].length; i++) {
            prev[0][i] = s;
            dp[0][i] = n;
        }

        for (int i = 1; i < prev.length; i++) {
            for (int j = 0; j < prev[0].length; j++) {
                prev[i][j] = getDeletedString(prev[i - 1][j], j);
                if (prev[i][j] == null) {
                    dp[i][j] = -1;
                } else if (!map.containsKey(prev[i][j])) {
                    dp[i][j] = getStringEncodingLength(prev[i][j]);
                    map.put(prev[i][j], dp[i][j]);
                } else {
                    dp[i][j] = map.get(prev[i][j]);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = k; i < dp[k].length; i++) {
            if (dp[k][i] != -1 && dp[k][i] < min) {
                min = dp[k][i];
            }
        }
        return min;
    }

    private int getStringEncodingLength(String s) {

        StringBuilder builder = new StringBuilder();
        int count = 1;
        for (int i = 1; i <= s.length(); i++) {
            if (i == s.length() || s.charAt(i) != s.charAt(i - 1)) {
                builder.append(s.charAt(i - 1));
                if (count > 1) {
                    builder.append(count);
                }
                count = 1;
            } else {
                count++;
            }
        }

        return builder.toString().length();
    }

    private String getDeletedString(String s, int index) {

        if (index >= s.length()) {
            return null;
        }

        StringBuilder builder = new StringBuilder();

        builder.append(s.substring(0, index));
        builder.append(s.substring(index + 1, s.length()));

        return builder.toString();
    }

}