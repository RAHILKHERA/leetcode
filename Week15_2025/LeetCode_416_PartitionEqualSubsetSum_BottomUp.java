package Week15_2025;

public class LeetCode_416_PartitionEqualSubsetSum_BottomUp {

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
     * #4. This is bottom-up approach, the recursion relation is as follows :
     * a) skip, memo[idx][currentSum] = memo[idx+1][currentSum]. As currentElement
     * is skipped, the currentSum won't change.
     * b) take, memo[idx][currentSum] = memo[idx][currentSum + nums[idx]]. As
     * currentElement is included, the currentSum will be incremented by current
     * element. But this only applies in case when summation is lower than target.
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
        boolean[][] memo = new boolean[n + 1][target + 1];
        memo[n][target] = true;
        for (int idx = n - 1; idx >= 0; idx--) {
            for (int currentSum = 0; currentSum <= target; currentSum++) {
                boolean skip = memo[idx + 1][currentSum];
                boolean take = false;
                if (currentSum + nums[idx] <= target) {
                    take = memo[idx + 1][currentSum + nums[idx]];
                }
                memo[idx][currentSum] = take || skip;
            }
        }
        return memo[0][0];
    }
}
