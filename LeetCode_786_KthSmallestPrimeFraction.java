import java.util.PriorityQueue;

public class LeetCode_786_KthSmallestPrimeFraction {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {

        int n = arr.length;
        PriorityQueue<double[]> priorityQueue = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));

        for (int i = 0; i < n; i++) {
            priorityQueue.offer(new double[] { -1.0 * arr[i] / arr[n - 1], i, n - 1 });
        }

        while (--k > 0) {

            double curr[] = priorityQueue.poll();
            int numeratorIndex = (int) curr[1];
            int denominatorIndex = (int) curr[2] - 1;

            if (denominatorIndex > numeratorIndex) {

                priorityQueue.offer(new double[] { -1.0 * arr[numeratorIndex] / arr[denominatorIndex], numeratorIndex,
                        denominatorIndex });
            }

        }

        double top[] = priorityQueue.poll();

        return new int[] { arr[(int) top[1]], arr[(int) top[2]] };
    }
}
