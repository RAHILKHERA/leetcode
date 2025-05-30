package Week22_2025;

/**
 * @RAHILKHERA
 *
 * LeetCode Problem: 2359 Find closest node to given two nodes. 
 * Problem Link: https://leetcode.com/problems/find-closest-node-to-given-two-nodes/?envType=daily-question&envId=2025-05-30
 *
 * Input:
 * - Integer array 1D: edges
 * - Integer: node1
 * - Integer: node2
 *
 * Constraints:
 * n == edges.length
 * 2 <= n <= 10^5
 * -1 <= edges[i] < n
 * edges[i] != i
 * 0 <= node1, node2 < n
 * 
 * Definition: 
 * - Directed graph of n nodes from 0 to n - 1, where each node has at most one outgoing edge. 
 * - edges[idx] => there is an edge from idx to edge[idx]; if no outgoing edge, then edge[idx] = -1. 
 * - Cycles may exist in the graph. 
 *
 * Task: Return the index of a node such that it is reachable from both node1 and node2. 
 * - Distance between node & node1 = d1.
 * - Distance between node & node2 = d2.
 * - Minimize Max(d1, d2).
 * - If multiple indices are available, return the smallest index. 
 *
 * Observations: 
 * #1. The first requirement is that `node` should be reachable from both node1 and node2. 
 *    => Each edge is equally weighted (i.e., 1) and it is a directed graph. 
 *    => A traversal with edge count will provide the distance of each node from node1 and node2. 
 *    => Traversal needs to be done twice: first starting from node1 and second starting from node2. 
 * #2. Requires two arrays, distances1 and distances2:
 *    => distances1 to calculate the distance of each node from node1, distances2 to calculate the distance of each node from node2. 
 *    => Initialize both arrays with -1. If after the traversal, an element is -1, then that node is unreachable; otherwise, it will represent the distance to the node. 
 *    => While traversing, if distances[idx] != -1, then it is already visited; avoid it. 
 * #3. Traverse both the distances arrays: 
 *    => if distances1[idx] != -1 and distances2[idx] != -1, then idx is reachable from both node1 and node2. 
 *    => score[idx] = max(distances1[idx], distances2[idx]);
 *    => Need to minimize score across the graph, and return the node with the minimum index.           
 * 
 * Approach: 
 * 1. Use BFS for traversal of the graph.
 *    => Traverse starting from node1. 
 *    => Traverse starting from node2. 
 *    => edge = 0 => number of edges from node1. As all nodes have only one outgoing edge, this will be the distance. 
 *    => Queue for BFS.
 *    => If currentNode == -1, it is an invalid node; no need to process. 
 *    => If distances[currentNode] != -1, the node is already visited; no need to process. 
 *    => distances[currentNode] = edge. Push the next node to the queue. Increase the edge count. 
 * 2. For each node `idx` of the graph: 
 *    => if distances1[idx] != -1 and distances2[idx] != -1 => node idx is reachable from both node1 and node2. 
 *    => score[idx] = max(distances1[idx], distances2[idx]);
 *    => Keep track of minimumScore and the index it belongs to. If at any stage a score[idx] smaller than minimumScore is found, update both values. 
 *    => Initialize minimumScore by n as there are n-1 edges in the graph and a maximum of n-1 edges can be present. Hence, `n` is safe. 
 * 
 *        
 * Time Complexity: O(n)
 * |          Component                                    |   Time                             |
 * | ----------------------------------------------------- | ---------------------------------- |
 * | BFS with node1                                        | O(n + n - 1) => O(2n - 1) => O(n)  |
 * | BFS with node2                                        | O(n + n - 1) => O(2n - 1) => O(n)  |
 * | Distance calculation                                  | O(n)                               |
 * |-------------------------------------------------------|------------------------------------|
 * | Total Complexity                                      | O(n), n = nodes, n - 1 = edges     |
 * 
 * Space Complexity: O(n)
 * |          Component                                    |   Space                            |
 * | ----------------------------------------------------- | ---------------------------------- |
 * |  distances1 array                                     | O(n)                               |
 * |  distances2 array                                     | O(n)                               |
 * |-------------------------------------------------------|------------------------------------|
 * | Total Complexity                                      | O(n + n) => O(2n) => O(n)          |
 * 
 * Other Approach:
 * LeetCode_2359_FindClosestNodeToGivenTwoNodes_ApproachDFS.java
 */


import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

public class LeetCode_2359_FindClosestNodeToGivenTwoNodes_ApproachBFS {

    @Test
    public void test1() {
        assertEquals(2, closestMeetingNode(new int[] { 2, 2, 3, -1 }, 0, 1));
    }

    @Test
    public void test2() {
        assertEquals(2, closestMeetingNode(new int[] { 1, 2, -1 }, 0, 2));
    }

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;

        int[] distance1 = bfs(edges, node1);
        int[] distance2 = bfs(edges, node2);

        int nodeIdx = -1;
        int minScore = n;
        for (int idx = 0; idx < n; idx++) {
            if (distance1[idx] == -1 || distance2[idx] == -1) {
                continue;
            }

            int maxDistance = Math.max(distance1[idx], distance2[idx]);
            if (maxDistance < minScore) {
                minScore = maxDistance;
                nodeIdx = idx;
            }
        }

        return nodeIdx;
    }

    private int[] bfs(int[] edges, int node) {
        int n = edges.length;
        int[] distances = new int[n];
        Arrays.fill(distances, -1);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        distances[node] = 0;

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            int nextNode = edges[currentNode];
            if (nextNode != -1 && distances[nextNode] == -1) {
                distances[nextNode] = distances[currentNode] + 1;
                queue.offer(nextNode);
            }
        }
        return distances;
    }
}
