import java.util.Arrays;

public class LeetCode_2966_DivideArrayIntoArraysWithMaxDifference {
    public int[][] divideArray(int[] nums, int k) {
        int n = nums.length;
        int[][] result = new int[n / 3][3];
        Arrays.sort(nums);
        int index = 0;

        for (int i = 2; i < n; i += 3) {
            if ((nums[i - 1] - nums[i - 2] <= k) && (nums[i] - nums[i - 1] <= k) && (nums[i] - nums[i - 2] <= k)) {
                result[index][0] = nums[i - 2];
                result[index][1] = nums[i - 1];
                result[index][2] = nums[i];
                index++;
            } else {
                return new int[][] {};
            }
        }
        return result;
    }
}
