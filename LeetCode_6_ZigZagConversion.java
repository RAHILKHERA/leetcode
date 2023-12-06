

public class LeetCode_6_ZigZagConversion {
    public static void main(String[] args) {
        new Solution_LeetCode_6_ZigZagConversion().convert("PAYPALISHIRING", 4);
    }
}

class Solution_LeetCode_6_ZigZagConversion {
    public String convert(String s, int numRows) {

        // int i = 0, j = 0, index = 0;
        // char rowList [][] = new char [numRows][s.length()];
    

        // while (index < s.length()) {
        //     while (i < numRows) {
        //         if (index >= s.length()) {
        //             break;
        //         }
        //         rowList[i][j] = s.charAt(index);
        //         i++;
        //         index++;
        //     }

        //     i--;
        //     i--;
        //     j++;

        //     while (i >= 0) {
        //         if (index >= s.length()) {
        //             break;
        //         }
                
        //         rowList[i][j] = s.charAt(index);
        //         i--;
        //         j++;
        //         index++;
        //     }
        //     i = 1;
        //     j--;
        // }

        // index = 0;
        // String result = "";
        // for (char[] row : rowList) {
        //     for(char ch : row) {
        //         if (ch != '\0') {
        //             result += ch;
        //             index++;
        //         }
                
        //         if (index >= s.length()) {
        //             break;
        //         }
        //     }
        //     if (index >= s.length()) {
        //         break;
        //     }
        // }
        // return result;

        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }
    
        StringBuilder[] rowList = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rowList[i] = new StringBuilder();
        }
    
        int index = 0;
        int direction = 1; // 1 for downward, -1 for upward
    
        for (char c : s.toCharArray()) {
            rowList[index].append(c);
            if (index == 0) {
                direction = 1;
            } else if (index == numRows - 1) {
                direction = -1;
            }
            index += direction;
        }
    
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rowList) {
            result.append(row);
        }
    
        return result.toString();
    }
}
