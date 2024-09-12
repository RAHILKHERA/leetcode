
public class LeetCode_3242_DesignNeighborSumService {
    class neighborSum {

        private int[][] map;
        private int[][] grid;
        private int n;

        public neighborSum(int[][] grid) {
            this.grid = grid;
            n = grid.length;
            this.map = new int[n * n][2];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    map[grid[i][j]][0] = i;
                    map[grid[i][j]][1] = j;
                }
            }
        }

        public int adjacentSum(int value) {

            int x = map[value][0];
            int y = map[value][1];
            int a = (x - 1) >= 0 ? grid[x - 1][y] : 0;
            int b = (y - 1) >= 0 ? grid[x][y - 1] : 0;
            int c = (y + 1) < n ? grid[x][y + 1] : 0;
            int d = (x + 1) < n ? grid[x + 1][y] : 0;
            return a + b + c + d;
        }

        public int diagonalSum(int value) {

            int x = map[value][0];
            int y = map[value][1];
            int topLeft = ((x - 1) >= 0 && (y - 1) >= 0) ? grid[x - 1][y - 1] : 0;
            int topRight = ((x - 1) >= 0 && (y + 1) < n) ? grid[x - 1][y + 1] : 0;
            int bottomLeft = ((x + 1) < n && (y - 1) >= 0) ? grid[x + 1][y - 1] : 0;
            int bottomRight = ((x + 1) < n && (y + 1) < n) ? grid[x + 1][y + 1] : 0;
            return topLeft + topRight + bottomLeft + bottomRight;
        }
    }
}
