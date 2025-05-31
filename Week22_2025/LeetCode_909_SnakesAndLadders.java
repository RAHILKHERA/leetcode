package Week22_2025;

/**
 * @RAHILKHERA
 *
 * LeetCode Problem: 909 Snakes and Ladders. 
 * Problem Link: https://leetcode.com/problems/snakes-and-ladders/description/?envType=daily-question&envId=2025-05-31
 *
 * Input:
 * - 2D Integer Array: board 
 * - board is a square matrix. 
 * 
 * Constraints:
 * n == board.length == board[i].length
 * 2 <= n <= 20
 * board[i][j] is either -1 or in the range [1, n^2].
 * The squares labeled 1 and n^2 are not the starting points of any snake or ladder.
 * 
 * Definition: 
 * -> Game starts with square 1 on the board. 
 * -> If current square is curr, in each roll it can be moved to `next` square in range of [curr + 1, min(curr + 6, n^2)]. This simulates the result of a 6-sided roll. 
 * -> If `next` has a snake or ladder, must move to the destination of the snake or ladder. 
 * -> The game ends on reaching the n^2 square. 
 * 
 * Task: Find the minimum number of dice rolls required to reach square n^2. If not possible, return -1. 
 *  
 * Note: If the destination of a snake or ladder is the start of another snake or ladder, do not follow the subsequent snake or ladder in the same roll.
 * 
 * Observations: 
 * #1. For every roll of the dice, from each square there are 6 destinations. 
 *  => If a square has a snake or ladder, move to the destination of the snake or ladder. 
 *  => The original destination will be replaced by the snake or ladder destination. 
 *  => Still, the total number of available destinations remains 6. 
 * #2. Each square can be considered as a source and destination. 
 *  => Each roll of the dice can be considered as a directed edge from the current square to the next square. 
 *  => Task is to traverse from square 1 to square n^2. 
 *  => This problem is of graph traversal from the first node to the target node using minimum edges. 
 * #3. There are 2 options: i) DFS ii) BFS. 
 *   => 3a. DFS will not be suitable for this use case. 
 *      -> In DFS, first it is drilled down a single branch before trying another branch. 
 *      -> It is required to move from source to destination in minimum edges, i.e., minimum depth. 
 *      -> In the worst case, the full tree will be required to traverse; consider multiple branches leading to the n^2 square. 
 *      -> In this case, the target square will be visited multiple times. 
 *   => 3b. BFS will be suitable for this use case. 
 *      -> After every roll, every square which can be reached from the current square is explored.
 *      -> This will make sure that when the target square is processed, it will be reached in minimum rolls. 
 *      -> A classic level order BFS traversal will solve the problem. 
 * #4. Important: `If the destination of a snake or ladder is the start of another snake or ladder, do not follow the subsequent snake or ladder in the same roll.`
 *  => Unlike classic BFS, already visited next square (neighboring node) should not be ignored. 
 *  => Although the next square was visited, there is a possibility that from this next square, there exists a ladder or snake. 
 *  => And the destination of this ladder or snake may be unvisited. 
 *  => If that is the case, we need to move to the destination of the ladder or snake. 
 * #5. Coordinates Calculation: 
 *  => BFS will run over square labels ranging from 1 to n^2. 
 *  => But to recognize whether to move to the next label or there exists a ladder or snake, `board` must be accessed.
 *  => To access the board, row and column of the label need to be calculated. 
 *  => In the classic case, i.e., value 0 at (0,0), the following is the way to calculate the row and col from cell value:
 *     -> row = cellValue / ROWS. (This will be the number of rows starting from the 0th row if the matrix has `ROWS` rows.)
 *     -> col = cellValue % COLS. (This will be the number of cols starting from the 0th col if the matrix has `COLS` columns).
 *  => In this case, the values are in the range of [1, n^2] and it is a square matrix with n rows and n columns. 
 *  => row = (cellValue - 1) / n.
 *  => col = (cellValue - 1) % n. ----------------------------------------------------- equation (1)
 *  => Starting point is at (n-1, 0) i.e., left bottom corner. Hence the rows will start from bottom and move to top. 
 *     -> Value of row will be in [0, n-1].
 *     -> row = (n - 1) - ((cellValue - 1) / n) ---------------------------------------- equation (2)
 *  => For columns, columns are reversed for alternate rows. 
 *     -> If the grid has an even number of rows, then the sequence of columns in even-numbered rows will be reversed. 
 *     -> If the grid had an odd number of rows, then the sequence of columns in odd-numbered rows will be reversed. 
 *     -> In this case, col = (n - 1) - ((cellValue - 1) % n) --------------------------- equation (3)
 * 
 * Approach:
 * 1. Implement classic BFS with level order traversal. Start with 1. 
 *    => Keep a boolean array of size n^2 + 1 to keep track of visited nodes. 
 *    => Queue for processing nodes.
 *    => Each level will represent the number of rolls `rolls`. 
 * 2. Until the queue is not empty, process each square.
 *    => If the current square is n*n, then return rolls, no need for further processing.
 *    => Else each square has a maximum of 6 options to move, maximum six because the number of options is bounded by the size of the board.
 *    => Get the coordinates of the current cell value using equations (1), (2), and (3).
 *    => If the next cell value was not visited before and there is no snake or ladder, then
 *      ->  add the current cell to the queue for further processing and mark it as visited. 
 *    => Even if the next cell value was visited, but if it has a snake or ladder and the destination of that is not visited, then
 *      -> add the destination of that snake or ladder to the queue for further processing and mark it as visited. 
 * 3. If the queue gets empty, then the target square cannot be reached. Return -1. 
 * 
 * Time Complexity: O(N)
 * |          Component                                    |   Time                             |
 * | ----------------------------------------------------- | ---------------------------------- |
 * | BFS                                                   |                                    |
 * |   Number of nodes = n^2 = N                           | O(N)                               |
 * |   Number of edges per node = 6 => Total Edges = 6N    | O(6N)                              |
 * |   Traversal                                           | O(N + 6N)  = O(7N) = O(N)          |
 * |-------------------------------------------------------|------------------------------------|
 * | Total Complexity                                      | O(N)                               |
 * 
 * 
 * Space Complexity: O(N)
 * |          Component                                    |   Space                            |
 * | ----------------------------------------------------- | ---------------------------------- |
 * | 1D boolean array of size n^2 = N                      | O(N)                               |
 * | BFS queue at max all nodes will be present in queue.  | O(N)                               |
 * |-------------------------------------------------------|------------------------------------|
 * | Total Complexity                                      | O(2N) => O(N)                      |
 *
 */
