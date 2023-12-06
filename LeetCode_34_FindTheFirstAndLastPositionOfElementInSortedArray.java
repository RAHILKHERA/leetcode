public class LeetCode_34_FindTheFirstAndLastPositionOfElementInSortedArray {

    public static void main(String[] args) {

        new Solution_LeetCode_34_FindTheFirstAndLastPositionOfElementInSortedArray().searchRange(new int[]{5,7,7,8,8,10}, 10);
    }
    
}

class Solution_LeetCode_34_FindTheFirstAndLastPositionOfElementInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        int [] result = new int[] {-1, -1};
       
        if (nums.length == 0) {
            return result;
        }


        int left = 0;
        int right = nums.length -1;
        int index = -1;
        while (left <= right) {
            
            int mid = left + (right - left)/2;
            if (nums[mid] == target) {
                index = mid; 
                break;
            }  else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (index == -1) {
            return result;
        }

        left = index;
        right = index;

        while (left > -1 && nums[left] == nums[index]) {
            left--;
        }

        while ( right < nums.length && nums[right] == nums[index]) {
            right++;
        }

        result[0] = left + 1;
        result[1] = right - 1;

        return result;    
    }

    

   
}
