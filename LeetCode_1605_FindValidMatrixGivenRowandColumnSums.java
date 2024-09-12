public class LeetCode_1605_FindValidMatrixGivenRowandColumnSums {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {

        int rows = rowSum.length;
        int cols = colSum.length;
        int[][] result = new int[rows][cols];
        int rIndex = 0, cIndex = 0;

        while (rIndex < rows && cIndex < cols) {
            result[rIndex][cIndex] = Math.min(rowSum[rIndex], colSum[cIndex]);
            rowSum[rIndex] -= result[rIndex][cIndex];
            colSum[cIndex] -= result[rIndex][cIndex];
            if (rowSum[rIndex] == 0) {
                rIndex++;
            }
            if (colSum[cIndex] == 0) {
                cIndex++;
            }

        }
        return result;
    }
}
