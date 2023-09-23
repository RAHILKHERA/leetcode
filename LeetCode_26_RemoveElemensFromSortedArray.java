public class LeetCode_26_RemoveElemensFromSortedArray {

    public static void main(String[] args) {
        int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
        new Solution_26_RemoveElementsFromSortedArray().removeDuplicates(nums);
    }

}

class Solution_26_RemoveElementsFromSortedArray {
    public int removeDuplicates(int[] nums) {
        
        int i = 0;
        int j = i + 1;
        int minimumIndexWithIntegerMax = -1;
        while (j < nums.length) {
            
             if (nums[i]  == nums[j]) {
                nums[j] = Integer.MAX_VALUE;
                if (minimumIndexWithIntegerMax == -1) {
                    minimumIndexWithIntegerMax = j;
                }
             }  else {
                i = j;
             }
             j++;
        }

        i = minimumIndexWithIntegerMax;
        
        int count = 0;

        j = i + 1;

        while (j < nums.length) {

            if (nums[j] != Integer.MAX_VALUE) {
                nums[i] = nums[j];
                nums[j] = Integer.MAX_VALUE;
                count++;
                i++;
            }
            j++;
        }   
        return nums.length - count;
    }
}
