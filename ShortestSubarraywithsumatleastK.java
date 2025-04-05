import static org.junit.Assert.assertEquals;

import java.util.ArrayDeque;
import java.util.Deque;

import org.junit.Test;

public class ShortestSubarraywithsumatleastK {

    @Test
    public void test1() {
        assertEquals(3, shortestSubarray(new int[] { -28, 81, -20, 28, -29 }, 89));
    }

    public int shortestSubarray(int[] nums, int k) {

        int n = nums.length;
        Deque<Integer> deque = new ArrayDeque<>();
        long[] prefixSum = new long[n];
        int result = Integer.MAX_VALUE;
        int j = 0;
        while (j < n) {
            prefixSum[j] = j == 0 ? nums[j] : prefixSum[j - 1] + nums[j];

            if (prefixSum[j] >= k) {
                result = Math.min(result, j + 1);
            }

            while (!deque.isEmpty() && prefixSum[j] - prefixSum[deque.peekFirst()] >= k) {
                result = Math.min(result, j - deque.pollFirst());
            }

            while (!deque.isEmpty() && prefixSum[j] <= prefixSum[deque.peekLast()]) {
                deque.pollLast();
            }

            deque.offerLast(j);
            j++;
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
