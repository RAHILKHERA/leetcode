public class LeetCode_1289_MinimumFallingPathSum2 {
    public int minFallingPathSum(int[][] grid) {

        int n = grid.length;

        int nextMin1 = Integer.MAX_VALUE;
        int nextMin2 = Integer.MAX_VALUE;
        int nextMin1Index = -1;

        /**
         * Fetch minimum (nextMin1) and 2nd minimum from the last row.
         */

        for (int col = 0; col < n; col++) {

            if (nextMin1 >= grid[n - 1][col]) {
                nextMin2 = nextMin1;
                nextMin1 = grid[n - 1][col];
                nextMin1Index = col;

            } else if (nextMin2 >= grid[n - 1][col]) {
                nextMin2 = grid[n - 1][col];
            }
        }

        /**
         * From 2nd last row to the first row, for each cell, add the minimum (min1) to
         * the cell if the column is not equal to index of minium (nextMin1Index).
         * 
         * If col is equal to nextMin1Index, add nextMin2;
         * 
         * find min1, min2 and min1Index in the current column too;
         */

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int min1Index = -1;

        for (int row = n - 2; row >= 0; row--) {

            for (int col = 0; col < n; col++) {
                int value;

                if (col != nextMin1Index) {
                    value = grid[row][col] + nextMin1;
                } else {
                    value = grid[row][col] + nextMin2;
                }

                if (min1 >= value) {
                    min2 = min1;
                    min1 = value;
                    min1Index = col;
                } else if (min2 >= value) {
                    min2 = value;
                }
            }

            nextMin1 = min1;
            nextMin2 = min2;
            nextMin1Index = min1Index;
        }

        return nextMin1;
    }
}
