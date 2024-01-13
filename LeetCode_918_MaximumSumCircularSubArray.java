public class LeetCode_918_MaximumSumCircularSubArray {
    public int maxSubarraySumCircular(int[] nums) {
        int currentMax = 0;
        int globalMax = Integer.MIN_VALUE;
        int currentMin = 0;
        int globalMin = Integer.MAX_VALUE;
        int total = 0;

        for (int i : nums) {
            currentMax = Math.max(currentMax + i, i);
            globalMax = Math.max(globalMax, currentMax);
            currentMin = Math.min(currentMax + i, i);
            globalMin = Math.min(globalMin, currentMin);
            total += i;
        }

        if (globalMax < 0) {
            return globalMax;
        } else {

            return Math.max(globalMax, total - globalMin);
        }

    }
}
