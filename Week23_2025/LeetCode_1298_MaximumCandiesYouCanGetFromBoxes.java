package Week23_2025;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

/**
 * @RAHILKHERA
 *
 * LeetCode Problem: 1298 Maximum candies you can get from boxes
 * Problem Link:
 * https://leetcode.com/problems/maximum-candies-you-can-get-from-boxes/description/?envType=daily-question&envId=2025-06-03
 *
 * Input:
 * - Integer array status.
 * - Integer array candies.
 * - Integer 2D array keys. 
 * - Integer 2D array containedBoxes
 * - Integer array initialBoxes
 *
 * Constraints:
 * n == status.length == candies.length == keys.length == containedBoxes.length
 * 1 <= n <= 1000
 * status[i] is either 0 or 1.
 * 1 <= candies[i] <= 1000
 * 0 <= keys[i].length <= n
 * 0 <= keys[i][j] < n
 * All values of keys[i] are unique.
 * 0 <= containedBoxes[i].length <= n
 * 0 <= containedBoxes[i][j] < n
 * All values of containedBoxes[i] are unique.
 * Each box is contained in one box at most.
 * 0 <= initialBoxes.length <= n
 * 0 <= initialBoxes[i] < n
 *            
 * Definition :
 * status[i] : ith box is open or closed. 
 * candies[i] : number of candies that can be collected if ith box is open. 
 * keys[i] : keys of other boxes to be collected if the ith box is open.
 * containedBoxes[i] : other boxes to be collected from ith box if it is open. 
 * initialBoxes : list of boxes available at the start.  
 * 
 *             
 * Task: Collect maximum number of candies while following the above constraints. 
 * 
 * Observations:
 * #1. A single box contains candies and may have keys to open other boxes or contain other boxes. 
 *     => There is no constraint on collecting candies from a single open box. 
 *     => To collect the maximum number of candies, open the maximum number of boxes. 
 *     => Traverse from one box to another, collect more candies, more boxes, and more keys to open closed boxes. 
 *     => This can be visualized as a graph problem, where each box is a node and if it contains another box, consider it as an edge from the current box to the contained box. 
 *     => The traversal is only possible if the node is active, that is, the contained box is open. 
 *     => When the box (node) is visited, collect the candies from it. 
 *     => If the box is open, everything from the box can be collected; else, the box can be opened when its key is available.
 *     => When collecting the keys, open their corresponding boxes. 
 *     => Maintain a queue, to keep track of open boxes, for each open box, collect the items. 
 * #2. A box and its key can be found in any order, i.e. a closed box is encountered first and then it's key or vice versa. 
 *     => So it is necessary to keep the track of the boxes which are available. 
 * #3. There is a posibility that an open box was processed that is items were collected and it is within another box. 
 *     => Another case, box was already processed and it's key appear in current box. 
 *     => No need to process it again, so keep a track of the boxes which are emptied already. 
 * #4. For each contained box, if it was not emptied previously and it's key was found then add it to the queue. 
 * #5. For each key in the box, if it's corresponding box was found and it was not emptied then add it to the queue. 
 * 
 * Data Structure :
 * #1. usedBox : A boolean array of size n to mark if the box was emptied. (Equivalent to visited node in classic BFS).
 * #2. hasBox : A boolean array of size n to mark if the box is present. This is mainly used when the box is close and its keep be available in future. 
 * #3. queue : A queue to track and process the open boxes.  
 * 
 * Approach:
 * 1. BFS can be used to solve this problem. 
 *    => Add all the open boxes initially available to the queue and also mark the availability of the box in `hasBox`.
 *    => Process each box from the queue. 
 *    => Add the candies from the box to the total count. 
 *    => If the current box has boxes,
 *      -> Mark the availability of the box. 
 *      -> If the box was not emptied and it is open, add it to the queue. 
 *    => If the current box has keys,
 *      -> Mark the status of the box as 1, i.e., as open or whenever the box appears it can be opened. 
 *      -> If the box corresponding to this key is not used and the box is available, then add it to the queue. 
 *    
 * Time Complexity: O(n)
 *             
 * |                       Component                            |                Time               |
 * | ---------------------------------------------------------- |---------------------------------- |
 * | BFS, n = number of boxes (vertices),                       |                                   |
 * | Each box is contained in one box at most => edges = O(n-1) | O(n + n - 1) => O(2n - 1) => O(n) |
 * |------------------------------------------------------------|-----------------------------------|
 * | Total Complexity                                           |                              O(n) |
 * 
 * Space Complexity: O(n)
 * |                        Component                           |                  Space            |
 * | ---------------------------------------------------------- |---------------------------------- |
 * | BFS queue can have at most all boxes = n                   |            O(n)                   |
 * | hasBox                                                     |            O(n)                   |
 * | usedBox                                                    |            O(n)                   | 
 * |----------------------------------------------------------- |-----------------------------------|
 * | Total Complexity                                           |            O(3n)  => O(n)         |
 *
 * Note: The input array status is modified, but if input modification is not allowed, another boolean array would be required,
 * where true means the box is open and false means the box is closed. 
 */

public class LeetCode_1298_MaximumCandiesYouCanGetFromBoxes {

    @Test
    public void test1() {
        assertEquals(16, maxCandies(new int[] { 1, 0, 1, 0 },
                new int[] { 7, 5, 4, 100 },
                new int[][] { {}, {}, { 1 }, {} },
                new int[][] { { 1, 2 }, { 3 }, {}, {} },
                new int[] { 0 }));
    }

    @Test
    public void test2() {
        assertEquals(6, maxCandies(new int[] { 1, 0, 0, 0, 0, 0 },
                new int[] { 1, 1, 1, 1, 1, 1 },
                new int[][] { { 1, 2, 3, 4, 5 }, {}, {}, {}, {}, {} },
                new int[][] { { 1, 2, 3, 4, 5 }, {}, {}, {}, {}, {}},
                new int[] { 0 }));
    }
    
    @Test
    public void test3() {
        assertEquals(1, maxCandies(new int[] { 1, 0, 0, 0, 0, 0 },
                new int[] { 1, 1, 1, 1, 1, 1 },
                new int[][] { {}, {}, {}, {}, {}, {} },
                new int[][] { {}, {}, {}, {}, {}, {} },
                new int[] { 0, 1, 2 }));
    }
    
    @Test
    public void test4() {
        assertEquals(10, maxCandies(new int[] { 1,0,0,0},
                new int[] { 1, 2, 3, 4 },
                new int[][] { { 1, 2}, {3}, {}, {} },
                new int[][] { {2}, {3}, {1}, {}, {} },
                new int[] {0}));
    }

    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {

        int n = status.length;
        int totalCandies = 0;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] hasBox = new boolean[n];
        boolean[] usedBox = new boolean[n];
        for (int box : initialBoxes) {
            hasBox[box] = true;
            if (status[box] == 1) {
                queue.offer(box);
            }
        }
        
        while (!queue.isEmpty()) {
            int box = queue.poll();
            if (usedBox[box]) {
                continue;
            }
            
            totalCandies += candies[box];
            usedBox[box] = true;

            for (int containedBox : containedBoxes[box]) {
                hasBox[containedBox] = true;
                if (!usedBox[containedBox] && status[containedBox] == 1) {
                    queue.offer(containedBox);
                }
            }
            
            for (int key : keys[box]) {
                status[key] = 1;
                if (!usedBox[key] && hasBox[key]) {
                    queue.offer(key);
                }
            }          
        }
        return totalCandies;
    }
}
