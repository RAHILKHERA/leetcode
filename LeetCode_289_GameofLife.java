public class LeetCode_289_GameofLife {
    public static void main(String[] args) {
        new Solution_LeetCode_289_GameofLife().gameOfLife(new int [][] {{0,1,0},
                                                                        {0,0,1},
                                                                        {1,1,1},
                                                                        {0,0,0}});      
    }
}

class Solution_LeetCode_289_GameofLife {

    public void gameOfLife(int[][] board) {
        
        for (int i =0; i < board.length; i++) {
            for (int j=0; j < board[i].length; j++) {
                processCell(board, i, j);
            }
        }

        for (int i =0; i < board.length; i++) {
            for (int j=0; j < board[i].length; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 1;
                } else if (board[i][j] == -1) {
                    board[i][j] = 0;
                }
            }
        }

        return;

    }

    private void processCell(int [][] board, int i, int j) {

        int m = board.length;
        int n = board[0].length;
        int total = 0;
        
        if (i > 0) {
            if (j > 0) {
               total += board[i-1][j-1] == 2 ? 0 : board[i-1][j-1] == -1 ? 1 : board[i-1][j-1];
            }
            total += board[i-1][j] == 2 ? 0 :  board[i-1][j] == -1 ? 1 : board[i-1][j];
            if (j < n -1) {
                total += board[i-1][j+1] == 2 ? 0 :  board[i-1][j+1] == -1 ? 1 : board[i-1][j+1];
            } 
        }

        if (j > 0) {
            total += board[i][j-1] == 2 ? 0 :  board[i][j-1] == -1 ? 1 : board[i][j-1];
        }

        if (j < n-1) {
             total += board[i][j+1] == 2 ? 0 :  board[i][j+1] == -1 ? 1 : board[i][j+1];
        }
        
       
        if (i < m - 1) {
            if (j > 0) {
               total += board[i+1][j-1] == 2 ? 0 :  board[i+1][j-1] == -1 ? 1 : board[i+1][j-1];
            }
            total += board[i+1][j] == 2 ? 0 :  board[i+1][j] == -1 ? 1 : board[i+1][j];;
            if (j < n -1) {
                total += board[i+1][j+1] == 2 ? 0 :  board[i+1][j+1] == -1 ? 1 : board[i+1][j+1];
            }
        }

        if ((total < 2 || total > 3)  && board[i][j] == 1 ) {
            board[i][j] = -1;
        } else if  (total == 3 && board[i][j] == 0) {
            board[i][j] = 2;
        }

    }
}
