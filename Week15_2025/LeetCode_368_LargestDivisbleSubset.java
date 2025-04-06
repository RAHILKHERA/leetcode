package Week15_2025;

/**
 * LeetCode Problem: 368. Largest Divisible Subset.
 * Problem Link:
 * https://leetcode.com/problems/largest-divisible-subset/description/?envType=daily-question&envId=2025-04-06
 * 
 * Task : such that every pair (answer[i], answer[j]) of elements in this subset satisfies:
 * answer[i] % answer[j] == 0, or answer[j] % answer[i] == 0
 * 
 * Observation : If nums[k] is divisible by all the elements of subset (i...j), then it is sufficient to check that nums[k] % nums[j] == 0. 
 * But for this observation to be true the subset should be in non-decreasing order. 
 * 
 * Approach: 
 * 
 * 1) Sort the input array. 
 * 2) Now we have two options either select element at index "i" and try to expand the subset by satisfying the condition. 
 * 
 * This reduces the problem to a standard dynamic programming formulation with two choices at each step: take or skip the current element.
 * From our observation, it's clear that to determine whether the current element can be added, we need to track the last element selected 
 * in the subset.
 * 
 * Option Skip : If we skip the current element, the last element (prevIndex) remains same for next cycle of the recursion. 
 * Option Take : If we take the current element, the last element should be updated to current element. 
 * 
 *    
 * Memoization: The DP state is defined by two parameters — the current index (idx) and the index of the last selected number (prevIdx).
 * 
 * Time Complexity: O(n^2)
 * Space Complexity: O(n^2) where n = input length.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode_368_LargestDivisbleSubset {

    Map<String, List<Integer>> memo = new HashMap<>();

    public List<Integer> largestDivisibleSubset(int[] nums) {

        Arrays.sort(nums);
        // At starting, there is no previous element, hence -1.
        return solve(nums, 0, -1);
    }

    private List<Integer> solve(int[] nums, int idx, int prevIdx) {

        if (idx == nums.length) {
            return new ArrayList<>();
        }

        String key = idx + "#" + prevIdx;
        if (memo.containsKey(key))
            return memo.get(key);

        // Option 1: Skip current number
        List<Integer> skip = solve(nums, idx + 1, prevIdx);

        // Option 2: Take current number if divisible with previous
        List<Integer> take = new ArrayList<>();
        if (prevIdx == -1 || nums[idx] % nums[prevIdx] == 0) {
            take = new ArrayList<>(solve(nums, idx + 1, idx));
            take.add(nums[idx]); // prepend
        }

        List<Integer> result = take.size() > skip.size() ? take : skip;
        memo.put(key, result);
        return result;
    }
}
