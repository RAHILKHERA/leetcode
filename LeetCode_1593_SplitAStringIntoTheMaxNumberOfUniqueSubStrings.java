import java.util.Set;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;

public class LeetCode_1593_SplitAStringIntoTheMaxNumberOfUniqueSubStrings {

    @Test
    public void test1() {
        assertEquals(5, maxUniqueSplit("ababccc"));
    }

    public int maxUniqueSplit(String s) {

        return dfs(s, 0, new HashSet<>());
    }

    private int dfs(String s, int idx, Set<String> set) {

        int n = s.length();

        if (idx == n) {
            return set.size();
        }

        int maxSplit = Integer.MIN_VALUE;

        for (int i = idx; i < n; i++) {
            String currentSubstr = s.substring(idx, i + 1);
            if (!set.contains(currentSubstr)) {
                set.add(currentSubstr);
                maxSplit = Math.max(maxSplit, dfs(s, i + 1, set));
                set.remove(currentSubstr);
            }
        }

        return maxSplit;

    }
}
