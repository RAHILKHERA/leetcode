package Week19_2025;

/**
 * @RAHILKHERA
 * 
 * LeetCode Problem: 3341 Find minimum time to reach last room. 
 * Problem Link:https://leetcode.com/problems/find-minimum-time-to-reach-last-room-i/?envType=daily-question&envId=2025-05-07
 *
 * Input : 
 *  - A dungeon is given with n x m rooms arranged as grid. 
 *  - Integer 2D array moveTime of size n x m. 
 * 
 * Definition :
 * -> moveTime[i][j] represents the minimum time in seconds when starting to move to that room.
 * -> From one room/cell, it can be moved either horizontally or vertically located cell/room.    
 * -> Start from the room at (0,0) at time = 0. 
 * -> Moving from one room to another room takes exactly one second. 
 * 
 * Constraints:
 * 2 <= n == moveTime.length <= 50
 * 2 <= m == moveTime[i].length <= 50
 * 0 <= moveTime[i][j] <= 10^9
 * 
 * Task: Find the minimum time to reach last room i.e at (n-1, m-1). 
 *
 * Observations:
 * #1. Need to traverse from first room (0,0) to last room (n-1, m-1) in least time.
 * #2. Each room/cell of the grid can be considered as node of the graph. 
 *     => Current room is connected with it's horizonatal and vertical cells. 
 *     => The cell value that is the time required to move to that room represents a weighted edge. 
 * #3. If the time required to reach current room is x and time for adjacent room or cell is y : 
 *     => Case 1 : x >= y => time required to reach adjacent cell will be x + 1.
 *     => Case 2 : x < y  => time required to reach adjacent cell will be y + 1. 
 *     => From above two cases, it can be concluded, moving from source till target (including intermediate rooms), the time will be always increasing. 
 *     => The cost function in this case is monotonic increasing. 
 *     => BFS with Priority Queue can be used. 
 * #4. Edge case : For starting cell, the time will be 0 as we are already in the cell. 
 *  
 * Approach:
 * 1. Data structures required :
 *    => Min Heap/min priority queue : To efficiently fetch the room with lowest time. This will require a tuple to be store in priority queue. 
 *    => Tuple in priority queue : Either canan use integer array of size 3, where 0th index will be for row, 1st index for column and last one for the time or use a tuple class with this priority. 
 *    => For sorting, pass comparator where comparison is done on the basis of time. 
 *    => Boolean 2D array of size n x m : To keep track of visited rooms. 
 *    => Directions 2D array : From current room, the adjacent rooms can be accessed horizontally or vertically, hence four directions are required.    
 * 2. Add starting room (0,0) to the priority queue with time = 0 as already in the room, so moveTime[0][0] doesnot come into picture.
 *    => Also mark (0,0) visited.  
 * 3. Untill queue is not empty  or last cell is reached:
 *    => Fetch the top most room i.e with least amount of time to reach.
 *    => If the current cell is the last cell, return the time attached with it.  
 *    => Move in all 4 directions, if room exists and it is not visited. 
 *    => Time to reach current cell = x.
 *    => Time require to reach adjacent cell = y.
 *    => Time to reach adjacent cell = Math.max(x,y) + 1. (+1 as time required to move from one room to another is 1 second).
 *    => Push adjacent cell coordinates and the time to reach it to the priority queue. 
 *    => Mark adjacent cell as visited.  
 * 
 * Time Complexity: O(Nlog(N))
 *      - N = n * m. 
 *      - There are N cells in the grid.
 *      - Insertion and deletion in priority queue/min heap in sorted order takes O(log N) time. 
 *      - All the cells are visited at least once.
 *       - Final complexity = O(Nlog(N)) 
 *      
 * Space Complexity: O(N)
 *      - N = n * m.
 *      - To track visited cells, n * m (N) 2D matrix is used. 
 *      - Priority queue will have at most n*m cells (N)
 *      - Final Complexity = O(2*N) => O(N).
 *
 *  Note : This approach is faster and requires less space compare to Dijkstra approach. 
 *        - 2D integer array of size n * m to store the least time is not required in the approach. 
 *        - For the same reason, the initialization loop is also not needed reducing execution time. 
 *        - Also one room is only visited once unlike another approach where rooms can be visited multiple times.        
 *        - Additionally this can have early termination. 
 *        - This approach was possible only due to the monotonic increase nature of the cost function. 
 * 
 * Other Approaches :
 * LeetCode_3341_FindMinimumtimeToReachLastRoomI_ApproachDijkstra.java
 */

import static org.junit.Assert.assertEquals;

import java.util.PriorityQueue;

import org.junit.Test;

public class LeetCode_3341_FindMinimumtimeToReachLastRoomI_ApproachBFSwithPriorityQueue {

    @Test
    public void test1() {
        assertEquals(6, minTimeToReach(new int[][] { { 0, 4 }, { 4, 4, } }));
    }

    @Test
    public void test2() {
        assertEquals(3, minTimeToReach(new int[][] { { 0, 0, 0 }, { 0, 0, 0 } }));
    }

    @Test
    public void test3() {
        assertEquals(3, minTimeToReach(new int[][] { { 0, 1 }, { 1, 0 } }));
    }

    @Test
    public void test4() {
        assertEquals(39, minTimeToReach(new int[][] { { 56, 93 }, { 3, 38 } }));
    }

    @Test
    public void test5() {
        assertEquals(84, minTimeToReach(new int[][] { { 0, 38, 10 }, { 58, 29, 83 } }));
    }

    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;
        int[][] directions = new int[][] { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
        boolean[][] visited = new boolean[n][m];
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        priorityQueue.offer(new int[] { 0, 0, 0 });
        visited[0][0] = true;
        while (!priorityQueue.isEmpty()) {
            int[] currentRoom = priorityQueue.poll();
            int row = currentRoom[0];
            int col = currentRoom[1];
            int currentTime = currentRoom[2];

            if (row == n - 1 && col == m - 1) {
                return currentTime;
            }

            for (int[] direction : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];
                if (newRow >= 0 && newCol >= 0 && newRow < n && newCol < m && !visited[newRow][newCol]) {
                   if (currentTime >= moveTime[newRow][newCol]) {
                        priorityQueue.offer(new int [] {newRow, newCol, currentTime + 1});
                    } else {
                        priorityQueue.offer(new int [] {newRow, newCol, moveTime[newRow][newCol] + 1});
                    }
                    visited[newRow][newCol] = true;
                }
            }
        }

        //Invalid point, it should not reach here. 
        return 0;
    }

}