public class LeetCode_53_MaximumSumSubarray {
    /**
     * Kadane's Algorithm to find maximum sum of subarrays.
     * 
     * @param nums
     * @return
     */

    // public int maxSubArray(int[] nums) {

    // int maxEndingHere = 0;
    // int maxSoFar = Integer.MIN_VALUE;

    // for (int num : nums) {
    // maxEndingHere += num;
    // maxEndingHere = maxEndingHere < 0 ? 0 : maxEndingHere;
    // maxSoFar = maxSoFar > maxEndingHere ? maxSoFar : maxEndingHere;
    // }

    // return maxSoFar;
    // }

    public int maxSubArray(int[] nums) {

        int currentMax = 0;
        int globalMax = Integer.MIN_VALUE;

        for (int i : nums) {
            currentMax = Math.max(currentMax + i, i);
            globalMax = Math.max(globalMax, currentMax);
        }

        return globalMax;
    }
}
