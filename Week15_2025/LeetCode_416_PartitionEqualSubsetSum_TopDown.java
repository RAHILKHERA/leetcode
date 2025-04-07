package Week15_2025;

public class LeetCode_416_PartitionEqualSubsetSum_TopDown {

    /**
     * LeetCode Problem: 416. Partition Equal Subset Sum
     * Problem Link:
     * https://leetcode.com/problems/partition-equal-subset-sum/submissions/1599285750/?envType=daily-question&envId=2025-04-07
     * 
     * Task: Determine if the input array can be partitioned into two subsets with
     * equal sum.
     * 
     * Observation :
     * #1 To divide in two equal halves, the total sum should be even. If it is odd,
     * it is impossible.
     * #2 To create a subset, for each element have an option to include(take) / not
     * include(skip) in the subset.
     * #3 This points towards classic take/skip dynamic programming solution.
     * 
     * 
     * Approach:
     * #1 Find sum of all the elements of the input.
     * #2 If sum is odd, it cannot be divided. If sum is even, try to find
     * partition.
     * #3 If any subset is found, whose summation is half of total sum, it can be
     * concluded that the parttion is possible.
     * 
     * For each element, there are two branches, either take it or skip it. If
     * subset total from any of the branch equals half of total sum (target), the
     * answer is
     * true.
     * 
     * Memoization: The DP state is defined by two parameters — the current index
     * (idx) and the running sum (currentSum).
     * 
     * The recursion tree can be pruned, by prechecking, that whether currentSum +
     * nums[idx] <= target, before calling for take.
     * If running sum is already equal to target, no further processing is required.
     * 
     * Time Complexity: O(n * sum)
     * Space Complexity: O(n * sum) where n = input length, sum = summation of all
     * elements.
     */

    Boolean[][] memo;

    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 == 1) {
            return false;
        }

        int target = sum / 2;
        memo = new Boolean[n][target + 1];

        return solve(nums, target, 0, 0);
    }

    private boolean solve(int[] nums, int target, int currentSum, int idx) {

        if (nums.length == idx) {
            return target == currentSum;
        }

        if (target == currentSum) {
            return true;
        }

        // memo[idx][currentSum] = true means: from index idx, it is possible to form
        // currentSum.
        if (memo[idx][currentSum] != null) {
            return memo[idx][currentSum];
        }

        // Take
        boolean take = false;

        if (currentSum + nums[idx] <= target) {
            take = solve(nums, target, currentSum + nums[idx], idx + 1);
        }

        if (take) {
            memo[idx][currentSum] = true;
            return true;
        }

        // Skip
        return memo[idx][currentSum] = solve(nums, target, currentSum, idx + 1);

    }

}
