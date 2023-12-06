public class LeetCode_2038_RemoveColoredPiecesIfBothNeighborsAretheSameColor {
    public static void main(String[] args) {
        System.out.println(new Solution_LeetCode_2038_RemoveColoredPiecesIfBothNeighborsAretheSameColor().winnerOfGame("ABBBBBBBAAA"));
    }
}

class Solution_LeetCode_2038_RemoveColoredPiecesIfBothNeighborsAretheSameColor {
    public boolean winnerOfGame(String colors) {
        
        int a = 0, b = 0;
        
        if(colors.length() < 3) {
            return false;
        }

        for (int i = 1; i < colors.length() - 1 ; i++) {

            char left = colors.charAt(i-1);
            char right = colors.charAt(i+1);
            char ch = colors.charAt(i);

            if (left == ch && ch == right) {
                 if (ch == 'A') {
                    a++;
                 } else {
                    b++;
                 }

            }
            
        }

        return a > b;
        
    }
}
