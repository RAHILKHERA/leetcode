package Week21_2025;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * @RAHILKHERA
 * 
 * LeetCode Problem: 3355 Zero Transformation Array 1 
 * Problem Link:
 * https://leetcode.com/problems/zero-array-transformation-i/description/?envType=daily-question&envId=2025-05-20
 *
 * Input :
 * - Integer array nums of size n. 
 * - Integer 2D array queries of size q.
 * 
 * Definition : Operation, Each query is represents as (li, ri) where li = starting index and ri = ending index. 
 * - Select a subset of indicies within the range and decrement the values at the selected indices by 1. 
 * - Zero Array : An array where all elements are 0. 
 *             
 * Constraints: 
 * 1 <= nums.length <= 10^5
 * 0 <= nums[i] <= 10^5
 * 1 <= queries.length <= 10^5
 * queries[i].length == 2
 * 0 <= li <= ri < nums.length
 * 
 * Task:  After processing all the queries sequentially, check if the array can be converted to zero array. 
 *
 * Observations:
 * #1. All the queries need to be processed sequentially and then final state of the array needs to be arrived.
 *     => This is an important point, to decide to go with difference array technique and not with segment trees. 
 * #2. So no need to fetch intermediaryresults that is after applying some of the queries fetching of result is not requried. 
 * #3. Operation to be performed, reducing value of the element by 1 for the index in the range. 
 *     => So whether each query perfomed separately or applying the total final effect of all queries over the array will result in state of the array. 
 * #4. As there are no intermediate results required, no need to use segment tree. Difference array technique can be used. 
 * #5. In difference array technique :
 *     => If query range [l,r], increase difference[l] by 1 as this is starting point and it represents the effect of query from this point. 
 *     => decrease difference[r + 1] by 1, as the query effect ends at r. So the effect which started at `l` should be reversed at `r + 1`.
 *     => Once all the query effects are applied. Compute the prefix sum of each index/position. 
 *     => The prefix sum at each index, represents cumulative effect of all the queries. 
 * #6. In this case, prefix sum over difference array will represent how much maximum element at index idx can be reduced. 
 *     => If all the elements of the nums are lesser than their corresponding prefix sum of difference array
 *     => Then array can be transformed to zero array else not. 
 * 
 * Approach:
 * 1. Create and compute difference array of size n + 1 (diff).
 *    => diff[query[0]]++
 *    => diff[query[1] + 1]++
 *    => n + 1 : As the maximum value of ri i.e. query[1] will be n - 1. Hence effect of query will be reversed at index = n. 
 *    => Difference array stores cumulative effect of each query at every index. 
 * 2. Compute prefix sum over difference array. 
 * 3. Traverse nums array and check following :
 *    => For index idx, if nums[idx] > diff[idx], return false. 
 *    => nums[idx] - diff[idx] > 0 hence element at idx cannot be transformed to 0. 
 *    => if all the elements satisfy nums[idx] < diff[idx], return true. 
 * 
 * Time Complexity: O(N + Q)
 * - Process all the queries and generate diff array. O(Q) => Q = no. of queries. 
 * - Compute prefix sum to reflect total effect of all queries at each index. O(N) => N = no. of elements. 
 * - Traverse nums to check if the diff is greater or not. O(N) => N 
 * - Final Complexity : O(N + N + Q) => O(2N + Q) => O(N + Q).
 *             
 * Space Complexity: O(N)
 * - Diff array is used of size N + 1.
 * - Final Complexity: O(N + 1) => O(N).
 */

public class LeetCode_3355_ZeroTransformationArrayI {

    @Test
    public void test1() {
        assertTrue(isZeroArray(new int[] { 1, 0, 1 }, new int[][] { { 0, 2 } }));
    }

    @Test
    public void test2() {
        assertFalse(isZeroArray(new int[] { 4, 3, 2, 1 }, new int[][] { { 1, 3 }, { 0, 2 } }));
    }

    public boolean isZeroArray(int[] nums, int[][] queries) {

        int n = nums.length;

        int[] diff = new int[n + 1];
        for (int[] query : queries) {
            int left = query[0];
            int right = query[1];
            diff[left]++;
            diff[right + 1]--;
        }

        for (int idx = 1; idx < n; idx++) {
            diff[idx] += diff[idx - 1];
        }

        for (int idx = 0; idx < n; idx++) {
            if (nums[idx] > diff[idx]) {
                return false;
            }
        }
        return true;
    }
}