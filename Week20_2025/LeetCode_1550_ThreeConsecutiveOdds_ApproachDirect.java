package Week20_2025;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
/**
 * @RAHILKHERA
 * 
 * LeetCode Problem: 1550 Three consecutive odds.
 * Problem Link:
 * https://leetcode.com/problems/three-consecutive-odds/description/?envType=daily-question&envId=2025-05-11
 *
 * Input :
 * - Input integer array arr.
 * 
 * Constraints:
 * 1 <= arr.length <= 1000
 * 1 <= arr[i] <= 1000
 * 
 * Task: Check if there exists three consecutive odds.
 *
 * Observations:
 * #1 Directly check if the current number and the two numbers pervious to it are odd or not. 
 * 
 * Approach:
 * 1. For each element at index idx, check if elements at position idx, idx - 1 and idx - 2 are odd. 
 *     If they are then return true, i.e. Check window: [idx-2, idx-1, idx]
 * 2. Start from 2nd element as previous two are required.  
 *   
 * Time Complexity: O(N)
 *  - Each element is accessed 3 times.
 *  - Final Complexity : O(3N) => O(N).
 * 
 * Space Complexity: O(1)
 *  - No extra space is used which grows in propotion to the size of the input array. 
 * 
 * Note : This approach is not scalable for any number of consecutive odds numbers. 
 * 
 * Other Approaches : LeetCode_1550_ThreeConsecutiveOdds_ApproachSlidingWindow.java
 */

public class LeetCode_1550_ThreeConsecutiveOdds_ApproachDirect {

    @Test
    public void test1() {
        assertFalse(threeConsecutiveOdds(new int[] { 2, 6, 4, 1 }));
    }

    @Test
    public void test2() {
        assertTrue(threeConsecutiveOdds(new int[] { 1, 2, 34, 3, 4, 5, 7, 23, 12 }));
    }

    @Test
    public void test3() {
        assertFalse(threeConsecutiveOdds(new int[] { 1 }));
    }

    @Test
    public void test4() {
        assertTrue(threeConsecutiveOdds(new int[] { 968, 463, 205, 846, 678, 247, 551, 721, 592, 596 }));
    }

    public boolean threeConsecutiveOdds(int[] arr) {
        for (int i = 2; i < arr.length; i++) {

            if (arr[i] % 2 != 0 && arr[i - 2] % 2 != 0 && arr[i - 1] % 2 != 0) {
                return true;
            }
        }
        return false;
    }

}
