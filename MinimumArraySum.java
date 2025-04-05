import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

import org.junit.Test;

public class MinimumArraySum {

    @Test
    public void test1() {
        assertEquals(23, minArraySum(new int[] { 2, 8, 3, 19, 3 }, 3, 1, 1));
    }

    @Test
    public void test2() {
        assertEquals(3, minArraySum(new int[] { 2, 4, 3 }, 3, 2, 1));
    }

    public int minArraySum(int[] nums, int k, int op1, int op2) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            maxHeap.offer(new int[] { nums[i], i });
        }

        Set<Integer> division = new HashSet<>();
        Set<Integer> sub = new HashSet<>();

        int sum = 0;

        while ((op1 > 0 || op2 > 0) && !maxHeap.isEmpty()) {

            int[] top = maxHeap.poll();
            int divResult = Integer.MAX_VALUE;
            int subResult = Integer.MAX_VALUE;
            if (op1 > 0 && !division.contains(top[1])) {
                divResult = (top[0] + 1) / 2;
            }

            if (op2 > 0 && !sub.contains(top[1]) && top[0] >= k) {
                subResult = top[0] - k;
            }

            if (divResult < subResult) {
                op1--;
                division.add(top[1]);
                top[0] = divResult;
                maxHeap.offer(top);
            } else if (subResult < divResult) {
                op2--;
                sub.add(top[1]);
                top[0] = subResult;
                maxHeap.offer(top);
            } else {
                sum += top[0];
            }
        }

        while (!maxHeap.isEmpty()) {
            sum += maxHeap.poll()[0];
        }

        return sum;

    }
}
