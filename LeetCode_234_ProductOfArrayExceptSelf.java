public class LeetCode_234_ProductOfArrayExceptSelf {
    
}

class Solution_LeetCode_234_ProductOfArrayExceptSelf {
    
    public int[] productExceptSelf(int[] nums) {

        int product = 1;
        int zeros = 0;
        int zeroIndex = 0;
        int [] result = new int [nums.length];
        
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                product *= nums[i];
            } else {
                zeroIndex = i;
                zeros++;
                if (zeros > 1) {
                    break;
                }
            }
        }

        if (zeros == 1) {
            result[zeroIndex] = product;

        } else if (zeros == 0) {
            for (int i = 0; i < nums.length; i++) {
                result[i] = (int) (product * Math.pow(nums[i], -1));
            }
        } 
        
        return result;
    }
}
