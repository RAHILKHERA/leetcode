package Week19_2025;

/**
 * @RAHILKHERA
 * 
 * LeetCode Problem: 33412 Find minimum time to reach last room 2. 
 * Problem Link:https://leetcode.com/problems/find-minimum-time-to-reach-last-room-ii/?envType=daily-question&envId=2025-05-08
 *
 * Input : 
 *  - A dungeon is given with n x m rooms arranged as grid. 
 *  - Integer 2D array moveTime of size n x m. 
 * 
 * Definition :
 * -> moveTime[i][j] represents the minimum time in seconds when starting to move to that room.
 * -> From one room/cell, it can be moved either horizontally or vertically located cell/room.    
 * -> Start from the room at (0,0) at time = 0. 
 * -> Moving from one room to another room takes **one second for one move and two seconds for next, alternating between the two**. 
 * 
 * Constraints:
 * 2 <= n == moveTime.length <= 750
 * 2 <= m == moveTime[i].length <= 750
 * 0 <= moveTime[i][j] <= 10^9
 * 
 * Task: Find the minimum time to reach last room i.e at (n-1, m-1). 
 *
 * Observations:
 * #1. Need to traverse from first room (0,0) to last room (n-1, m-1) in least time.
 * #2. Each room/cell of the grid can be considered as node of the graph. 
 *     => Current room is connected with it's horizonatal and vertical cells. 
 *     => The cell value that is the time required to move to that room represents a weighted edge. 
 * #3. This problem is reduced to finding shortest path from source (0,0) to target (n-1, m-1).
 *     => Instead of distance, shortest time will be calculated. 
 *     => Dijikstra's Algorithm for shortest path can be used.
 * #4. Time to move from one room (i',j') to another room (i, j), alternates between 1 second and 2 seconds :
 *     => For the odd number of moves, time to move will be 1 second while for even number of moves the time will be the 2 seconds. 
 *     => Since the moment happens on a two - dimensional grid, only one of the coordinate changes by one in any of the four directions. 
 *     => Parity of (i + j) changes with every move. 
 * #5. If the time required to reach current room is x and time for adjacent room or cell is y : 
 *     Time to reach neighbor = max(current room's time, moveTime of neighbor) + move cost based on (row+col) parity
 * #6. Edge case : For starting cell, the time will be 0 as we are already in the cell. 
 *  
 * Approach:
 * 1. Data structures required :
 *    => Min Heap/min priority queue : To efficiently fetch the room with lowest time. This will require a tuple to be store in priority queue. 
 *    => Tuple in priority queue : Either canan use integer array of size 3, where 0th index will be for row, 1st index for column and last one for the time or use a tuple class with this priority. 
 *    => For sorting, pass comparator where comparison is done on the basis of time. 
 *    => Boolean 2D array of size n x m : To keep track of visited rooms. 
 *    => Directions 2D array : From current room, the adjacent rooms can be accessed horizontally or vertically, hence four directions are required.    
 *    => 2D array times of size n x m : To keep track of shortest time from source to target and each intermediary nodes.
 *    => Initialize times with Integer.MAX_VALUE to represent to represent no path exists between the nodes. Initial assumption.    
 * 2. Add starting room (0,0) to the priority queue with time = 0 as already in the room, so moveTime[0][0] doesnot come into picture.
 *    => Also times[0][0] = 0, as time required to reach source from source is 0. 
 * 3. Untill queue is not empty 
 *    => Fetch the top most room (i,j) i.e with least amount of time to reach.
 *    => If the current cell is the visited, skip remaining steps and move to next room. 
 *    => Mark the current cell visited. 
 *    => Move in all 4 directions, if room exists and it is not visited (Obtain newRow and newCol using direction)). 
 *    => Time to reach current cell = times[row][col] = x.
 *    => Time require to reach adjacent cell = moveTime[newRow][newCol]= y.
 *    => Time (t) to reach adjacent cell = Math.max(x,y) + 1 + (i + j) % 2.
 *    => if t < times[newRow][newCol] i.e. found lower time to reach from source to (newRow, newCol). Update times matrix. 
 *    => if t < times[newRow][newCol] Push adjacent cell coordinates and the time to reach it to the priority queue.   
 * 
 * Time Complexity: O(N + Nlog(N))
 *      - N = n * m. 
 *      - There are N cells in the grid.
 *      - Time to initialize times 2D array : O(N)
 *      - Insertion and deletion in priority queue/min heap in sorted order takes O(log N) time. 
 *      - All the cells are visited at least once.
 *       - Final complexity = O(N + Nlog(N)) 
 *      
 * Space Complexity: O(N)
 *      - N = n * m.
 *      - To save shortest path from source to target rooms including intermediary rooms : O(N)
 *      - To track visited cells, n * m (N) 2D matrix is used. 
 *      - Priority queue will have at most n*m cells (N)
 *      - Final Complexity = O(3*N) => O(N).
 */

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.PriorityQueue;

import org.junit.Test;

public class LeetCode_3342_FindMinimumTimeToReachLastRoomII {

    @Test
    public void test1() {
        assertEquals(7, minTimeToReach(new int[][] { { 0, 4 }, { 4, 4, } }));
    }

    @Test
    public void test2() {
        assertEquals(6, minTimeToReach(new int[][] { { 0, 0, 0, 0 }, { 0, 0, 0, 0 } }));
    }

    @Test
    public void test3() {
        assertEquals(4, minTimeToReach(new int[][] { { 0, 1 }, { 1, 2 } }));
    }

    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;
        int[][] directions = new int[][] { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

        boolean[][] visited = new boolean[n][m];

        int[][] shortestTime = new int[n][m];
        for (int[] time : shortestTime) {
            Arrays.fill(time, Integer.MAX_VALUE);
        }
        shortestTime[0][0] = 0;

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        priorityQueue.offer(new int[] { 0, 0, 0 });

        while (!priorityQueue.isEmpty()) {

            int[] currentRoom = priorityQueue.poll();
            int row = currentRoom[0];
            int col = currentRoom[1];
            int currentTime = currentRoom[2];

            if (row == n - 1 && col == m - 1) {
                break;
            }

            if (visited[row][col]) {
                continue;
            }

            visited[row][col] = true;

            for (int[] direction : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];
                if (newRow < 0 || newCol < 0 || newRow >= n || newCol >= m) {
                    continue;
                }

                int adjacentRoomTime = Math.max(currentTime, moveTime[newRow][newCol]) + (row + col) % 2 + 1;
                if (adjacentRoomTime < shortestTime[newRow][newCol]) {
                    shortestTime[newRow][newCol] = adjacentRoomTime;
                    priorityQueue.offer(new int[] { newRow, newCol, adjacentRoomTime });
                }
            }
        }

        return shortestTime[n - 1][m - 1];
    }
}