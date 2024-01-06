import java.util.Arrays;

/**
 * https://www.youtube.com/watch?v=cjWnW0hdF1Y&ab_channel=NeetCode
 */
public class LeetCode_300_LongestIncreasingSubSequence {
    public int lengthOfLIS(int[] nums) {

        int[] LIS = new int[nums.length];
        Arrays.fill(LIS, 1);

        for (int i = nums.length - 1; i >= 0; i--) {

            for (int j = i + 1; j < nums.length; j++) {

                if (nums[i] < nums[j]) {
                    LIS[i] = (1 + LIS[j]) > LIS[i] ? (1 + LIS[j]) : LIS[i];
                }
            }
        }

        int maxLength = 0;

        for (int i = 0; i < LIS.length; i++) {
            maxLength = maxLength > LIS[i] ? maxLength : LIS[i];
        }

        return maxLength;
    }
}
