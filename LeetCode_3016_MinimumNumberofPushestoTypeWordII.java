import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class LeetCode_3016_MinimumNumberofPushestoTypeWordII {

    @Test
    public void test1() {
        assertEquals(5, minimumPushes("abcde"));
    }

    public int minimumPushes(String word) {

        int[] map = new int[26];
        char[] wordArray = word.toCharArray();

        for (char ch : wordArray) {
            map[ch - 'a']++;
        }

        Arrays.sort(map);

        int pushes = 1;
        int start = 0;
        int minimumPushes = 0;

        for (int i = 25; i >= 0; i--) {

            minimumPushes += pushes * map[i];
            start++;

            if (start == 8) {
                start = 0;
                pushes++;
            }
        }

        return minimumPushes;
    }
}
