import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LeetCode_2556_DisconnectPathInaBinaryMatrixByAtMostOneFlip {

    @Test
    public void test1() {
        assertTrue(isPossibleToCutPath(new int[][] { { 1, 1, 1 }, { 1, 0, 0 }, { 1, 1, 1 } }));
    }

    @Test
    public void test2() {
        assertFalse(isPossibleToCutPath(new int[][] { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } }));
    }

    @Test
    public void test3() {
        assertTrue(isPossibleToCutPath(new int[][] {
                { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1 } }));
    }

    @Test
    public void test4() {
        assertFalse(isPossibleToCutPath(new int[][] {
                { 1, 1 } }));
    }

    @Test
    public void test5() {
        assertFalse(isPossibleToCutPath(new int[][] {
                { 1, 1, 0, 0, 0, 0 },
                { 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 0, 1 },
                { 0, 0, 0, 1, 1, 1 },
                { 0, 0, 0, 1, 0, 1 },
                { 0, 0, 0, 1, 0, 1 },
                { 0, 0, 0, 1, 0, 1 },
                { 0, 0, 0, 1, 0, 1 },
                { 0, 0, 0, 1, 1, 1 } }));
    }

    public boolean isPossibleToCutPath(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        boolean pathBeforeCut = dfs(grid, rows, cols, 0, 0);

        grid[0][0] = 1;
        grid[rows - 1][cols - 1] = 1;

        boolean pathAfterCut = dfs(grid, rows, cols, 0, 0);

        return !(pathAfterCut && pathBeforeCut);

    }

    private boolean dfs(int[][] grid, int rows, int cols, int row, int col) {

        if (row >= rows || col >= cols || grid[row][col] == 0) {
            return false;
        }

        // Check if we've reached the bottom-right corner
        if (row == rows - 1 && col == cols - 1) {
            return true;
        }

        // Mark the current cell as an obstacle to avoid revisiting
        grid[row][col] = 0;

        // Recursively search in the right and down directions, returning true if a path
        // is found
        return dfs(grid, rows, cols, row + 1, col) || dfs(grid, rows, cols, row, col + 1);

    }
}
