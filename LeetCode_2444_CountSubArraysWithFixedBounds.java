public class LeetCode_2444_CountSubArraysWithFixedBounds {

    /**
     * 
     * @param nums
     * @param minK
     * @param maxK
     * @return
     */
    public long countSubarrays(int[] nums, int minK, int maxK) {

        int minPosition = -1;
        int maxPosition = -1;
        int outBound = -1;
        long res = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] > maxK || nums[i] < minK) {
                outBound = i;
            }

            if (nums[i] == maxK) {
                maxPosition = i;
            }

            if (nums[i] == minK) {
                minPosition = i;
            }

            res += Math.max(0, Math.min(minPosition, maxPosition) - outBound);

        }

        return res;

    }
}
