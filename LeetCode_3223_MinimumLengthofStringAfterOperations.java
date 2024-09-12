import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class LeetCode_3223_MinimumLengthofStringAfterOperations {

    @Test
    public void test1() {

        assertEquals(5, minimumLength("abaacbcbb"));

    }

    public int minimumLength(String s) {

        Map<Character, List<Integer>> map = new HashMap<>();
        char[] charArray = s.toCharArray();
        int n = s.length();

        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(charArray[i], key -> new ArrayList<>()).add(i);
        }

        int deletedCharsCount = 0;
        for (Map.Entry<Character, List<Integer>> entry : map.entrySet()) {

            int indexSize = entry.getValue().size();

            if (indexSize >= 3) {

                if (indexSize % 2 == 0) {
                    deletedCharsCount += indexSize - 2;
                } else {
                    deletedCharsCount += indexSize - 1;
                }
            }
        }
        return n - deletedCharsCount;
    }
}
