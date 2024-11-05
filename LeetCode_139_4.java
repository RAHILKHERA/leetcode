import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

public class LeetCode_139_4 {

    public int maxPathLength(int[][] coordinates, int k) {

        int x = coordinates[k][0];
        int y = coordinates[k][1];
        int n = coordinates.length;

        Collections.binarySearch(null, null);

        Arrays.sort(coordinates, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        int index = 0;
        while (index < n) {

            if (coordinates[index][0] == x && coordinates[index][1] == y) {
                break;
            }

            index++;
        }

        int left = index - 1;
        int right = index + 1;

        List<Deque<int[]>> stackList = new ArrayList<>();

        while (left >= 0) {

            if (coordinates[left][0] < x && coordinates[left][1] < y) {
                boolean added = false;

                for (Deque<int[]> stack : stackList) {
                    int[] top = stack.peek();
                    if (coordinates[left][0] < top[0] && coordinates[left][1] < top[1]) {
                        stack.push(coordinates[left]);
                        added = true;
                    }

                }

                if (!added) {
                    Deque<int[]> stack = new ArrayDeque<>();
                    stack.add(coordinates[left]);
                    stackList.add(stack);
                }
            }

            left--;
        }

        int leftPathLength = 0;
        for (Deque<int[]> deque : stackList) {
            leftPathLength = Math.max(leftPathLength, deque.size());
        }

        stackList = new ArrayList<>();

        while (right < n) {

            if (coordinates[right][0] > x && coordinates[right][1] > y) {

                boolean added = false;

                for (Deque<int[]> stack : stackList) {
                    int[] top = stack.peek();
                    if (coordinates[right][0] > top[0] && coordinates[right][1] > top[1]) {
                        stack.push(coordinates[right]);
                        added = true;
                    }

                }

                if (!added) {
                    Deque<int[]> stack = new ArrayDeque<>();
                    stack.add(coordinates[right]);
                    stackList.add(stack);
                }
            }

            right++;
        }
        int rightPathLength = 0;

        for (Deque<int[]> deque : stackList) {
            rightPathLength = Math.max(rightPathLength, deque.size());
        }

        return 1 + leftPathLength + rightPathLength;
    }
}
