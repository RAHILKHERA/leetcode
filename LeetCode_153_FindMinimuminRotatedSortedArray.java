public class LeetCode_153_FindMinimuminRotatedSortedArray {
    
}

class Solution_LeetCode_153_FindMinimuminRotatedSortedArray {

    public int findMin(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid =  left + (right - left)/2;

            if (nums[mid]  > nums[right]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return nums[left];
    }
}