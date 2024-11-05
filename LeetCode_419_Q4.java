import static org.junit.Assert.assertArrayEquals;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

import org.junit.Test;

public class LeetCode_419_Q4 {

    @Test
    public void test1() {
        assertArrayEquals(new long[] { 6, 10, 12 }, findXSum(new int[] { 1, 1, 2, 2, 3, 4, 2, 3 }, 6, 2));
    }

    public long[] findXSum(int[] nums, int k, int x) {

        int n = nums.length;
        int index = 0;
        long[] result = new long[n - k + 1];

        TreeSet<long[]> left = new TreeSet<>((a, b) -> {
            if (a[0] == b[0]) {
                return Long.compare(a[1], b[1]);
            }
            return Long.compare(a[0], b[0]);
        });

        TreeSet<long[]> right = new TreeSet<>((a, b) -> {
            if (a[0] == b[0]) {
                return Long.compare(b[1], a[1]);
            }
            return Long.compare(b[0], a[0]);
        });

        Map<Integer, long[]> map = new HashMap<>();

        for (int i = 0; i < k; i++) {

            if (map.containsKey(nums[i])) {
                long[] pair = map.get(nums[i]);
                right.remove(pair);
                pair[0]++;
                map.put(nums[i], pair);
                right.add(pair);
            } else {
                map.put(nums[i], new long[] { 1, nums[i] });
                right.add(new long[] { 1, nums[i] });
            }
        }

        long sum = 0;
        while (left.size() < x && !right.isEmpty()) {
            long[] top = right.pollFirst();
            sum += top[0] * top[1];
            left.add(top);
        }

        result[index++] = sum;

        for (int i = k; i < n; i++) {

            // outgoing num.
            long[] pair = map.get(nums[i - k]);

            if (left.contains(pair)) {
                sum -= pair[0] * pair[1];
                left.remove(pair);
            }

            right.remove(pair);

            pair[0]--;
            if (pair[0] == 0) {
                map.remove(nums[i - k]);
            } else {
                map.put(nums[i - k], pair);
                right.add(pair);
            }

            // incoming num.
            long[] incomingPair = map.getOrDefault(nums[i], new long[] { 0, nums[i] });

            if (left.contains(incomingPair)) {
                sum -= incomingPair[0] * incomingPair[1];
                left.remove(incomingPair);
            }
            right.remove(incomingPair);
            incomingPair[0]++;

            map.put(nums[i], incomingPair);
            right.add(incomingPair);

            if (!left.isEmpty()) {
                long[] extra = left.pollFirst();
                sum -= extra[0] * extra[1];
                right.add(extra);
            }

            while (left.size() < x && !right.isEmpty()) {
                long[] top = right.pollFirst();
                sum += top[0] * top[1];
                left.add(top);
            }
            result[index++] = sum;
        }

        return result;
    }

}
