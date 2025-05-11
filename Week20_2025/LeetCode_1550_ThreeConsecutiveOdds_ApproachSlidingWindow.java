package Week20_2025;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.function.Predicate;

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
 * #1 To find k consecutive elements satisfying a condition
 *  => Either find a subarray with k elements which satisfy the condition.
 *  => Sliding window with fixed window size of k can be used.
 * #2. In this case, the condition is to find the k odd elements.
 *  => There should be 0 even elements.
 * #3. Track number of even elements in the window,
 *  => If number of even elements is zero, subarray with k consecutive elements is found. 
 * #4. Although the question asks for 3 consecutive odd numbers, this implementation will be generic for k consecutive odd numbers. 
 * 
 * Approach:
 *  1. Following standard sliding window protocol,
 *     => If the array size is smaller than the k, it is not possible to find k consecutive odd numbers. 
 *     => For first window, traverse from 0 to k - 1, and count total number of even numbers. 
 *     => If even numbers in the current window is 0, required subarray is found. 
 * 2. From index (idx) = k to n-1,
 *     => idx, represents the window from idx - k + 1 to idx. 
 *     => arr[idx - k] is the element leaving the window, if arr[idx - k] is even, reduce the count. 
 *     => arr[idx] is the element entering the window, if arr[idx] is even, increase the count. 
 *     => if the count = 0, subarray is found. 
 * 3. This case requires 3 consecutive odds, pass the k = 3 to above procedure. 
 *   
 * Time Complexity: O(N)
 *  - In standard sliding window protocol, each element is visited twice, once entering the window and once exiting the window. 
 *  - Final Complexity : O(2N) => O(N)
 * 
 * Space Complexity: O(1)
 *  - No extra space is used which grows in propotion to the size of the input array. 
 * 
 * Note : This approach is scalable for any number of consecutive odds numbers. 
 * 
 * Other Approaches : LeetCode_1550_ThreeConsecutiveOdds_ApproachDirect.java
 */

public class LeetCode_1550_ThreeConsecutiveOdds_ApproachSlidingWindow {

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
        return kConsecutiveSatisfyingCondition(arr, 3, num -> (num & 1) != 0);
    }

    private boolean kConsecutiveSatisfyingCondition(int[] arr, int k, Predicate<Integer> condition) {

        if (arr.length < k) {
            return false;
        }

        int failCount = 0;

        for (int i = 0; i < k; i++) {
            if (!condition.test(arr[i])) {
                failCount++;
            }
        }

        if (failCount  == 0) {
            return true;
        }

        for (int i = k; i < arr.length; i++) {

            if (!condition.test(arr[i - k])) {
                failCount--; 
            }

            if (!condition.test(arr[i])) {
                failCount++;
            }

            if (failCount == 0) {
                return true;
            }
        }

        return false;
    }
}
