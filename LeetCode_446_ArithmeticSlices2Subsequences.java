import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class LeetCode_446_ArithmeticSlices2Subsequences {

    @Test
    public void test() {
        assertEquals(7, numberOfArithmeticSlices(new int[] { 2, 4, 6, 8, 10 }));
    }

    public int numberOfArithmeticSlices(int[] nums) {

        int ans = 0;
        HashMap<Integer, Integer>[] map = new HashMap[nums.length];

        for (int i = 0; i < map.length; i++) {
            map[i] = new HashMap<>();
        }

        for (int i = 1; i < map.length; i++) {

            for (int j = 0; j < i; j++) {

                long cd = (long) nums[i] - (long) nums[j];

                if (cd <= Integer.MIN_VALUE || cd >= Integer.MAX_VALUE) {
                    continue;
                }

                int apsEndingOnJ = map[j].getOrDefault((int) cd, 0);
                int apsEndingOnI = map[i].getOrDefault((int) cd, 0);

                ans += apsEndingOnJ;

                map[i].put((int) cd, apsEndingOnI + apsEndingOnJ + 1);
            }

        }

        return ans;
    }

}