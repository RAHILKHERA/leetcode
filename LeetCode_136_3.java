import java.util.HashSet;
import java.util.Set;

public class LeetCode_136_3 {
    public int minFlips(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int ones = 0;
        Set<String> set = new HashSet<>();

        int rowFilp = 0, colFlip = 0;

        // row;
        for (int i = 0; i < m; i++) {

            int j = 0, k = n - 1;

            while (j <= k) {
                if (grid[i][j] != grid[i][k]) {

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

        return 0;
    }
}
