import static org.junit.Assert.assertEquals;

public class LeetCode_80_RemoveElementsFromSortedArrayII {
    public static void main(String[] args) {
        
        assertEquals(5, new Solution_LeetCode_80_RemoveElementsFromSortedArrayII().removeDuplicates(new int [] {1,1,1,2,2,3}));
        assertEquals(7, new Solution_LeetCode_80_RemoveElementsFromSortedArrayII().removeDuplicates(new int [] {0,0,1,1,1,1,2,3,3}));
        assertEquals(7, new Solution_LeetCode_80_RemoveElementsFromSortedArrayII().removeDuplicates(new int [] {1,1,1,1,2,2,2,2,3,3,3,4}));
    }
}

class Solution_LeetCode_80_RemoveElementsFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        
        int slow = 0, fast = 1, count = 0, minimumIndexWithIntegerMax = -1;

        while (fast < nums.length) {
            
            if (nums[slow] == nums[fast] ) {
                if (count == 0) {
                    count++;
                } else {
                    nums[fast] = Integer.MAX_VALUE;
                    if (minimumIndexWithIntegerMax == -1) {
                        minimumIndexWithIntegerMax = fast;
                    }
                }
            } else  {
                slow = fast;
                count = 0;
            }

            fast++;
        }

        slow = minimumIndexWithIntegerMax == -1 ? nums.length : minimumIndexWithIntegerMax;

        fast = slow + 1;
        
        while (fast < nums.length) {

            if (nums[fast] != Integer.MAX_VALUE) {
                    
                nums[slow] = nums[fast];
                nums[fast] = Integer.MAX_VALUE;
                slow++;
            }
            fast++;

        }

        return slow;
    }
}
