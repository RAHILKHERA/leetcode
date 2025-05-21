package Week21_2025;

/**
 * @RAHILKHERA
 *
 * LeetCode Problem: 73 Set Matrix Zero.
 * Problem Link: https://leetcode.com/problems/set-matrix-zeroes/?envType=daily-question&envId=2025-05-21
 *
 * Input:
 * - Integer 2D matrix of size m x n. 
 * 
 * Constraints:
 * ROWS == m == matrix.length
 * COLS == n == matrix[0].length
 * 1 <= m, n <= 200
 * -2^31 <= matrix[i][j] <= 2^31 - 1
 *
 * Task:  if an element is 0, set its entire row and column to 0's. Do it in place with constant space solution. 
 *  
 * Observations:
 * 1) If any cell of the matrix is 0, record its row and column number using additional memory. 
 *    => And then make the elements of recorded row and column 0. 
 *    => But in worst case it will use extra memory equivalent to total number of cells i.e. T = ROWS * COLS.
 * 2) Setting cell values on fly while iterating will lead to discrepancies. 
 *    => Also the cell value range is equal to full range of integer. So performing arithmetic operations is not feasible. 
 * 3) Use 2 sets to keep record of row and column which need to be set to zero. But again this is not O(1) solution. 
 *    => This will take an extra space of ROWS + COLS. 
 * 4) The first cell of every row and column can be used as a flag. This flag would determine whether a row or column has been set to zero.
 *    => The first row and first column of the matrix will be used as flag. 
 *    => Edge case : If intially there was atleast one 0 in the first row or column, then this can lead to discrepancies. 
 *    => To handle this case, maintain two boolean variables, to track if intially first row and column initially had 0. 
 *    => Perform this check before using the first row and column as flag. 
 *    => On the basis of the flags, transfrom the matrix except first row and column. 
 *    => On the basis of the boolean variables, transform first row and column as required.  
 *
 * Approach:
 * 1. Use two variables transformFirstRow and transformFirstCol, to track if the first row and column had 0's. 
 * 2. Traverse the matrix, leave first row and first column, and flag the rows and columns if they have atleast one 0's.
 *    => If a cell has 0's, mark first cell of row and first cell of column as 0. 
 * 3. Again leaving first row and first column, on the basis of the flagging, update the rows and columns. 
 *    => If first cell of the row/column is 0, set all the element of row/column to 0. 
 * 4. If transformFirstRow/transformFirstCol are true, then set all the elements of first row/column to 0. 
 *    
 *
 * Time Complexity: 
 * |          Component             |   Time              |
 * | -------------------------------| ------------------- |
 * | Check first row transformation | O(COLS)             |
 * | Check first col transformation | O(ROWS)             |
 * | Flagging elements              | O(ROWS * COLS)      |
 * | Row transformation             | O(ROWS * COLS)      |
 * | Col transformation             | O(ROWS * COLS)      |
 * | First row transformation       | O(COLS)             |
 * | First col transformation       | O(ROWS)             |
 * |--------------------------------|---------------------|
 * | Total Complexity               | O(3 *ROWS * COLS + 2*ROWS + 2*COLS) => O(ROWS * COLS + ROWS * COLS).   
 *
 * Space Complexity: O(1)
 * - No extra space proportional to the input matrix is used. 
 * 
 */

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class LeetCode_73_SetMatrixZero {

    private int ROWS;
    private int COLS;

    @Test
    public void test1() {
        int[][] matrix = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
        setZeroes(matrix);
        assertArrayEquals(new int[][] { { 1, 0, 1 }, { 0, 0, 0 }, { 1, 0, 1 } }, matrix);
    }

    @Test
    public void test2() {
        int[][] matrix = { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };
        setZeroes(matrix);
        assertArrayEquals(new int[][] { { 0, 0, 0, 0 }, { 0, 4, 5, 0 }, { 0, 3, 1, 0 } }, matrix);
    }

    @Test
    public void testEmptyMatrix() {
        int[][] matrix = {};
        setZeroes(matrix);
        assertArrayEquals(new int[][] {}, matrix);
    }

    @Test
    public void testSingleZero() {
        int[][] matrix = { { 1, 2 }, { 0, 4 } };
        setZeroes(matrix);
        assertArrayEquals(new int[][] { { 0, 2 }, { 0, 0 } }, matrix);
    }

    @Test
    public void testNoZero() {
        int[][] matrix = { { 1, 2 }, { 3, 4 } };
        setZeroes(matrix);
        assertArrayEquals(new int[][] { { 1, 2 }, { 3, 4 } }, matrix);
    }

    public void setZeroes(int[][] matrix) {

        if (matrix.length == 0) {
            return;
        }

        ROWS = matrix.length;
        COLS = matrix[0].length;
        boolean transformFirstRow = false;
        boolean transformFirstCol = false;

        for (int col = 0; col < COLS; col++) {
            if (matrix[0][col] == 0) {
                transformFirstRow = true;
                break;
            }
        }

        for (int row = 0; row < ROWS; row++) {
            if (matrix[row][0] == 0) {
                transformFirstCol = true;
                break;
            }
        }

        for (int row = 1; row < ROWS; row++) {
            for (int col = 1; col < COLS; col++) {
                if (matrix[row][col] == 0) {
                    matrix[0][col] = 0;
                    matrix[row][0] = 0;
                }
            }
        }

        for (int row = 1; row < ROWS; row++) {
            if (matrix[row][0] == 0) {
                transformRowColumn(matrix, row, true);
            }
        }

        for (int col = 1; col < COLS; col++) {
            if (matrix[0][col] == 0) {
                transformRowColumn(matrix, col, false);
            }
        }

        if (transformFirstRow) {
            transformRowColumn(matrix, 0, true);
        }

        if (transformFirstCol) {
            transformRowColumn(matrix, 0, false);
        }
    }

    private void transformRowColumn(int[][] matrix, int index, boolean isRowTransformation) {
        if (isRowTransformation) {
            for (int col = 0; col < COLS; col++) {
                matrix[index][col] = 0;
            }
        } else {
            for (int row = 0; row < ROWS; row++) {
                matrix[row][index] = 0;
            }
        }
    }
}