import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

public class LeetCode_909_SnakesAndLadders {
    private int n;

    @Test
    public void test1() {
        assertEquals(4, snakesAndLadders(
                new int[][] {
                        { -1, -1, -1, -1, -1, -1 },
                        { -1, -1, -1, -1, -1, -1 },
                        { -1, -1, -1, -1, -1, -1 },
                        { -1, 35, -1, -1, 13, -1 },
                        { -1, -1, -1, -1, -1, -1 },
                        { -1, 15, -1, -1, -1, -1 } }));
    }

    @Test
    public void test2() {
        assertEquals(1, snakesAndLadders(
                new int[][] {
                        { -1, -1 },
                        { -1, 3 } }));
    }

    @Test
    public void test3() {
        assertEquals(4, snakesAndLadders(
                new int[][] { { -1, -1, -1, 46, 47, -1, -1, -1 }, { 51, -1, -1, 63, -1, 31, 21, -1 },
                        { -1, -1, 26, -1, -1, 38, -1, -1 }, { -1, -1, 11, -1, 14, 23, 56, 57 },
                        { 11, -1, -1, -1, 49, 36, -1, 48 }, { -1, -1, -1, 33, 56, -1, 57, 21 },
                        { -1, -1, -1, -1, -1, -1, 2, -1 }, { -1, -1, -1, 8, 3, -1, 6, 56 } }));
    }

    public int snakesAndLadders(int[][] board) {
        n = board.length;
        boolean[] visited = new boolean[n * n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visited[1] = true;
        int rolls = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int currentCell = queue.poll();
                if (currentCell == n * n)
                    return rolls;
                for (int nextCell = currentCell + 1; nextCell <= Math.min(currentCell + 6, n * n); nextCell++) {
                    int[] coordinates = getCellCoordinates(nextCell);
                    int row = coordinates[0];
                    int col = coordinates[1];
                    if (!visited[nextCell] && board[row][col] == -1) {
                        visited[nextCell] = true;
                        queue.offer(nextCell);
                    } else if (board[row][col] != -1 && !visited[board[row][col]]) {
                        visited[board[row][col]] = true;
                        queue.offer(board[row][col]);
                    }
                }
            }
            rolls++;
        }
        return -1;
    }

    private int[] getCellCoordinates(int cellNumber) {

        int row = (n - 1) - ((cellNumber - 1) / n);
        int col = (cellNumber - 1) % n;
        boolean isEvenRows = n % 2 == 0;
        boolean isEvenRow = row % 2 == 0;
        if ((isEvenRow && isEvenRows) || (!isEvenRow && !isEvenRows)) {
            col = (n - 1) - col;
        }
        return new int[] { row, col };
    }
}
