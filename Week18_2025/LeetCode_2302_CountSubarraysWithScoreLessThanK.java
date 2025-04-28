package Week18_2025;

/**
 * LeetCode Problem: 2302 Count Subarrays with score less than k. 
 * Problem Link:
 * https://leetcode.com/problems/count-subarrays-with-score-less-than-k/description/?envType=daily-question&envId=2025-04-28
 *
 * Input : 
 *  - Integer array nums. 
 *  - Long k
 * 
 * Constraints:
 *  1 <= nums.length <= 10^5
 *  1 <= nums[i] <= 10^5
 *  1 <= k <= 10^15
 * 
 * 
 * Definition : Score of the subarray is  product of the summation of all the elements of subarray and its length. 
 * For e.g. score of [1,2,3,4,5] = (1 + 2 + 3 + 4 + 5) * 5 = 75.  
 * 
 * Task:
 * Count number of subarrays whose score is less than k. 
 *
 * Observations:
 * #1. Finding subarray with condition a given condition. Here score < k.  
 * #2. Classic case of Sliding window protocol, with dynamic window. 
 * #3. Expand the window by increasing the sum and calculate new score. 
 *     => while score >=k, shrink the window by reducing the sum and update the score. 
 *     => Calculate the count, length of the subarray represents count of the subarrays. 
 * 
 * Approach:
 * 1. Keep two pointers left and right, left for shrinking and right for expanding. 
 * 2. Variable sum to keep track of sum of the subarray. 
 * 3. Add nums[right] to the sum and calculate score by multiplying the length of subarray = right - left + 1. 
 * 4. While score >= k, shrink window by removing the nums[left].
 *    => Reduce sum by nums[left].
 *    => length too will be reduced by 1. 
 *    => Update the score to reflect updated sum and length. 
 * 5. Calculate the count by adding the length of the subarray. 
 *  => Each window ending at 'right' contributes (right - left + 1) subarrays.
 * 
 * Time Complexity: O(n) 
 *     - Sliding Window Protocol, every element is visited twice. 
 *     - n = length of the array nums. 
 *
 * Space Complexity: O(1)
 *      - No extra space proportional to input is used. 
 */


import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LeetCode_2302_CountSubarraysWithScoreLessThanK {
    
    @Test
    public void test1() {
        assertEquals(6, countSubarrays(new int [] {2,1,4,3,5}, 10));
    }

    @Test
    public void test2() {
        assertEquals(5, countSubarrays(new int [] {1,1,1}, 5));
    }
    
    public long countSubarrays(int[] nums, long k) {
        long count = 0;
        int left = 0;
        long sum = 0;
        for (int right = 0; right < nums.length; right++) {

            sum += nums[right];
            int length = right - left + 1;
            long score =  sum  * length;
            
            while (score >= k && left <= right) {
                sum -= nums[left++];
                length = right - left + 1;
                score = sum * length;
            }

            count += length;
        }
        
        return count;
    }
}
