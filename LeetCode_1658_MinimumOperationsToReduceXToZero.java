import static org.junit.Assert.assertEquals;

public class LeetCode_1658_MinimumOperationsToReduceXToZero {

    public static void main(String[] args) {
        int nums[] = {3,2,20,1,1,3};
        int x = 10;
        assertEquals(5, new Solution_LeetCode_1658_MinimumOperationsToReduceXToZero().minOperations(nums, x));
        //assertEquals(3, new Solution_LeetCode_1658_MinimumOperationsToReduceXToZero().minOperations(new int [] {1,1}, 3));
    }
}

class Solution_LeetCode_1658_MinimumOperationsToReduceXToZero {

    public int minOperations(int[] nums, int x) {
        
        int operations = 0;
        int left = 0;
        int right = nums.length - 1;
        while ( left < nums.length && right >=0 && x > 0) {

            if (nums[left] <= x && nums[right] <= x) {

                if (nums[left] <= nums[right]) {
                    x -= nums[right];
                    if (right > 0) {
                        right--;
                    }
                    operations++;
                } else {
                    x -= nums[left];
                    if (left < nums.length) {
                        left++;
                    }
                    operations++;
                }

            } else if (nums[left] <= x) {
                x -= nums[left];
                if (left < nums.length) {
                    left++;
                }

                operations++;

            } else if (nums[right] <= x) {
                x -= nums[right];
                if (right >0) {
                    right--;
                }
                operations++;
            } else {
                if (left < nums.length) {
                    left++;
                }

                if (right >0) {
                    right--;
                }
            }
        }

        if (operations == 0) {
            return -1;
        }

        return operations; 
    }
}