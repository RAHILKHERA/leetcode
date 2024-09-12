import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LeetCode_840_MagicSquaresInGrid {

    @Test
    public void test1() {
        assertEquals(1, numMagicSquaresInside(new int[][] { { 4, 3, 8, 4 }, { 9, 5, 1, 9 }, { 2, 7, 6, 2 } }));
    }

    public int numMagicSquaresInside(int[][] grid) {
        int result = 0;

        for (int i = 1; i < grid.length - 1; i++) {

            for (int j = 1; j < grid[i].length - 1; j++) {
                if (isMagicSquare(grid, i, j)) {
                    result++;
                }
            }
        }

        return result;
    }

    private boolean isMagicSquare(int[][] grid, int i, int j) {

        boolean[] nums = new boolean[10];

        int topleft = grid[i - 1][j - 1];
        if (topleft < 1 || topleft > 9 || nums[topleft]) {
            return false;
        }
        nums[topleft] = true;

        int topmiddle = grid[i - 1][j];
        if (topmiddle < 1 || topmiddle > 9 || nums[topmiddle]) {
            return false;
        }
        nums[topmiddle] = true;

        int topright = grid[i - 1][j + 1];
        if (topright < 1 || topmiddle > 9 || nums[topright]) {
            return false;
        }
        nums[topright] = true;

        int left = grid[i][j - 1];
        if (left < 1 || left > 9 || nums[left]) {
            return false;
        }
        nums[left] = true;

        int middle = grid[i][j];
        if (middle < 1 || middle > 9 || nums[middle]) {
            return false;
        }
        nums[middle] = true;

        int right = grid[i][j + 1];
        if (right < 1 || right > 9 || nums[right]) {
            return false;
        }
        nums[right] = true;

        int leftbottom = grid[i + 1][j - 1];
        if (leftbottom < 1 || leftbottom > 9 || nums[leftbottom]) {
            return false;
        }
        nums[leftbottom] = true;

        int bottommiddle = grid[i + 1][j];
        if (bottommiddle < 1 || bottommiddle > 9 || nums[bottommiddle]) {
            return false;
        }
        nums[bottommiddle] = true;

        int bottomright = grid[i + 1][j + 1];
        if (bottomright < 1 || bottomright > 9 || nums[bottomright]) {
            return false;
        }
        nums[bottomright] = true;

        int row1 = topleft + topmiddle + topright;
        int row2 = left + middle + right;

        if (row1 != row2) {
            return false;
        }

        int row3 = leftbottom + bottommiddle + bottomright;
        if (row1 != row3) {
            return false;
        }

        int col1 = topleft + left + leftbottom;
        if (col1 != row1) {
            return false;
        }

        int col2 = topmiddle + middle + bottommiddle;
        if (col2 != row1) {
            return false;
        }

        int col3 = topright + right + bottomright;
        if (col3 != row1) {
            return false;
        }

        int dig1 = topleft + middle + bottomright;
        if (dig1 != row1) {
            return false;
        }

        int dig2 = topright + middle + leftbottom;
        if (dig2 != row1) {
            return false;
        }

        return true;
    }
}
