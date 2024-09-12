import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class LeetCode_100299_CheckifGridSatisfiesConditions {

    @Test
    public void test1() {
        assertFalse(satisfiesConditions(new int[][] { { 1 }, { 2 }, { 3 } }));
    }

    public boolean satisfiesConditions(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        if (rows == 1) {

            for (int i = 0; i < cols - 1; i++) {
                if (grid[0][i] == grid[0][i + 1]) {
                    return false;
                }
            }

        } else if (cols == 1) {

            for (int i = 0; i < rows - 1; i++) {
                if (grid[i][0] != grid[i + 1][0]) {
                    return false;
                }
            }

        } else {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {

                    if (j < cols - 1 && grid[i][j] == grid[i][j + 1]) {
                        return false;
                    }

                    if (i < rows - 1 && grid[i][j] != grid[i + 1][j]) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
