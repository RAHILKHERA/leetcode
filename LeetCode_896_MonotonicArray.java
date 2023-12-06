import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LeetCode_896_MonotonicArray {
    public static void main(String[] args) {
        assertTrue(new Solution_LeetCode_896_MonotonicArray().isMonotonic(new int [] {1,2,2,3}));
        assertTrue(new Solution_LeetCode_896_MonotonicArray().isMonotonic(new int [] {6,5,4,4}));
        assertFalse(new Solution_LeetCode_896_MonotonicArray().isMonotonic(new int [] {1,3,2}));
        assertTrue(new Solution_LeetCode_896_MonotonicArray().isMonotonic(new int [] {0}));
        assertTrue(new Solution_LeetCode_896_MonotonicArray().isMonotonic(new int [] {2,2,2,2}));
        assertTrue(new Solution_LeetCode_896_MonotonicArray().isMonotonic(new int [] {2,2,2,2,3,4}));
        assertFalse(new Solution_LeetCode_896_MonotonicArray().isMonotonic(new int [] {2,2,2,2,3,1}));
        assertTrue(new Solution_LeetCode_896_MonotonicArray().isMonotonic(new int [] {2,2,2,2,3,3,3,4}));
        System.out.println("All the test cases passed");
        
        
    }
}

class Solution_LeetCode_896_MonotonicArray {

    public boolean isMonotonic (int [] nums) {
        
        if (nums.length == 1) {
            return true;
        }

        int i = 0, j = 1; 

        boolean increasing = false, decreasing = false;
        while(j < nums.length) {

            if (increasing && nums[i] > nums[j]) return false;
            
            if (decreasing && nums[i] < nums[j]) return false;

            if (!increasing && !decreasing) {

                if (nums[i] < nums[j]) {
                    increasing = true;
                } else if (nums[i] > nums[j]) {
                    decreasing = true;
                }
            }
            i++;
            j++;
        }
        return true; 
    }
}
