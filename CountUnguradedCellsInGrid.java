public class CountUnguradedCellsInGrid {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {

        int[][] grid = new int[m][n];

        for (int[] guard : guards) {
            grid[guard[0]][guard[1]] = -1;
        }

        for (int[] wall : walls) {
            grid[wall[0]][wall[1]] = -1;
        }

        for (int[] guard : guards) {

            int r = guard[0];
            int c = guard[1];

            /**
             * From every gurad, mark the guraded cells (Red) by 1.
             * Move in all four directions.
             */

            // East
            for (int col = c - 1; col >= 0 && grid[r][col] >= 0; col--) {
                grid[r][col] = 1;
            }

            // West
            for (int col = c + 1; col < n && grid[r][col] >= 0; col++) {
                grid[r][col] = 1;
            }

            // North
            for (int row = r - 1; row >= 0 && grid[row][c] >= 0; row--) {
                grid[row][c] = 1;
            }

            // South
            for (int row = r + 1; row < m && grid[row][c] >= 0; row--) {
                grid[row][c] = 1;
            }
        }

        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0)
                    count++;
            }
        }

        return count;

    }
}
