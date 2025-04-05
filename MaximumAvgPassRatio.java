import static org.junit.Assert.assertEquals;

import java.util.PriorityQueue;

import org.junit.Test;

public class MaximumAvgPassRatio {

    @Test
    public void test1() {
        assertEquals(0.78333, maxAverageRatio(new int[][] { { 1, 2 }, { 3, 5 }, { 2, 2 } }, 2), 0.00005);
    }

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));
        int n = classes.length;
        for (int i = 0; i < n; i++) {
            int pass = classes[i][0];
            int total = classes[i][1];
            double newAvg = (double) (pass + 1) / (total + 1);
                double avg = (double) pass / total;
                pq.offer(new double[] { newAvg - avg, i });
        }

        while (extraStudents-- > 0) {
            double[] top = pq.poll();
            int idx = (int) top[1];
            classes[idx][0]++;
            classes[idx][1]++;
            double newAvg = (double) (classes[idx][0] + 1) / (classes[idx][1] + 1);
            double avg = (double) classes[idx][0] / classes[idx][1];
            pq.offer(new double[] { newAvg - avg, idx });
        }

        double sum = 0;
        for (int[] cls : classes) {
            sum += (double) cls[0] / cls[1];
        }

        return sum / n;
    }
}
