public class LeetCode_377_CombinationSumIV {
    public static void main(String[] args) {

        int [] nums = {1,2,3};
        new Solution_377().combinationSum4(nums, 4);    
        
    }
}

class Solution_377 {
    public int combinationSum4(int[] nums, int target) {
         int[] dp = new int[target + 1];
        dp[0] = 1;
        
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i - num >= 0) {
                    dp[i] += dp[i - num];
                }
            }
        }
        
        return dp[target];
    }
}