public class LeetCode_1582_SpecialPositionsInBinaryMatrix {
    public static void main(String[] args) {
        new Solution_LeetCode_1582_SpecialPositionsInBinaryMatrix().numSpecial(new int [][] {{1,0,0}, {0,0,1} });
    }
}

class Solution_LeetCode_1582_SpecialPositionsInBinaryMatrix {
    
    public int numSpecial(int[][] mat) {

        int [] rows = new int[mat.length];
        int [] columns = new int [mat[0].length];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                
                if (mat[i][j] == 1) {
                    rows[i]++;
                    columns[j]++;
                }
                
            }
        }

        int specialNum = 0;

        for (int i = 0; i < rows.length; i++) {
            for (int j = 0; j < columns.length; j++) {
                if (rows[i] == 1 && columns[j] == 1 && mat[i][j] == 1) {
                    specialNum++;
                }
            }
        }

        return specialNum;
    }
}
