import java.util.ArrayList;
import java.util.HashMap;

public class LeetCode_36_ValidSudoku {
    public static void main(String[] args) {
        char [][]board = {
            {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        new Solution_LeetCode_36_ValidSudoku().isValidSudoku(board);
    }    
}

class Solution_LeetCode_36_ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        
        HashMap<Character, ArrayList<Node>> nodeMap = new HashMap<>(); 
       
        for (int row =0; row < board.length; row++) {
            
            for(int column=0; column < board[row].length; column++) {
                
                char ch = board[row][column];
                
                if (ch == '.') {
                    continue;
                }
                
                Node node = new Node(row, column);
                ArrayList<Node> nodeList = null;

                if (nodeMap.containsKey(ch)) {
                    nodeList = nodeMap.get(ch);     
                    if (nodeList.contains(node)) {
                        return false;
                    } 
                    nodeList.add(node);
                } else {
                    
                    nodeList = new ArrayList<>();
                    nodeList.add(node);
                    nodeMap.put(ch, nodeList);
                }
            }
        }    
        return true;
    }
}

class Node {

    private static int [][] gridVaules = {{0,0,0,1,1,1,2,2,2}, 
                                          {0,0,0,1,1,1,2,2,2}, 
                                          {0,0,0,1,1,1,2,2,2},
                                          {3,3,3,4,4,4,5,5,5}, 
                                          {3,3,3,4,4,4,5,5,5}, 
                                          {3,3,3,4,4,4,5,5,5},
                                          {6,6,6,7,7,7,8,8,8},
                                          {6,6,6,7,7,7,8,8,8},
                                          {6,6,6,7,7,7,8,8,8},
                                        };

    int row, column, grid; 

    Node(int row, int column) {
        this.row = row;
        this.column = column;
        this.grid = gridVaules[row][column];
    }

    @Override
    public boolean equals(Object obj) {
        
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Node object = (Node) obj;

        return this.row == object.row || this.column == object.column || this.grid == object.grid;       
    }

}