import java.util.Arrays;

public class LeetCode_1877_MinimizeMaximumPairSuminArray {
    
}

class Solution_LeetCode_1877_MinimizeMaximumPairSuminArray {

    public int minPairSum(int[] nums) {
     
        Arrays.sort(nums);
        
        int left = 0, right = nums.length - 1, max = 0;

        while (left <= right) {

            int sum = nums[left] + nums[right];
            
            if (max < sum) {
                max = sum;
            }

            left++;
            right--;
        }

        return max;
    }
}
