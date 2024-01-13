import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LeetCode_1347_MinimumNumberOfStepstoMakeTwoStringsAnagram {

    @Test
    public void test1() {
        assertEquals(1, minSteps("bab", "aba"));
        assertEquals(5, minSteps("leetcode", "practice"));
        assertEquals(0, minSteps("anagram", "mangaar"));

    }

    public int minSteps(String s, String t) {

        int[] count = new int[26];
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();

        for (int i = 0; i < tChar.length; i++) {
            count[sChar[i] - 'a']++;
            count[tChar[i] - 'a']--;
        }

        int ans = 0;

        for (int i : count) {
            ans += Math.abs(i);
        }

        ans /= 2;

        return ans;
    }
}
