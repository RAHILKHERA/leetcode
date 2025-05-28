package Week22_2025;

/**
 * @RAHILKHERA
 *
 * LeetCode Problem: 3372 Maximize the number of target nodes after connecting trees 1. 
 * Problem Link: https://leetcode.com/problems/maximize-the-number-of-target-nodes-after-connecting-trees-i/description/?envType=daily-question&envId=2025-05-28
 *
 * Input:
 * - 2D Integer Array : edges1 
 * - 2D Integer Array : edges2
 * - Integer : k    
 *
 * Constraints:
 * 2 <= n, m <= 1000
 * edges1.length == n - 1
 * edges2.length == m - 1
 * edges1[i].length == edges2[i].length == 2
 * edges1[i] = [ai, bi]
 * 0 <= ai, bi < n
 * edges2[i] = [ui, vi]
 * 0 <= ui, vi < m
 * The input is generated such that edges1 and edges2 represent valid trees.
 * 0 <= k <= 1000
 * 
 * Definition : Target Node : Node u is target to node v if the number of edges on the path from u to v is less than equal to k. A node is always target to itself. 
 * Task: Return an array of n integers answer, where answer[i] is the maximum possible number of nodes target to node i of the first tree if you have to connect one node from the first tree to another node in the second tree.
 *  
 * Note : Queries are independent from each other. That is, for every query you will remove the added edge before proceeding to the next query.
 * 
 * Observations: 
 * #1. For each node in first tree `tree1` find out maximum number of target nodes by connecting from one node from `tree1` to one node `tree2`.
 *     => Before processing for the next node, remove the added edge.   
 *     => Same tree structures are available before each node. 
 * #2. Target node (u,v) => Number of edges on the path from u to v must be less than equal to k. 
 *     => Total target nodes = number of target nodes with k edges with in tree1  + maximum of number of target nodes with k - 1 edges in tree2.
 *     => k - 1 edges in tree2, as 1 edge will be used in connecting a node from tree1 to tree2. 
 *     => The node from tree2 having the maximum number of target nodes with k - 1 edges will be used to connect with each node in tree1. 
 *     => This is possible because queries are independent from each other.   
 * #3. Using either BFS or DFS, target nodes for each node in trees can be found.
 *     => BFS/DFS should be pruned by k. That is only k edges in tree1 and k-1 edges in tree2 needs to be traversed starting from each node. 
 *     => BFS/DFS needs to be executed for total n + m times.
 * 
 * Approach:
 * 1. In this appraoach, BFS will be used. 
 * 2. Create adjacency list using map of integer vs list for both the trees by traversing edges1 and edges2. 
 * 3. Starting from each node of tree1, perform BFS traversal with capped at k edges
 *    => BFS from each node is required as our traversal is capped by number of edges i.e once number of edges equal to k are covered, 
 *       traversal is stopped even if nodes are left to be visited. 
 *    => The results of each BFS iteration will be store in resultant array of size n. 
 *    => This will be the minimum value of target nodes for each node in tree1. 
 * 4. Starting from each node of tree2, perform BFS traversal with capped at k - 1 edges. 
 *    => Store the target nodes from tree2 in a list. 
 *    => Find the node with maximum target nodes (maxTargetNode). This will be the node with which all the nodes of tree1 will make connection. 
 *    => This means each of the target nodes in the resultant array will be increased by maxTargetNode. 
 * 
 *
 * Time Complexity: O(n^2 + m^2)
 * |          Component                                    |   Time                             |
 * | ----------------------------------------------------- | ---------------------------------- |
 * | Build adjacency list for tree1                        | O(n)                               |
 * | Build adjacency list for tree2                        | O(m)                               |
 * | For each node in tree1, run BFS.                      | O(n^2)                             |
 * | For each node in tree2, run BFS.                      | O(m^2)                             |
 * | Each BFS iteration for n nodes and n - 1 edges.       | O(n + n - 1) => O(2n - 1) => O(n)  |
 * |-------------------------------------------------------|------------------------------------|
 * | Total Complexity                                      | O(2n^2-n + 2m^2-m) => O(n^2 + m^2) |
 * 
 * 
 * Space Complexity: O(n + m)
 * |          Component                                    |   Time                             |
 * | ----------------------------------------------------- | ---------------------------------- |
 * | Adjacency list tree1                                  | O(n)                               |
 * | Adjacency list tree2                                  | O(m)                               |
 * | BFS over tree1, visited array (tree1 + tree2)         | O(n) + O(m)                        |
 * | BFS queue (tree1 + tree2)                             | O(n) + O(m)                        | 
 * |-------------------------------------------------------|------------------------------------|
 * | Total Complexity                                      | O(n + m)                           |
 *
 * Other Approaches : LeetCode_3372_MaximizeTheNumberOfTargetNodesAfterConnectingTreeI_ApproachDFS.java
 */

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import org.junit.Test;

public class LeetCode_3372_MaximizeTheNumberOfTargetNodesAfterConnectingTreesI_ApproachBFS {

    @Test
    public void test1() {
        assertArrayEquals(new int[] { 9, 7, 9, 8, 8 },
                maxTargetNodes(new int[][] { { 0, 1 }, { 0, 2 }, { 2, 3 }, { 2, 4 } },
                        new int[][] { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 2, 7 }, { 1, 4 }, { 4, 5 }, { 4, 6 } }, 2));
    }

    @Test
    public void test2() {
        assertArrayEquals(new int[] { 6, 3, 3, 3, 3 },
                maxTargetNodes(new int[][] { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 0, 4 } },
                        new int[][] { { 0, 1 }, { 1, 2 }, { 2, 3 } }, 1));
    }

    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int n = edges1.length + 1;
        int m = edges2.length + 1;
        Map<Integer, List<Integer>> tree1 = new HashMap<>();
        Map<Integer, List<Integer>> tree2 = new HashMap<>();

        for (int[] edge : edges1) {
            int u = edge[0];
            int v = edge[1];
            tree1.computeIfAbsent(u, node -> new ArrayList<>()).add(v);
            tree1.computeIfAbsent(v, node -> new ArrayList<>()).add(u);
        }

        for (int[] edge : edges2) {
            int u = edge[0];
            int v = edge[1];
            tree2.computeIfAbsent(u, node -> new ArrayList<>()).add(v);
            tree2.computeIfAbsent(v, node -> new ArrayList<>()).add(u);
        }

        int[] result = new int[n];
        for (int node = 0; node < n; node++) {
            result[node] = getTargets(tree1, n, node, k);
        }

        List<Integer> targetsInTree2 = new ArrayList<>();
        for (int node = 0; node < m; node++) {
            targetsInTree2.add(getTargets(tree2, m, node, k - 1));
        }

        int max = Collections.max(targetsInTree2);

        for (int node = 0; node < n; node++) {
            result[node] += max;
        }

        return result;
    }

    private int getTargets(Map<Integer, List<Integer>> adjList, int nodes, int source, int k) {

        if (k == 0) {
            return 1;
        }

        boolean[] visited = new boolean[nodes];
        Queue<Integer> queue = new LinkedList<>();
        int target = 0;
        visited[source] = true;
        queue.offer(source);
        int level = 0;
        while (!queue.isEmpty() && level <= k) {
            int size = queue.size();
            target += size;
            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                for (int neighbourNodes : adjList.get(node)) {
                    if (!visited[neighbourNodes]) {
                        visited[neighbourNodes] = true;
                        queue.offer(neighbourNodes);
                    }
                }
            }
            level++;
        }
        return target;
    }
}
