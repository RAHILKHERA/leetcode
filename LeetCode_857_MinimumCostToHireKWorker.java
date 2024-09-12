import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class LeetCode_857_MinimumCostToHireKWorker {
    /**
     * Important
     * Greedy
     * Heap/Priority Queue
     * 
     * @param quality
     * @param wage
     * @param k
     * @return
     */
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {

        double totalCost = Double.MAX_VALUE;
        double currentTotalQuality = 0;
        int n = quality.length;
        List<Pair<Double, Integer>> wageToQualityRatio = new ArrayList<>();

        // Calculate Wage to Quality Ratio.
        for (int i = 0; i < n; i++) {

            wageToQualityRatio.add(new Pair<Double, Integer>((double) (wage[i] / quality[i]), quality[i]));
        }

        // Sort workers based on their wage to quality ratio.
        Collections.sort(wageToQualityRatio, Comparator.comparing(Pair::getKey));

        // Priority Queue to maintain the highest quality workers.
        PriorityQueue<Integer> highgestQualityWorkers = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < n; i++) {

            int currentQuality = wageToQualityRatio.get(i).getValue();
            currentTotalQuality += currentQuality;
            highgestQualityWorkers.offer(currentQuality);

            if (highgestQualityWorkers.size() == k) {
                totalCost = Math.min(totalCost, currentTotalQuality * wageToQualityRatio.get(i).getKey());
            } else if (highgestQualityWorkers.size() > k) {
                currentQuality -= highgestQualityWorkers.poll();
            }
        }

        return totalCost;
    }

    private class Pair<T extends Number, E extends Number> {

        private T key;
        private E value;

        Pair(T key, E value) {

            this.key = key;
            this.value = value;
        }

        public T getKey() {
            return key;
        }

        public E getValue() {
            return value;
        }
    }
}
