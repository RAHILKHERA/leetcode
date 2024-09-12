public class LeetCode_136_2 {
    public int minFlips(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int rowFilp = 0, colFlip = 0;

        // row;
        for (int i = 0; i < m; i++) {

            int j = 0, k = n - 1;

            while (j <= k) {
                if (grid[i][j] != grid[i][k]) {
                    rowFilp++;
                }
                j++;
                k--;
            }
        }

        // col
        for (int i = 0; i < n; i++) {
            int j = 0, k = m - 1;

            while (j <= k) {
                if (grid[j][i] != grid[k][i]) {
                    colFlip++;
                }
                j++;
                k--;
            }
        }

        return Math.min(rowFilp, colFlip);
    }
}
