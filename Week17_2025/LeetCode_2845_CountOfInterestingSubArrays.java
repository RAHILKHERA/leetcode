package Week17_2025;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashMap;

/**
 * LeetCode Problem: 2845 Count of interesting subarrays. 
 * Problem Link: https://leetcode.com/problems/count-of-interesting-subarrays/description/?envType=daily-question&envId=2025-04-25
 * 
 *Input : 
 * - List of Integers
 * - integer modulo 
 * - integer k -> expected remainder when performed mod operation with integer modulo. 
 * 
 * Definition : Interesting Subarrays, 
 *  1) Let cnt be the count of elements in sub array such that nums[i] % modulo = k. 
 *  2) if cnt % modulo = k => subarray is interesting. 
 * 
 * Task: Count the interesting subarrays. 
 * 
 * Constraints : 
 * -> 1 <= nums.length <= 10^5 
 * -> 1 <= nums[i] <= 10^9
 * -> 1 <= modulo <= 10^9
 * -> 0 <= k < modulo
 * 
 * 
 * Observations:
 * #1. Find the remainder for all the elements by performing mod operation with modulo. 
 * #2. Find the total remainders = k up to index idx. This represents count of remainders equal to k in subarrays [0, idx]. 
 *     The last index count will represents total elements with k remainder on performing mod with modulo. 
 * #3. In other words, find the prefix sum of the remainder which are equal to k. 
 *     Let's denote it as prefixSum and prefixSum[idx] represents number of remainders equal to k in subarray [0, idx].
 * #4. A subarray starting at index 'l' and ending at 'r', can be considered interesting by following equation :
 *     (prefixSum[r] - prefixSum[l - 1]) % modulo = k
 * #5. Solving above equation. 
 *     => (prefixSum[r] - prefixSum[l-1]) % modulo = k
 *     => (prefixSum[r] - prefixSum[l-1]) = x*modulo + k [x can be any integer, as this equation is valid for all multiples of modulo].
 *     => prefixSum[l-1] = prefixSum[r] - x*modulo - k
 *     => prefixSum[l-1] % modulo = prefixSum[r] % modulo - x* modulo % modulo - k % modulo [Applying the modulo operation on both the sides.]
 *     => prefixSum[l-1] % modulo = prefixSum[r] % modulo - 0 - k % modulo. [x*modulo is multiple of modulo, hence remainder will be 0].
 *     => prefixSum[l-1] % modulo = (prefixSum[r] -k) % modulo. 
 *     => prefixSum[l-1] % modulo = (prefixSum[r] - k + modulo) % modulo. [For cases k > prefixSum[r] => prefixSum[r] - k < 0].       
 * #6. From above equation, it is clear that for any index 'r' if there exists 'l' such that l <= r and satisfies the above condition 
 * than it can be counted as interesting subarry.
 * #7 This forms the standard prefix sum of subarray solution.          
 *  
 * Approach:
 * 1. Use a map, prefixSum[l-1] % modulo vs count. 
 * 2. Intialize map with (0,1). As even before traversing the array, sum is 0 and 0 is divisible by modulo. 
 * 3. Traverse the list, keep track of the prefixSum, prefixSum[i] = prefixSum[i-1] + (nums[i] % modulo == k ? 1: 0).
 *    a) Count it only if condition is satisfied else skip it. 
 * 4. For every index idx, check if (prefixSum - k + modulo ) % modulo exists? If yes, add its count. 
 * 5. Update the map, with  prefixSum % modulo count. 
 *
 * Time Complexity: O(n)
 *     - Traversing the list : O(n)
 *     - Map Operations : O(1) 
 *     - Final Complexity : O(n)  
 * Space Complexity: O(min(n, modulo))
 * - The map stores frequencies of prefixSum % modulo values
 * - Maximum of `modulo` unique values possible
 * - So in worst case, space is min(n, modulo)
 */

import java.util.List;
import java.util.Map;

import org.junit.Test;

public class LeetCode_2845_CountOfInterestingSubArrays {

    @Test
    public void test1() {
        assertEquals(3, countInterestingSubarrays(Arrays.asList(3, 2, 4), 2, 1));
    }

    @Test
    public void test2() {
        assertEquals(2, countInterestingSubarrays(Arrays.asList(3, 1, 6, 9), 3, 0));
    }

    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int prefixSum = 0;
        long count = 0;
        for (int num : nums) {
            prefixSum += (num % modulo) == k ? 1 : 0;
            count += map.getOrDefault((prefixSum - k + modulo) % modulo, 0);
            map.compute(prefixSum % modulo, (key, value) -> value == null ? 1 : value + 1);
        }
        return count;
    }
}