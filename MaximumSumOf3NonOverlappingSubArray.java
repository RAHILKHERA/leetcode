import static org.junit.Assert.assertArrayEquals;

import java.util.PriorityQueue;

import org.junit.Test;

public class MaximumSumOf3NonOverlappingSubArray {

    @Test
    public void test1() {
        assertArrayEquals(new int[] { 0, 3, 5 }, maxSumOfThreeSubarrays(new int[] { 1, 2, 1, 2, 6, 7, 5, 1 }, 2));
    }

    private PriorityQueue<int[]> pq;
    private int n;

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        n = nums.length;
        pq = new PriorityQueue<>((a, b) -> {
            int sumA = nums[a[0]] + nums[a[1]] + nums[a[2]];
            int sumB = nums[b[0]] + nums[b[1]] + nums[b[2]];
            if (sumA == sumB) {
                if (a[0] != b[0])
                    return Integer.compare(a[0], b[0]);
                if (a[1] != b[1])
                    return Integer.compare(a[1], b[1]);
                return Integer.compare(a[2], b[2]);
            }
            return Integer.compare(sumB, sumA);
        });
        solve(k, 0, new int[3], 0);
        return pq.poll();
    }

    private void solve(int k, int startIndex, int[] current, int idx) {

        if (startIndex >= n) {
            if (idx == 3) {
                pq.offer(current);
            }
            return;
        }

        if (idx == 3) {
            pq.offer(current.clone());
            current = new int[3];
            return;
        }

        // skip
        solve(k, startIndex + 1, current, idx);

        // Take
        current[idx++] = startIndex;
        solve(k, startIndex + k, current, idx);

    }
}
