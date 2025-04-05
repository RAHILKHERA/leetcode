import static org.junit.Assert.assertEquals;

import java.security.KeyStore.Entry;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class IdentifyLargestOutlierIntheArray {

    @Test
    public void test() {
        assertEquals(5, getLargestOutlier(new int[] { 5, 1, 1, 1, 1, 1, 5 }));
    }

    @Test
    public void test1() {
        assertEquals(5, getLargestOutlier(new int[] { 5, 5, 1, 1, 1, 1, 1 }));
    }

    @Test
    public void test2() {
        assertEquals(-310, getLargestOutlier(new int[] { -310, -702, -702 }));
    }

    public int getLargestOutlier(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }

        int n = nums.length;
        int k = n - 2;
        if (k == 1 && map.size() == 2) {
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() == 1) {
                    return entry.getKey();
                }
            }
        }

        // First Window
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        if (map.containsKey(sum)) {
            map.computeIfPresent(sum, (key, value) -> value > 1 ? value - 1 : null);
            for (int i = 0; i < k; i++) {
                map.computeIfPresent(nums[i], (key, value) -> value > 1 ? value - 1 : null);
            }
            return map.keySet().iterator().next();
        }

        for (int i = k; i < n; i++) {
            sum += nums[i] - nums[i - k];
            if (map.containsKey(sum)) {
                map.computeIfPresent(sum, (key, value) -> value > 1 ? value - 1 : null);
                for (int j = i - k + 1; j <= i; j++) {
                    map.computeIfPresent(nums[j], (key, value) -> value > 1 ? value - 1 : null);
                }
                return map.keySet().iterator().next();
            }

        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
        }
        return max;

    }
}