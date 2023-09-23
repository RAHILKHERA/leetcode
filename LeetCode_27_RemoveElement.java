public class LeetCode_27_RemoveElement {
    public static void main(String[] args) {
        int [] nums = {0,1,2,2,3,0,4,2};
        new Solution_27_RemoveElement().removeElement(nums,2);
    }
}

class Solution_27_RemoveElement {
    public int removeElement(int[] nums, int val) {

        int i = nums.length - 1; 
        int count = 0;
        while (i >= 0) {
            if (nums[i] == val) {
                i--;
                count++;
            } else {
                break;
            }
        }

        if (i > 0) {
            int  j = i - 1;
            while (j >=0) {
                if (nums[j] == val) {
                    nums[j] = nums[i];
                    nums[i] = val;
                    i--;
                    count++;
                } 
                j--;
            }
        }  

        return nums.length - count;

    }

}
