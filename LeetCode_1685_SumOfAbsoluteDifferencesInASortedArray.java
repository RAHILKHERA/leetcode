public class LeetCode_1685_SumOfAbsoluteDifferencesInASortedArray {
    
}

class Solution_LeetCode_1685_SumOfAbsoluteDifferencesInASortedArray {
    public int[] getSumAbsoluteDifferences(int[] nums) {
     
        int sum = 0;    
        
        for (int num : nums) {
            sum+= num;
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = sum - (nums.length * nums[i]);
        }

        return nums;
    }
}
