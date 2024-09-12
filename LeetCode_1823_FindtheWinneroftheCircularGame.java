import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

public class LeetCode_1823_FindtheWinneroftheCircularGame {

    @Test
    public void test1() {
        assertEquals(3, findTheWinner(5, 2));
    }

    public int findTheWinner(int n, int k) {

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        int count = 0;
        while (queue.size() > 1) {

            int front = queue.poll();
            count++;

            if (count != k) {
                queue.offer(front);
            } else {
                count = 0;
            }
        }

        return queue.poll();

    }
}
