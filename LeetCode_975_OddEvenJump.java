import static org.junit.Assert.assertEquals;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;

public class LeetCode_975_OddEvenJump {

    @Test
    public void test1() {
        assertEquals(2, oddEvenJumps(new int[] { 10, 13, 12, 14, 15 }));
    }

    /**
     * @param arr
     * @return
     */
    public int oddEvenJumps(int[] arr) {

        int n = arr.length;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int[] oddJump = new int[n];
        int[] evenJump = new int[n];
        int[][] dp = new int[n][2];
        int count = 0;

        for (int[] row : dp) {
            Arrays.fill(row, -2);
        }

        for (int i = n - 1; i >= 0; i--) {

            // odd jump
            Map.Entry<Integer, Integer> highEntry = map.ceilingEntry(arr[i]);
            oddJump[i] = highEntry == null ? -1 : highEntry.getValue();

            // even jump
            Map.Entry<Integer, Integer> lowerEntry = map.floorEntry(arr[i]);
            evenJump[i] = lowerEntry == null ? -1 : lowerEntry.getValue();

            map.put(arr[i], i);

        }

        // for (int i = 0; i < n; i++) {
        // count += canJump(i, oddJump, evenJump, dp, true);
        // }

        dp[n - 1][0] = 1;
        dp[n - 1][1] = 1;
        count++;

        for (int i = n - 2; i >= 0; i--) {

            if (oddJump[i] != -1) {
                dp[i][0] = dp[oddJump[i]][1];
            }

            if (evenJump[i] != -1) {
                dp[i][1] = dp[evenJump[i]][0];
            }

            if (dp[i][0] == 1) {
                count++;
            }
        }

        return count;
    }

    private int canJump(int index, int[] oddJump, int[] evenJump, int[][] dp, boolean odd) {

        if (index == oddJump.length - 1) {
            return 1;
        }

        if (odd && oddJump[index] == -1) {
            return 0;
        }

        if (!odd && evenJump[index] == -1) {
            return 0;
        }

        int jumpType = odd ? 0 : 1;

        if (dp[index][jumpType] != -2) {
            return dp[index][jumpType];
        }

        dp[index][jumpType] = canJump(odd ? oddJump[index] : evenJump[index], oddJump, evenJump, dp, !odd);
        return dp[index][jumpType];
    }
}