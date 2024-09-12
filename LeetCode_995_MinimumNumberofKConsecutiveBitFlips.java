public class LeetCode_995_MinimumNumberofKConsecutiveBitFlips {

    public int minKBitFlips(int[] nums, int k) {

        int minOperations = 0;
        int n = nums.length;

        for (int i = 0; i <= n - k; i++) {
            if (nums[i] == 0) {
                flip(nums, k, i);
                minOperations++;
            }
        }

        for (int i = n - k; i < nums.length; i++) {
            if (nums[i] == 0) {
                return -1;
            }
        }

        return minOperations;
    }

    private void flip(int[] nums, int k, int from) {

        for (int i = from; i < from + k; i++) {
            nums[i] = nums[i] == 0 ? 1 : 0;
        }
    }
}
