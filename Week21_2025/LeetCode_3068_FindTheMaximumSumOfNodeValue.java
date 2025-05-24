package Week21_2025;

/**
 * @RAHILKHERA
 *
 * LeetCode Problem: 3068 Find the maximum sum of node value.
 * Problem Link: https://leetcode.com/problems/find-the-maximum-sum-of-node-values/?envType=daily-question&envId=2025-05-23
 *
 * Input:
 * - Undirected tree with n nodes numbered from 0 to n - 1. 
 * - Integer array nums, represents value at each node. 
 * - Positive Integer k. 
 * - Integer 2D array edges, where edges[i] = [ui, vi] indicates an edge between ui and vi.
 * 
 * Constraints:
 * 2 <= n == nums.length <= 2 * 10^4
 * 1 <= k <= 10^9
 * 0 <= nums[i] <= 10^9
 * edges.length == n - 1
 * edges[i].length == 2
 * 0 <= edges[i][0], edges[i][1] <= n - 1
 * The input is generated such that edges represent a valid tree.
 *
 * Definition : Operations : Choose any edge [u,v] connecting nodes u and v and update their values as follows :
 *  nums[u] = nums[u] XOR k. 
 *  nums[v] = nums[v] XOR k.  
 * 
 * Task:  Maximum possible sum of all the values obtain by performing operation any number of times, possibly 0. 
 *  
 * Observations:
 * 1. Tree is connected, undirected and acyclic => There is always a path between any two nodes (U,V).
 *    => Suppose the length of this path is L and P = {P1, P2, P3 ...., PL-1} denotes set of nodes on this path in the order in which they appear on the path. 
 *    => Let's perform operations on each edge of the path. => L operations will be applied. 
 *    => Except U and V, the operations will be applied twice on each of the node.  => nums[P1] XOR k XOR k = nums[P1].
 *    => Values of U and V will be replaced by nums[U] XOR k and nums[V] XOR k. 
 *    => For any two non-adjacent nodes (U,V) in the tree, their values .will be replaced by their XOR values, as if they are connected. Let's call this operation as effective operation. 
 *    => After performing sequence of effective operations on some pair of nodes, exactly m nodes in the tree have their value replaced with their XOR value. 
 *    => m <= n, where n = number of nodes. effective operations (m) would be even, as in a single operation, XOR is performed on two nodes.  
 *    => Effectively, the `edges` does not play role as tree is connected, undirected and acyclic. 
 *    => So between every pair of nodes has a path which is equivalent to having an edge between every pair of nodes.
 * 2  There are two operation, either perform XOR with k or keep the value as it is. 
 *    => To increase the summation, only increase in value will be helpful. 
 *    => Perform operation on index `idx` if nums[idx] XOR k > nums[idx].
 *    => If operation is performed on index `idx`, contribution to sum  wil be nums[idx] XOR k else it will be nums[idx].  
 * 3. Keep the count of the nodes on which effective operations is applied. (m) 
 *    => If m is even, current sum is the final answer. 
 *    => If m is odd, it needs to be change to make it even, as a single operation is applied to two nodes. Hence odd number of effective operations is not possible. 
 * 4. Case m is odd, 
 *    => Two options, either exclude one node or include one node. 
 *    => Case `Exclude` : One of the node on which operation was applied needs to be reverted. 
 *      -> On applying operation on index `idx`, sum is increased by (nums[idx] XOR k).
 *      -> In case, the operation needs to be reverted, in sum, nums[idx] XOR k will be replaced by nums[idx], 
 *      -> loss = (nums[idx] XOR k) - nums[idx]. 
 *    => Case `Include` : One of the node on which operation was not applied, on that operation will be performed. 
 *      -> In this case too, the value of sum will be reduced. The reason, the operation on this node was not performed in first place as that was reducing value of the node. 
 *      -> On not applying the operation on index `idx`, sum is increased by nums[idx]. 
 *      -> In case, the opeartion needs to be applied, in sum, nums[idx] will be replaced by nums[idx] XOR k. 
 *      -> loss = nums[idx] - (nums[idx] XOR k).
 *    => To maximize the sum, keep track of minimum loss. 
 * 5. After processing all the nodes, if number of effective operations is odd, subtract minimum loss from the sum.   
 *      
 * Approach:
 * 1. Three variables are required, two long and one boolean :
 *    => long sum : To compute the summation, this will have final summation value.
 *    => long minLoss : In case of odd effective operations, this need to be subtracted from sum, this needs to be minimum. 
 *    => boolean evenCount : Every time operation is applied, flip the variable, true => even, false => odd. 
 * 2. Traverse the `nums` array,
 *    => if (nums[idx] XOR k) > nums[idx], increase the sum by nums[idx] XOR k and flip the evenCount. 
 *    => else, increase the sum by nums[idx]. 
 *    => track the minimum loss, minLoss = min(minLoss, |nums[idx] - (nums[idx] XOR k)|).
 *    => minimum loss in both the cases i.e. include/exclude, is reverse of each other hence merging both equations with absolute operation. 
 * 3. If evenCount is false
 *    => odd effective operations were applied. 
 *    => subtract minimum loss from the sum.      
 * 4. Return sum.     
 *   
 * Time Complexity: O(N)
 * |          Component                              |      Time      |
 * | ------------------------------------------------| ---------------|
 * | Single Pass of values array `nums`, length = n  |      O(N)      |
 * | Other operations - constant time                |      O(1)      |
 * |-------------------------------------------------|----------------|
 * | Total Complexity                                |      O(N)      |   
 *
 * Space Complexity: O(1)
 * - No extra space proportional to input size is used. 
 */

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LeetCode_3068_FindTheMaximumSumOfNodeValue {

    @Test
    public void test1() {
        assertEquals(6, maximumValueSum(new int[] { 1, 2, 1 }, 3, new int[][] { { 0, 1 }, { 0, 2 } }));
    }

    @Test
    public void test2() {
        assertEquals(9, maximumValueSum(new int[] { 2, 3 }, 7, new int[][] { { 0, 1 } }));
    }

    @Test
    public void test3() {
        assertEquals(42, maximumValueSum(new int[] { 7, 7, 7, 7, 7, 7 }, 7,
                new int[][] { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 0, 4 }, {0, 5} }));
    }

    public long maximumValueSum(int[] nums, int k, int[][] edges) {

        long sum = 0;
        long minLoss = Long.MAX_VALUE;
        boolean evenCount = true;
        for (int num : nums) {
            if ((num ^ k) > num) {
                sum += (num ^ k);
                evenCount = !evenCount;
            } else {
                sum += num;
            }
            minLoss = Math.min(minLoss, Math.abs(num - (num ^ k)));
        }

        if (!evenCount) {
            sum -= minLoss;
        }

        return sum;
    }
}