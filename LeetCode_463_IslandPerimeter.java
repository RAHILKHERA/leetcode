import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LeetCode_463_IslandPerimeter {

    @Test
    public void test1() {
        assertEquals(16,
                islandPerimeter(new int[][] { { 0, 1, 0, 0 }, { 1, 1, 1, 0 }, { 0, 1, 0, 0 }, { 1, 1, 0, 0 } }));
    }

    public int islandPerimeter(int[][] grid) {

        // for (int i = 0; i < grid.length; i++) {
        // for (int j = 0; j < grid[0].length; j++) {
        // if (grid[i][j] == 1) {
        // return calculatePerimeter(grid, i, j);
        // }
        // }
        // }

        int perimeter = 0;

        // Iterate through the grid
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    // For each land cell, count its perimeter
                    perimeter += 4; // Count all four sides initially

                    // Check adjacent cells to deduct shared sides
                    if (i > 0 && grid[i - 1][j] == 1)
                        perimeter -= 2; // Deduct shared side with cell above
                    if (j > 0 && grid[i][j - 1] == 1)
                        perimeter -= 2; // Deduct shared side with cell on the left
                }
            }
        }

        return perimeter;
    }

    // private int calculatePerimeter(int[][] grid, int row, int col) {

    // if (row == grid.length || row < 0 || col < 0 || col == grid[0].length ||
    // grid[row][col] == 0) {
    // return 0;
    // }

    // if (grid[row][col] == 100) {
    // return -1;
    // }

    // grid[row][col] = 100;

    // int left = calculatePerimeter(grid, row, col - 1);
    // int right = calculatePerimeter(grid, row, col + 1);
    // int up = calculatePerimeter(grid, row - 1, col);
    // int down = calculatePerimeter(grid, row + 1, col);

    // left = left > 0 ? left - 1 : left;
    // right = right > 0 ? right - 1 : right;
    // up = up > 0 ? up - 1 : up;
    // down = down > 0 ? down - 1 : down;

    // return left + right + up + down + 4;

    // }
}
