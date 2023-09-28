public class LeetCode_905_SortArrayByParity {
    
}

class Solution_LeetCode_905_SortArrayByParity {
    public int[] sortArrayByParity(int[] nums) {
        
        if (nums.length == 1) {
            return nums;
        }
        
        int firstOddPointer = 0;

        while (firstOddPointer < nums.length) {

            if (nums[firstOddPointer] % 2 == 0) {
                firstOddPointer++;
            } else {
                break;
            }
        }

        int evenPointer = firstOddPointer + 1;

        while(evenPointer < nums.length) {
            if (nums[evenPointer] % 2 == 0) {
                int temp = nums[firstOddPointer];
                nums[firstOddPointer] = nums[evenPointer];
                nums[evenPointer]  = temp;
                firstOddPointer++;
                
            } 
            evenPointer++;
        }
        return nums;
    }
}
