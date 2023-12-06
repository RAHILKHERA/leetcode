public class LeetCode_33_SearchinRotatedSortedArray {
    
}

class Solution_LeetCode_33_SearchinRotatedSortedArray {
    
    public int search(int[] nums, int target) {
        
        int left = 0, right = nums.length - 1, pivotPoint = -1;

        while (left < right) {
            int mid = left + (right - left)/2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > nums[right]) {
                left = mid+1;
            } else {
                right = mid;
            }
        }

        pivotPoint = left;

        if (target > nums[nums.length -1]) {
            left = 0;
            right = pivotPoint - 1;
        } else {
            right = nums.length -1;
        }

        while (left <= right) {
            int mid = left + (right - left)/2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid+1;
            } else {
                right = mid-1 ;
            }
        }

        return -1;
    }
}
