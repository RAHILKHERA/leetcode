import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class LeetCode_525_ContinuousArray {

    @Test
    public void test1() {
        assertEquals(4, findMaxLength(new int[] { 0, 1, 1, 1, 1, 1, 0, 1, 0, 1 }));
    }

    public int findMaxLength(int[] nums) {
        int res = 0;
        int zero = 0, one = 0;

        // Store diff of one - zero to index.
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 0) {
                zero++;
            } else {
                one++;
            }

            int diff = one - zero;

            if (!map.containsKey(diff)) {
                map.put(diff, i);
            }

            if (one == zero) {
                res = one + zero;
            } else {
                int idx = map.get(diff);
                res = Math.max(res, i - idx);
            }

        }

        return res;
    }
}
