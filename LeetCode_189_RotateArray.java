import static org.junit.Assert.assertArrayEquals;

public class LeetCode_189_RotateArray {

    public static void main(String[] args) {
        assertArrayEquals(new int []{5,6,7,1,2,3,4},new Solution_LeetCode_189_RotateArray().rotate(new int []{1,2,3,4,5,6,7}, 3));
        assertArrayEquals(new int []{3,99, -1, -100},new Solution_LeetCode_189_RotateArray().rotate(new int []{-1, -100,3, 99}, 2));
    }
    
}

class Solution_LeetCode_189_RotateArray {
    public int[] rotate(int[] nums, int k) {

       
        k = k % nums.length;

         if (k == 0) {
            return nums;
        }


        reverse(nums, 0, nums.length - 1) ;
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length - 1);
        return nums;
    }

    private void reverse(int[] nums, int left, int right) {
        
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
