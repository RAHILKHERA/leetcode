public class LeetCode_2373_LargestLocalValuesInMatrix {
    public int[][] largestLocal(int[][] grid) {

        int n = grid.length;
        int[][] maxLocal = new int[n - 2][n - 2];

        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                maxLocal[i][j] = getLocal(grid, i, j);
            }
        }

        return maxLocal;
    }

    private int getLocal(int[][] grid, int row, int col) {

        int max = 0;

        max = grid[row][col] > max ? grid[row][col] : max;
        max = grid[row][col + 1] > max ? grid[row][col + 1] : max;
        max = grid[row][col + 2] > max ? grid[row][col + 2] : max;
        max = grid[row + 1][col] > max ? grid[row + 1][col] : max;
        max = grid[row + 1][col + 1] > max ? grid[row + 1][col + 1] : max;
        max = grid[row + 1][col + 2] > max ? grid[row + 1][col + 2] : max;
        max = grid[row + 2][col] > max ? grid[row + 2][col] : max;
        max = grid[row + 2][col + 1] > max ? grid[row + 2][col + 1] : max;
        max = grid[row + 2][col + 2] > max ? grid[row + 2][col + 2] : max;

        return max;
    }

}
