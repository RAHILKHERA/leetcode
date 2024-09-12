import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LeetCode_861_ScoreAfterFlipingMatrix {

    @Test
    public void test1() {
        assertEquals(39, matrixScore(new int[][] { { 0, 0, 1, 1 }, { 1, 0, 1, 0 }, { 1, 1, 0, 0 } }));
    }

    public int matrixScore(int[][] grid) {

        int score = 0;
        int ROWS = grid.length;
        int COLS = grid[0].length;

        /**
         * Flip Row if the first cell is 0.
         * 
         */
        for (int i = 0; i < ROWS; i++) {

            if (grid[i][0] == 0) {

                for (int j = 0; j < COLS; j++) {
                    grid[i][j] = 1 - grid[i][j];
                }
            }
        }

        /**
         * Flip Column if number of 0's is more than 1's
         */

        for (int i = 1; i < COLS; i++) {

            int countOnes = 0;

            for (int j = 0; j < ROWS; j++) {

                if (grid[j][i] == 1) {
                    countOnes++;
                }
            }

            if (countOnes < ROWS - countOnes) {

                for (int j = 0; j < ROWS; j++) {

                    grid[j][i] = 1 - grid[j][i];
                }
            }
        }

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                int columnScore = grid[i][j] << (COLS - j - 1);
                score += columnScore;
            }
        }

        return score;
    }
}
