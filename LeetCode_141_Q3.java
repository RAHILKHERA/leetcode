import static org.junit.Assert.assertEquals;
import java.util.Map;
import java.util.HashMap;

import org.junit.Test;

public class LeetCode_141_Q3 {

    @Test
    public void test1() {
        assertEquals(1, maxRemovals("abbaa", "aba", new int[] { 0, 1, 2 }));
    }

    public int maxRemovals(String source, String pattern, int[] targetIndices) {

        int n = targetIndices.length;
        Map<Integer, Integer>[] memo = new HashMap[n + 1];
        for (int i = 0; i <= n; i++) {
            memo[i] = new HashMap<>();
        }
        source.indexOf('a', n);
        Map<String, Boolean> subMemo = new HashMap<>();

        return check(new StringBuilder(source), pattern.toCharArray(), targetIndices, 0, 0, memo, subMemo);
    }

    private int check(StringBuilder builder, char[] pattern, int[] targetIndices, int idx, int mask,
            Map<Integer, Integer>[] memo,
            Map<String, Boolean> subMemo) {

        if (idx == targetIndices.length) {
            return 0;
        }

        if (memo[idx].containsKey(mask)) {
            return memo[idx].get(mask);
        }

        // do not del char at idx
        int doNotDel = check(builder, pattern, targetIndices, idx + 1, mask, memo, subMemo);

        // del char at idx
        char ch = builder.charAt(targetIndices[idx]);
        builder.setCharAt(targetIndices[idx], '_');
        int del = 0;

        String checkString = builder.toString();
        if (subMemo.containsKey(checkString)) {
            if (subMemo.get(checkString)) {
                del = 1 + check(builder, pattern, targetIndices, idx + 1, mask | (1 << idx), memo, subMemo);
            }
        } else {
            boolean currentSubSequence = isSubsequence(builder, pattern);
            subMemo.put(checkString, currentSubSequence);

            if (currentSubSequence) {
                del = 1 + check(builder, pattern, targetIndices, idx + 1, mask | (1 << idx), memo, subMemo);
            }
        }

        builder.setCharAt(targetIndices[idx], ch);

        return Math.max(doNotDel, del);
    }

    private boolean isSubsequence(StringBuilder builder, char[] pattern) {

        int i = 0;
        int j = 0;

        while (i < builder.length() && j < pattern.length) {
            if (pattern[j] == builder.charAt(i)) {
                j++;
            }
            i++;
        }

        return j == pattern.length;

    }
}
