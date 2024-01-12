import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import org.junit.Test;

public class LeetCode_909_SnakesNLadders {

    @Test
    public void test1() {

        assertEquals(4, snakesAndLadders(new int[][] { { -1, -1, -1, -1, -1, -1 },
                { -1, -1, -1, -1, -1, -1 },
                { -1, -1, -1, -1, -1, -1 },
                { -1, 35, -1, -1, 13, -1 },
                { -1, -1, -1, -1, -1, -1 },
                { -1, 15, -1, -1, -1, -1 } }));

    }

    @Test
    public void test2() {
        assertEquals(-1, snakesAndLadders(new int[][] { { 1, 1, -1 },
                { 1, 1, 1 },
                { -1, 1, 1 } }));
    }

    @Test
    public void test3LargeBoard() {
        assertEquals(67,
                snakesAndLadders(new int[][] {
                        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
                        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
                        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
                        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
                        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
                        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
                        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
                        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
                        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
                        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
                        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
                        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
                        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
                        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
                        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
                        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
                        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
                        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
                        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
                        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 } }));
    }

    public int snakesAndLadders(int[][] board) {

        int n = board.length;
        int moves = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);

        Set<Integer> visited = new HashSet<>();
        visited.add(1);

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int j = 0; j < size; j++) {

                int current = queue.poll();
                // visited.add(current);

                if (current == n * n) {
                    return moves;
                }

                for (int i = current + 1; i <= current + 6 && i <= n * n; i++) {

                    int rc[] = getRowsAndColumns(n, i);

                    if (board[rc[0]][rc[1]] != -1) {
                        if (!visited.contains(board[rc[0]][rc[1]])) {
                            queue.offer(board[rc[0]][rc[1]]);
                            visited.add(board[rc[0]][rc[1]]);
                        }
                    } else if (!visited.contains(i)) {
                        queue.offer(i);
                        visited.add(i);
                    }

                }
            }

            moves++;
        }

        return -1;
    }

    @Test
    public void testRCGeneratorEven() {

        assertArrayEquals(new int[] { 5, 0 }, getRowsAndColumns(6, 1));
        assertArrayEquals(new int[] { 5, 1 }, getRowsAndColumns(6, 2));
        assertArrayEquals(new int[] { 5, 2 }, getRowsAndColumns(6, 3));
        assertArrayEquals(new int[] { 5, 3 }, getRowsAndColumns(6, 4));
        assertArrayEquals(new int[] { 5, 4 }, getRowsAndColumns(6, 5));
        assertArrayEquals(new int[] { 5, 5 }, getRowsAndColumns(6, 6));

        assertArrayEquals(new int[] { 4, 0 }, getRowsAndColumns(6, 12));
        assertArrayEquals(new int[] { 4, 1 }, getRowsAndColumns(6, 11));
        assertArrayEquals(new int[] { 4, 2 }, getRowsAndColumns(6, 10));
        assertArrayEquals(new int[] { 4, 3 }, getRowsAndColumns(6, 9));
        assertArrayEquals(new int[] { 4, 4 }, getRowsAndColumns(6, 8));
        assertArrayEquals(new int[] { 4, 5 }, getRowsAndColumns(6, 7));

        assertArrayEquals(new int[] { 3, 0 }, getRowsAndColumns(6, 13));
        assertArrayEquals(new int[] { 3, 1 }, getRowsAndColumns(6, 14));
        assertArrayEquals(new int[] { 3, 2 }, getRowsAndColumns(6, 15));
        assertArrayEquals(new int[] { 3, 3 }, getRowsAndColumns(6, 16));
        assertArrayEquals(new int[] { 3, 4 }, getRowsAndColumns(6, 17));
        assertArrayEquals(new int[] { 3, 5 }, getRowsAndColumns(6, 18));

        assertArrayEquals(new int[] { 2, 0 }, getRowsAndColumns(6, 24));
        assertArrayEquals(new int[] { 2, 1 }, getRowsAndColumns(6, 23));
        assertArrayEquals(new int[] { 2, 2 }, getRowsAndColumns(6, 22));
        assertArrayEquals(new int[] { 2, 3 }, getRowsAndColumns(6, 21));
        assertArrayEquals(new int[] { 2, 4 }, getRowsAndColumns(6, 20));
        assertArrayEquals(new int[] { 2, 5 }, getRowsAndColumns(6, 19));

        assertArrayEquals(new int[] { 1, 0 }, getRowsAndColumns(6, 25));
        assertArrayEquals(new int[] { 1, 1 }, getRowsAndColumns(6, 26));
        assertArrayEquals(new int[] { 1, 2 }, getRowsAndColumns(6, 27));
        assertArrayEquals(new int[] { 1, 3 }, getRowsAndColumns(6, 28));
        assertArrayEquals(new int[] { 1, 4 }, getRowsAndColumns(6, 29));
        assertArrayEquals(new int[] { 1, 5 }, getRowsAndColumns(6, 30));

        assertArrayEquals(new int[] { 0, 0 }, getRowsAndColumns(6, 36));
        assertArrayEquals(new int[] { 0, 1 }, getRowsAndColumns(6, 35));
        assertArrayEquals(new int[] { 0, 2 }, getRowsAndColumns(6, 34));
        assertArrayEquals(new int[] { 0, 3 }, getRowsAndColumns(6, 33));
        assertArrayEquals(new int[] { 0, 4 }, getRowsAndColumns(6, 32));
        assertArrayEquals(new int[] { 0, 5 }, getRowsAndColumns(6, 31));

    }

    @Test
    public void testRCOdd() {
        assertArrayEquals(new int[] { 0, 0 }, getRowsAndColumns(3, 7));
        assertArrayEquals(new int[] { 0, 1 }, getRowsAndColumns(3, 8));
        assertArrayEquals(new int[] { 0, 2 }, getRowsAndColumns(3, 9));

        assertArrayEquals(new int[] { 1, 0 }, getRowsAndColumns(3, 6));
        assertArrayEquals(new int[] { 1, 1 }, getRowsAndColumns(3, 5));
        assertArrayEquals(new int[] { 1, 2 }, getRowsAndColumns(3, 4));

        assertArrayEquals(new int[] { 2, 0 }, getRowsAndColumns(3, 1));
        assertArrayEquals(new int[] { 2, 1 }, getRowsAndColumns(3, 2));
        assertArrayEquals(new int[] { 2, 2 }, getRowsAndColumns(3, 3));
    }

    public int[] getRowsAndColumns(int n, int cellNumber) {

        int rows = n;
        int cols = n;

        int row = rows - ((cellNumber - 1) / rows) - 1;
        int col;

        int freshCol = (cellNumber - 1) % cols;

        if ((rows % 2 == 0 && row % 2 == 0) || (rows % 2 != 0 && row % 2 != 0)) {
            col = cols - 1 - freshCol;

        } else {
            col = freshCol;
        }

        return new int[] { row, col };
    }
}
