import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class LeetCode_2870_MinimumNumberOfOperationsToMakeArrayEmpty {

    @Test
    public void test() {
        // assertEquals(4, minOperations(new int[] { 2, 3, 3, 2, 2, 4, 2, 3, 4 }));
        // assertEquals(-1, minOperations(new int[] { 2, 1, 2, 2, 3, 3 }));
        assertEquals(8, minOperations(new int[] { 2, 1, 2, 2, 3, 3, 1, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5 }));
    }

    public int minOperations(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int deletions = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            int count = entry.getValue();

            if (count == 1) {
                return -1;
            } else if (count == 2 || count == 3) {
                deletions += 1;
            } else if (count == 4) {
                deletions += 2;
            } else {
                int mod3 = count % 3;
                if (mod3 == 0) {
                    deletions += count / 3;
                } else if (mod3 == 1) {
                    deletions += (count - 4) / 3 + 2;
                } else if (mod3 == 2) {
                    deletions += count / 3 + 1;
                }
            }

        }

        return deletions;
    }

}