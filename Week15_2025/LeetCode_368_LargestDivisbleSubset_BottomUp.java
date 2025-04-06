package Week15_2025;

/**
 * LeetCode Problem: 368. Largest Divisible Subset.
 * Problem Link:
 * https://leetcode.com/problems/largest-divisible-subset/description/?envType=daily-question&envId=2025-04-06
 * 
 * Task : such that every pair (answer[i], answer[j]) of elements in this subset satisfies:
 * answer[i] % answer[j] == 0, or answer[j] % answer[i] == 0
 * 
 * Observation : #1 If nums[k] is divisible by all the elements of subset (i...j), then it is sufficient to check that nums[k] % nums[j] == 0. 
 * But for this observation to be true the subset should be in non-decreasing order.
 * 
 * #2 From Approach 1, this problem seems similar to LIS, Longest Increasing Subsequence. The only difference is that instead of checking
 * nums[i] > nums[j], we are checking nums[i] % nums[j] == 0. Also instead of finding the length of the subsequnce, we have to find one of 
 * the subsequence.   
 * 
 * Approach: 
 * 1) Sort the input array. 
 * 2) Build a dp array (similar to LIS), where dp[i] represents the length of the largest divisible subset ending at index i.
 * 3) Keep track of the maxIdx, index where the largest subset ends.
 * 4) maxIdx, will provide size of largest subset. Build a dp array (similar to LIS), where dp[i] represents the length of the largest divisible subset ending at index i.  
 * 
 * Time Complexity: O(n^2). It will still be O(n^2), but this will be faster compare to top-down approach due to absence of recursion overhead.
 * Space Complexity: O(n) where n = input length.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_368_LargestDivisbleSubset_BottomUp {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        // Store length of subset ending at index i.
        int[] memo = new int[n];

        // Mimimum size of each subset is 1. Element itself.
        Arrays.fill(memo, 1);

        // Index of the element where the largest subset ends.
        int maxId = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    memo[i] = Math.max(memo[i], memo[j] + 1);
                }
            }
            // Larger subset is found.
            if (memo[maxId] < memo[i]) {
                maxId = i;
            }
        }

        // Back track from the end of the largest subset, and create the result.
        // Value at each index of memo also represents its position in the subset.
        List<Integer> result = new ArrayList<>();
        int largestSubSet = memo[maxId];
        for (int pos = maxId; largestSubSet > 0 && pos >= 0; pos--) {
            if (nums[maxId] % nums[pos] == 0 && memo[pos] == largestSubSet) {
                result.add(nums[pos]);
                largestSubSet--;
                maxId = pos;
            }
        }
        return result;
    }

}
