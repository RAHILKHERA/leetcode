//

public class LeetCode_1464_MaximumProductOfTwoElementsInAnArray {
    
}

class Solution_LeetCode_1464_MaximumProductOfTwoElementsInAnArray { 

    public int maxProduct(int[] nums) {
        
        // Arrays.sort(nums);
        // int n = nums.length;
        // return nums[n -1] -1 * nums[n-2] -1;

        int biggest = 0;
        int secondBiggest = 0;
        for (int num : nums) {
            if (num > biggest) {
                secondBiggest = biggest;
                biggest = num;
            } else {
                secondBiggest = Math.max(secondBiggest, num);
            }
        }
        
        return (biggest - 1) * (secondBiggest - 1);
    }
}

