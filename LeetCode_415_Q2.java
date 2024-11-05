import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

import org.junit.Test;

public class LeetCode_415_Q2 {

    @Test
    public void test1() {

        int[] a = new int[] { -1, 4, 5, -2 };
        int[] b = new int[] { -5, -1, -3, -2, -4 };
        assertEquals(-1, maxScore(a, b));

    }

    public long maxScore(int[] a, int[] b) {

        long ans = 0;

        if (b.length == 4) {

            for (int i = 0; i < 4; i++) {
                ans += a[i] * b[i];
            }
            return ans;
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> Integer.compare(x.value, y.value));

        for (int i = 0; i < b.length; i++) {

            if (pq.size() == 4 && pq.peek().value < b[i]) {
                pq.poll();
            }
            pq.offer(new Pair(b[i], i));

        }

        List<Pair> newB = new ArrayList<>();

        while (!pq.isEmpty()) {
            newB.add(pq.poll());
        }

        Collections.sort(newB, (x, y) -> Integer.compare(x.index, y.index));

        for (int i = 0; i < 4; i++) {
            ans += a[i] * newB.get(i).value;
        }

        return ans;

    }

    class Pair {

        int value;
        int index;

        Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}
