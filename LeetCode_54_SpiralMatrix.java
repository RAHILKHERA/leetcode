import java.util.ArrayList;
import java.util.List;

public class LeetCode_54_SpiralMatrix {

    public static void main(String[] args) {
        // System.out.println(new Solution_LeetCode_54_SpiralMatrix().spiralOrder(new int[][] { { 1, 2, 3, 4, 5, 6}, 
        //                                                                                      { 7, 8, 9, 10, 11, 12}, 
        //                                                                                      { 13, 14, 15, 16, 17, 18}}));

        // System.out.println(new Solution_LeetCode_54_SpiralMatrix().spiralOrder(new int[][] { { 1, 2, 3, 4, 5, 6}, 
        //                                                                                      { 7, 8, 9, 10, 11, 12}, 
        //                                                                                      { 13, 14, 15, 16, 17, 18},
        //                                                                                      { 19, 20, 21, 22, 23, 24}, 
        //                                                                                      { 25, 26, 27, 28, 29, 30}, 
        //                                                                                      { 31, 32, 33, 34, 35, 36}}));

        // System.out.println(new Solution_LeetCode_54_SpiralMatrix().spiralOrder(new int[][] { { 1, 2, 3, 4, 5, 6}, 
        //                                                                                      { 7, 8, 9, 10, 11, 12}}));

        // System.out.println(new Solution_LeetCode_54_SpiralMatrix().spiralOrder(new int[][] { { 1, 2, 3}, 
        //                                                                                      { 4, 5, 6}, 
        //                                                                                      { 7, 8, 9},
        //                                                                                      { 10, 11, 12}, 
        //                                                                                      { 13, 14, 15}, 
        //                                                                                      { 16, 17, 18}}));

        System.out.println(new Solution_LeetCode_54_SpiralMatrix().spiralOrder(new int[][] { { 1, 2, 3, 4}, 
                                                                                             { 5, 6, 7, 8}, 
                                                                                             { 9, 10, 11, 12},
                                                                                             { 13, 14, 15, 16}, 
                                                                                             { 17, 18, 19, 20}, 
                                                                                             { 21, 22, 23, 24},
                                                                                             { 25, 26, 27,28}}));



        
                                                                                             
    }

}

class Solution_LeetCode_54_SpiralMatrix {

    private List<Integer> result;

    public List<Integer> spiralOrder(int[][] matrix) {

        this.result = new ArrayList<Integer>();

        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0, j = n - 1;
       
        while (i < Math.ceil(m) && j >= i) {

            // Top Row
            int start = i, end = n - i - 1;
            createListRowWise(matrix, i, start, end, true, false);
            if (m * n == this.result.size()) {
                break;
            }

            // Last Column
            end = m - i - 1;
            createListRowWise(matrix, j, start + 1, end, false, false);
            if (m * n == this.result.size()) {
                break;
            }

            // Last Row
            start = n - i - 2;
            end = i;
            createListRowWise(matrix, m - i - 1, start, end, true, true);
            if (m * n == this.result.size()) {
                break;
            }

            // First Column
            start = m - i - 2;
            createListRowWise(matrix, i, start, end+1, false, true);
            if (m * n == this.result.size()) {
                break;
            }
            i++;
            j--;
        }

        return result;
    }

    private void createListRowWise(int[][] matrix,
            int constantFactor,
            int starting,
            int ending,
            boolean rowConstant,
            boolean reverseOrder) {

        if (reverseOrder) {

            if (rowConstant) {
                for (int i = starting; i >= ending; i--) {
                    this.result.add(matrix[constantFactor][i]);
                }
            } else {
                for (int i = starting; i >= ending; i--) {
                    this.result.add(matrix[i][constantFactor]);
                }
            }

        } else {

            if (rowConstant) {
                for (int i = starting; i <= ending; i++) {
                    this.result.add(matrix[constantFactor][i]);
                }
            } else {
                for (int i = starting; i <= ending; i++) {
                    this.result.add(matrix[i][constantFactor]);
                }
            }
        }
    }
}
