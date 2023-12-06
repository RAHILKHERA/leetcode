public class LeetCode_162_FindPeakElement {
    
}

class Solution_LeetCode_162_FindPeakElement {

    public int findPeakElement(int[] nums) {
        
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            boolean leftN = mid == 0 ? true : nums[mid] > nums[mid-1]; 
            boolean rightN = mid + 1 == nums.length ? true : nums[mid] > nums[mid+1];
            
            if (leftN && rightN) {
                return mid; 
            }

            if (leftN) {
                left = mid+1;
            }

            if (rightN) {
                right = mid-1;
            }

            if (!leftN && !rightN) {
                left = mid + 1;
            }
        }
        return 0;
    }
    
}
