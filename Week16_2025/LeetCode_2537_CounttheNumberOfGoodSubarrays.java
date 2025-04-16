package Week16_2025;

/**
 * LeetCode Problem: 2537 Count the number of good subarrays.
 * Problem Link:
 * https://leetcode.com/problems/count-the-number-of-good-subarrays/?envType=daily-question&envId=2025-04-16
 * 
 * Definitions :
 * #1 Good Subarray : A subarray is good if there are at least k pairs of indices (i,j) such that i < j and arr[i] = arr[j].
 * 
 * Task : To count number of good subarrays. 
 * 
 * Observation :
 * #1 To create a pair, one element should appear atleast twice.
 * #2 Numbr of pairs is directly propotional to the frequency of the element. 
 * #3 Suppose at index idx, at least K pairs are found, then this subarray can be extended till the last element. 
 *    As the condition of atleast K pairs will always true for remaining elements on right of idx.
 * #4 If freq of current element is x, then including current element will increase number of pairs by x. 
 *    e.g. a b c d e => a = b = c = d = e. Here all 5 elements are of same value, x .
 *    current element a, x -> 0 => 0 pairs as no element for pairing is available. 
 *    current element b, x -> 1(a) => current freq before counting for b is 1, 1 pair => ab
 *    current element c, x -> 2(a,b) => here 2 more pairs can be created, ac, bc
 *    current element d, x -> 3(a,b,c) => here 3 more pairs can be created, ad, bd, cd
 *    current element e, x -> 4 (a,b,c,d) => here 4 more pairs can be created, ae, be, ce, de
 *    x-> 5 and total pairs are 10. 
 * #5 If freq of current element is x, and that element is leaving the subarray, then number of pairs will be reduced by x - 1.
 *    In above example, when 'a' leaves, after processing freq is reduced by 1 => x -> 4 and number of pairs will reduce by 4 i.e. ab, ac, ad, ae 
 *    will be no more available.  
 * #6. From #4 and #5 it is clear that this problem can be solved using sliding window protocol.    
 * 
 * Approach:
 * 1) To keep the frequency, use a Map, it will element vs count. 
 * 2) Take two pointers left and right. left pointer will be used to shrink the window, right pointer will be used to shrink the window. 
 * 3) Take a varibale 'have' to maintain how many pairs are present in the subarray. 
 * 4) Expand the window until there are at least k pairs.
 * 5) If have >= k, that is more or equal to k pairs are found while explansion, add subarray till last element (n - right + 1). 
 *    +1 as the current element pointed by right is not part of the window. 
 * 6) Shrink the window from the left, reducing pair count based on outgoing element frequency.
 * 
 * Time Complexity: O(2n) => O(n). where n = size of the array. All the elements are visited twice. Hence O(2n) which is equivalent to O(n).
 * Space Complexity: O(n) => Map is used. 
 */
import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class LeetCode_2537_CounttheNumberOfGoodSubarrays {

    @Test
    public void test1() {
        assertEquals(4, countGood(new int[] { 3, 1, 4, 3, 2, 2, 4 }, 2));
    }

    @Test
    public void test2() {
        assertEquals(1, countGood(new int[] { 1, 1, 1, 1, 1 }, 10));
    }

    @Test
    public void test3() {
        assertEquals(9, countGood(new int[] { 2, 3, 1, 3, 2, 3, 3, 3, 1, 1, 3, 2, 2, 2 }, 18));
    }

    public long countGood(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int have = 0;
        long count = 0;
        int right = 0;
        for (int left = 0; left < n; left++) {

            while (have < k && right < n) {
                int incomingCount = map.getOrDefault(nums[right], 0);
                have += incomingCount;
                incomingCount++;
                map.put(nums[right], incomingCount);
                right++;
            }

            if (have >= k) {
                count += n - right + 1;
            }

            int outGoingCount = map.get(nums[left]);
            outGoingCount--;
            have -= outGoingCount;
            map.put(nums[left], outGoingCount);
        }
        return count;
    }

}
