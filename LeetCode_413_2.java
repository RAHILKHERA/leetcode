
import java.util.Collections;
import java.util.PriorityQueue;

public class LeetCode_413_2 {
    public int[] resultsArray(int[][] queries, int k) {

        int n = queries.length;
        int[] result = new int[n];
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        int index = 0;

        for (int[] query : queries) {
            int x = query[0];
            int y = query[1];
            int d = Math.abs(x) + Math.abs(y);
            priorityQueue.offer(d);

            while (priorityQueue.size() > k) {
                priorityQueue.poll();
            }

            if (priorityQueue.size() == k) {
                result[index++] = priorityQueue.peek();
            } else {
                result[index++] = -1;
            }

        }

        return result;
    }
}
