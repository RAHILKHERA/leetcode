import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import org.junit.Test;

public class LeetCode_1481_LeatNumberOfUniqueNumbersAfterKRemovals {

    @Test
    public void test1() {

        assertEquals(1, findLeastNumOfUniqueInts(new int[] { 5, 5, 4 }, 1));
    }

    @Test
    public void test2() {

        assertEquals(2, findLeastNumOfUniqueInts(new int[] { 4, 3, 1, 1, 3, 3, 2 }, 3));
    }

    public int findLeastNumOfUniqueInts(int[] arr, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i : arr) {
            map.compute(i, (key, value) -> value == null ? 1 : value + 1);
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(map.values());

        while (!queue.isEmpty() && k > 0 && queue.peek() <= k) {
            k -= queue.poll();
        }

        return queue.size();
    }
}
