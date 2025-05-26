package Week22_2025;

import static org.junit.Assert.assertEquals;

/**
 * @RAHILKHERA
 *
 * LeetCode Problem: 1857 Largest Color Value in a directed graph. 
 * Problem Link: https://leetcode.com/problems/largest-color-value-in-a-directed-graph/?envType=daily-question&envId=2025-05-26
 *
 * Input:
 * - String colors.
 * - Integer 2D array edges. 
 *
 * Constraints:
 * n == colors.length
 * m == edges.length
 * 1 <= n <= 10^5
 * 0 <= m <= 10^5
 * colors consists of lowercase English letters.
 * 0 <= aj, bj < n
 * 
 * Definition: Color Value of a path: The color value of the path is the number of nodes that are colored with the most frequently occurring color along that path.
 *
 * Task: Compute the largest color value of any valid path in the given graph or -1 if the graph has a cycle. 
 *
 * Observations: 
 * #1. Directed graph with n - 1 edges, and nodes are tagged from 0 to n - 1. 
 * #2. The first requirement is that the graph should be cycle-free; if it has a cycle, return -1. 
 * #3. The task is to find the maximum frequency of a color in a valid path. 
 *    => Requires every path to be traversed in an order such that the maximum number of nodes are covered, to get the largest color value. 
 *    => This points to topological sort over a directed graph as it also checks for the existence of a cycle.  
 *    => In topological sort, if all the nodes are not visited, then the graph has a cycle. 
 * #4. When traversing from node `x` to node `y`, 
 *    => The counts of the colors at node x are transferred to node y, except for one color, i.e., the color of node y. 
 *    => The count of the color of node y will be incremented by 1 as node y is included in the path. 
 *    => There could be cases where there are multiple paths to reach node x, resulting in multiple values for each color at node x.
 *    => The maximum of all these values should be chosen before traversing to the next node.
 * 
 * Data structures:
 * 1. A map of integer to list of integers, to create the adjacency matrix.
 * 2. A 1D integer array (inDegree) of size n for counting the in-degrees of each node.
 * 3. A standard queue for topological sort. 
 * 4. A 2D integer array (dp) of size n * k, to store the count of each color at each node. 
 *    => The number of colors is bounded by the number of lowercase English letters.
 *    => k = 26.  
 *    => dp[x][color] = maximum count of the color of all the paths ending at node `x`. 
 * 
 * Approach: 
 * 1. Create the adjacency matrix by traversing through the edges. Additionally, compute the in-degrees of each node.
 * 2. Implement standard topological sort with the following additional modifications:
 *    => Traverse the inDegree array and add the nodes with no incoming edges to the queue.
 *         -> These will be the starting nodes of every valid path. 
 *    => Use a variable (visitedNodes) to count the number of visited nodes. If this is not equal to the number of nodes (n), then the graph has a cycle and you should return -1.
 *    => Fetch the node `node` from the front of the queue. 
 *       -> This node's color could be the greatest value.
 *       -> if largestColorValue < dp[node][colors.charAt(node) - 'a'] => largestColorValue = dp[node][colors.charAt(node) - 'a'].   
 *    => As in standard topological sort, decrement the in-degree of all the neighbors of the node.
 *       -> If any node's degree becomes 0, add it to the queue.
 *       -> In addition, update the count of each color for the neighboring node using the values of the colors for the current node. 
 *       -> Also, increase the count of the color of the neighboring node by 1, as the neighboring node can be part of the path.
 *
 * Time Complexity: O(E + V)
 * |          Component                                    |   Time                             |
 * | ----------------------------------------------------- | ---------------------------------- |
 * | Create Adjacency Matrix                               | O(M)                               |
 * | Find root nodes (i.e., nodes with in-degree 0)        | O(N)                               |
 * | Traversal, in each traversal modifying count of all   |                                    |
 * | colors. Color count `K` = 26.                         | O(N + K*M) => O(N + M)             |
 * |-------------------------------------------------------|------------------------------------|
 * | Total Complexity                                      | O(N + M)                           |
 * 
 * Space Complexity: O(E + V)
 * |          Component                                    |   Space                            |
 * | ----------------------------------------------------- | ---------------------------------- |
 * |  Store in-degree array                                | O(N)                               |
 * |  Store Adjacency Matrix                               | O(N + M)                           |
 * |  Memoization 2D (K = 26)                              | O(N * K) => O(N * 26) => O(N)      | 
 * |-------------------------------------------------------|------------------------------------|
 * | Total Complexity                                      | O(N + M)                           |
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import org.junit.Test;

public class LeetCode_1857_LargestColorValueInADirectedGraph {

    @Test
    public void test1() {
        assertEquals(3, largestPathValue("abaca", new int[][] { { 0, 1 }, { 0, 2 }, { 2, 3 }, { 3, 4 } }));
    }

    @Test
    public void test2() {
        assertEquals(-1, largestPathValue("a", new int[][] { { 0, 0 } }));
    }

    @Test
    public void test3() {
        assertEquals(3, largestPathValue("hhqhuqhqff", new int[][] { { 0, 1 }, { 0, 2 }, { 2, 3 }, { 3, 4 }, { 3, 5 },
                { 5, 6 }, { 2, 7 }, { 6, 7 }, { 7, 8 }, { 3, 8 }, { 5, 8 }, { 8, 9 }, { 3, 9 }, { 6, 9 } }));
    }

    @Test
    public void test4() {
        assertEquals(3, largestPathValue("hhqhuqhqff", new int[][] { { 0, 1 }, { 0, 2 }, { 2, 3 }, { 3, 4 }, { 4, 5 },
                { 5, 6 }, { 5, 7 }, { 7, 8 }, { 6, 9 } }));
    }

    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        int[] inDegree = new int[n];

        Map<Integer, List<Integer>> adjList = new HashMap<>();

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adjList.computeIfAbsent(u, node -> new ArrayList<>()).add(v);
            inDegree[v]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        int[][] dp = new int[n][26];
        for (int idx = 0; idx < n; idx++) {
            if (inDegree[idx] == 0) {
                queue.offer(idx);
                dp[idx][colors.charAt(idx) - 'a']++;
            }
        }

        int visitedNodes = 0;
        int largestPathValue = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            visitedNodes++;
            largestPathValue = Math.max(largestPathValue, dp[node][colors.charAt(node) - 'a']);
            if (adjList.containsKey(node)) {
                for (int neighbourNode : adjList.get(node)) {
                    int neighbourColor = colors.charAt(neighbourNode) - 'a';
                    for (int color = 0; color < 26; color++) {
                        dp[neighbourNode][color] = Math.max(dp[neighbourNode][color],
                                dp[node][color] + ((color == neighbourColor) ? 1 : 0));
                    }

                    inDegree[neighbourNode]--;
                    if (inDegree[neighbourNode] == 0) {
                        queue.offer(neighbourNode);
                    }
                }
            }
        }

        if (visitedNodes != n) {
            return -1;
        }

        return largestPathValue;
    }
}