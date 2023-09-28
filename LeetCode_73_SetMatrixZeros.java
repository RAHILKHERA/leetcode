public class LeetCode_73_SetMatrixZeros {
    public static void main(String[] args) {
        //new Solution_LeetCode_73_SetMatrixZeros().setZeroes(new int[][]{{1,1,1}, {1,0,1}, {1,1,1}});
        //new Solution_LeetCode_73_SetMatrixZeros().setZeroes(new int[][]{{0,1,2,0}, {3,4,5,2}, {1,3,1,5}});
        new Solution_LeetCode_73_SetMatrixZeros().setZeroes(new int[][]{{1,0,3}});
    }
}

class Solution_LeetCode_73_SetMatrixZeros {

    public void setZeroes(int[][] matrix) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        boolean setFirstRow = false;
        boolean setFirstColumn = false;         

        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                setFirstColumn= true;
                break;
            }
        } 

        for (int j = 0; j< n; j++) {
            if (matrix[0][j] == 0) {
                setFirstRow = true;
                break;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }


        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
               resetRoworColumn(matrix, n, i, true);
            }
        }

        for (int j = 1; j < n; j++) {
            if (matrix[0][j] == 0) {
                resetRoworColumn(matrix, m, j, false);   
            }
        }


        if (setFirstRow) {
            resetRoworColumn(matrix, n, 0, true);
        }

        if (setFirstColumn) {
            resetRoworColumn(matrix, m, 0, false);
        }
    }

    public void resetRoworColumn(int [][] matrix, int noOfRowsOrColmn, int index, boolean modifyColumn) {

        if (modifyColumn) {
            for (int i = 0;  i < noOfRowsOrColmn; i++) {
                matrix[index][i] = 0;
            }

        } else {
            for (int i = 0;  i < noOfRowsOrColmn; i++) {
                matrix[i][index] = 0;
            }
        }
    }
}