import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class LeetCode_1942_TheNumberoftheSmallestUnoccupiedChairMedium {
    public int smallestChair(int[][] times, int targetFriend) {
        int n = times.length;

        int maxStart = -1;
        for (int[] time : times) {
            maxStart = Math.max(time[0], maxStart);
        }
        maxStart++;
        int[] starts = new int[maxStart];
        Arrays.fill(starts, -1);
        for (int i = 0; i < n; i++) {
            starts[times[i][0]] = i;
        }

        // Available chairs
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.offer(i);
        }

        // End Time vs list of chairs getting empty.
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < maxStart; i++) {

            // If at i, there are chairs getting empty.
            if (map.containsKey(i)) {
                for (int chair : map.get(i)) {
                    pq.offer(chair);
                }
            }

            if (starts[i] != -1) { // If a friend is coming at time (i).
                int chair = pq.poll();
                if (targetFriend == starts[i]) {
                    return chair;
                }

                map.computeIfAbsent(times[starts[i]][1], key -> new ArrayList<>()).add(chair);
            }
        }

        return 0;
    }
}
