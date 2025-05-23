package Week21_2025;

/**
 * @RAHILKHERA
 *
 * LeetCode Problem: 3362 Zero transformation array 3.
 * Problem Link: https://leetcode.com/problems/zero-array-transformation-iii/description/?envType=daily-question&envId=2025-05-22
 *
 * Input:
 * - Integer array nums of size n. 
 * - Integer 2D array queries of size q.
 *
 * Constraints:
 * 1 <= nums.length <= 10^5
 * 0 <= nums[i] <= 10^5
 * 1 <= queries.length <= 10^5
 * queries[i].length == 2
 * 0 <= li <= ri < nums.length
 *
 * Defination : Zero Array : All the elements of the array are 0. 
 * => Operation : i) Decrement the value at each index in the range [li,ri] in nums by atmost 1.
 * 
 * Task:  Maximum number of elements that can be removed from queries, such that array nums can be still converted to zero array from remaining queries. 
 *  
 * Observations:
 * 1) Unlike previous zero transformation problems, here query doesn't need to be applied sequentially. 
 *    => So Binary Search over answer technique cannot be used. 
 *    => Failed approach : Query sorted in descending order on the basis of difference between end position and start position. 
 *    => Note : Had missed this observation and that's the reason which caused wrong submission.  Refer test case 4, 5, 6. 
 * 2) Maximum number of elements that can be removed from queries, such that array nums can be still converted to zero array from remaining queries
 *    => Find minimum number of queries required to transform array `nums` to zero array. 
 * 3) If at index `idx`, nums[idx] > 0, then nums[idx] is the required number of operations to transform it to 0. 
 *    => so a straight forward approach is that select the query which have start/left i.e. queries[queryIdx][0] = idx. 
 *    => If total number of such quries are greater than equal to nums[idx], than that element can be transformed to 0. Else return -1. 
 *    => There is need to group the queries on the basis of start/left point of the query. 
 *    => Sort the queries array on the basis of left point.
 * 4) Using minimum queries, needs to transform the array.
 *    => Greedily selecting the query the farthest end/right point of the query. 
 *    => This will make sure that maximum number of element's value is reduced by 1. 
 *    => To continuosly fetch query with start point idx and farthest end point, max heap/priority queue with reverse ordering can be used. 
 * 5) In addition to sorting queries and using priority queue to select the query with farthest point,
 *    => Like previous zero transfomation problems, difference array technique can be used. 
 *    => Difference array `diff` technique has following 2 stages :
 *       i) diff[left]++ and diff[right + 1]--  => The effect of query starts from left and ends at right. So revert the effect starting from right + 1. 
 *      ii) prefix sum over `diff` array =>   Cummulative effect of all queries on each element. 
 *
 * Approach:
 * 1. Sort queries array on the basis of the start/left point. 
 * 2. Create max heap/priority queue with reverse ordering. 
 * 3. Difference array `diff`, to reverse the effect of query after processing the end of the query. 
 * 4. Variable operations, to keep the track of the prefix sum over `diff`. 
 * 5. Traverse through the `nums` array, for every element at index `idx`.
 *    => The diff[idx] will be either negative or 0. If there is a query ending at idx - 1, idx will be negative else it will be 0. 
 *    => Perform sum of operations and diff[idx], this will reduce the number of operations, as the previous queries ending at idx - 1 should not have effect on idx.   
 *    => Traverse the queries, and add query whose start/left point is same as `idx` to the priority queue. 
 *    => Until operations i.e. number of executed queries are less than nums[idx], it cannot be converted to zero. 
 *    => Hence fetch the query from the queue, if the end point is after current element position i.e. query can be applied to the current element. 
 *    => Increase the operations. Also decrease diff[endPoint + 1] by 1. 
 *    => In case, the queue is empty or no query is available which can be applied and operations is still less than nums[idx] return -1. 
 * 6. After the travrsal, number of operations remaining in the heap/priority queue are the maximum number of operations that can be removed. 
 *   
 * Time Complexity: O(N + QlogQ)
 * |          Component                   |   Time                                                  |
 * | -------------------------------------| ------------------------------------------------------  |
 * | Sort queries on basis of start point |   O(QlogQ)                                              |
 * | Traverse nums                        |   O(N)                                                  |
 * | Adding query to queue                |   O(logQ)                                               |
 * | Polling query from queue             |   O(logQ)                                               |
 * | Adding and polling perfomed Qtimes   |   O(Q * 2 * logQ)                                       |
 * |--------------------------------------|---------------------------------------------------------|
 * | Total Complexity                     | O(N + QlogQ + 2QlogQ) => O(N + 3*QlogQ) => O(N + QlogQ) |   
 *
 * Space Complexity: O(N + Q + logQ)
 * |          Component                   |   Space                                                 |
 * | -------------------------------------| ------------------------------------------------------  |
 * | Sort queries                         |   O(logQ)                                               |
 * | Difference array                     |   O(N)                                                  |
 * | Priority Queue to store queries      |   O(Q)                                                  |
 * |--------------------------------------|---------------------------------------------------------|
 * | Total Complexity                     | O(N + Q + logQ)                                         |
 * 
 */
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.PriorityQueue;

import org.junit.Test;

public class LeetCode_3362_ZeroTransformationArrayIII {

    @Test
    public void test1() {
        assertEquals(1,
                maxRemoval(new int[] { 2, 0, 2 }, new int[][] { { 0, 2 }, { 0, 2 }, { 1, 1 } }));
    }

    @Test
    public void test2() {
        assertEquals(2,
                maxRemoval(new int[] { 1, 1, 1, 1 }, new int[][] { { 1, 3 }, { 0, 2 }, { 1, 3 }, { 1, 2 } }));
    }

    @Test
    public void test3() {
        assertEquals(-1,
                maxRemoval(new int[] { 1, 2, 3, 4 }, new int[][] { { 0, 3 } }));
    }

    @Test
    public void test4() {
        assertEquals(2,
                maxRemoval(new int[] { 0, 3 }, new int[][] { { 0, 1 }, { 0, 0 }, { 0, 1 }, { 0, 1 }, { 0, 0 } }));
    }

    @Test
    public void test5() {
        assertEquals(0,
                maxRemoval(new int[] { 3, 2 }, new int[][] { { 0, 1 }, { 0, 1 }, { 0, 1 } }));
    }

    @Test
    public void test6() {
        assertEquals(2,
                maxRemoval(new int[] { 0, 0, 1, 1, 0 }, new int[][] { { 3, 4 }, { 0, 2 }, { 2, 3 } }));
    }

    public int maxRemoval(int[] nums, int[][] queries) {

        int n = nums.length;
        int q = queries.length;
        Arrays.sort(queries, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        int[] diff = new int[n + 1];
        int operations = 0;
        int queryIdx = 0;
        for (int pos = 0; pos < n; pos++) {

            operations += diff[pos];

            while (queryIdx < q && queries[queryIdx][0] == pos) {
                queue.offer(queries[queryIdx][1]);
                queryIdx++;
            }

            while (operations < nums[pos] && !queue.isEmpty() && queue.peek() >= pos) {
                operations++;
                int end = queue.poll() + 1;
                diff[end]--;
            }

            if (operations < nums[pos]) {
                return -1;
            }
        }

        return queue.size();
    }
}