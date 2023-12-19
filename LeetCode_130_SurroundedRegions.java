public class LeetCode_130_SurroundedRegions {
    public void solve(char[][] board) {

        int m = board.length;
        int n = board[0].length;

        /**
         * The edge 'O' cannot be flipped.
         * Checking all the edges for '0' and the connected tile with this region.
         * Marking 'O' region visited with '#'
         */
        // Top Row
        for (int i = 0, j = 0; j < n; j++) {
            if (board[i][j] == 'O') {
                dfs(board, i, j, m, n);
            }
        }

        // Bottom Row
        for (int i = m - 1, j = 0; j < n; j++) {
            if (board[i][j] == 'O') {
                dfs(board, i, j, m, n);
            }
        }

        // Left Column
        for (int i = 0, j = 0; i < m; i++) {
            if (board[i][j] == 'O') {
                dfs(board, i, j, m, n);
            }
        }

        // Right Column
        for (int i = 0, j = n - 1; i < m; i++) {
            if (board[i][j] == 'O') {
                dfs(board, i, j, m, n);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }

    }

    private void dfs(char[][] board, int i, int j, int rows, int cols) {

        if (i < 0 || i >= rows || j < 0 || j >= cols || board[i][j] == 'X' || board[i][j] == '#') {
            return;
        }

        if (board[i][j] == 'O')
            board[i][j] = '#'; // Mark the current cell as visited

        // Explore all four directions
        dfs(board, i - 1, j, rows, cols);
        dfs(board, i + 1, j, rows, cols);
        dfs(board, i, j - 1, rows, cols);
        dfs(board, i, j + 1, rows, cols);
    }

}
