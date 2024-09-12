import java.util.ArrayList;
import java.util.List;

public class LeetCode_1992_FindAllGroupsOfFarmland {
    public int[][] findFarmland(int[][] land) {

        int rows = land.length;
        int cols = land[0].length;

        List<int[]> result = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (land[i][j] == 1) {

                    int[] coordinates = new int[] { i, j, i, j };

                    dfs(land, i, j, coordinates);

                    result.add(coordinates);
                }
            }
        }

        return result.toArray(new int[result.size()][]);
    }

    private void dfs(int[][] land, int row, int col, int[] coordinates) {

        int rows = land.length;
        int cols = land[0].length;

        if (row < 0 || row == rows || col == cols || col < 0 || land[row][col] != 1) {
            return;
        }

        coordinates[0] = Math.min(coordinates[0], row);
        coordinates[1] = Math.min(coordinates[1], col);
        coordinates[2] = Math.max(coordinates[2], row);
        coordinates[3] = Math.max(coordinates[3], col);

        // mark it visited.
        land[row][col] = -1;

        dfs(land, row + 1, col, coordinates);
        dfs(land, row - 1, col, coordinates);
        dfs(land, row, col + 1, coordinates);
        dfs(land, row, col - 1, coordinates);
    }

}
