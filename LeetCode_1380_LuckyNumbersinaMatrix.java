import java.util.ArrayList;
import java.util.List;

public class LeetCode_1380_LuckyNumbersinaMatrix {
    public List<Integer> luckyNumbers(int[][] matrix) {

        int ROWS = matrix.length;
        int COLS = matrix[0].length;
        int[] rowMin = new int[ROWS];
        int[] colMax = new int[COLS];

        for (int i = 0; i < ROWS; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < COLS; j++) {
                min = Math.min(min, matrix[i][j]);
            }
            rowMin[i] = min;
        }

        for (int i = 0; i < COLS; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < ROWS; j++) {
                max = Math.min(max, matrix[j][i]);
            }
            colMax[i] = max;
        }

        List<Integer> luckyNumbers = new ArrayList<>();
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {

                if (rowMin[i] == colMax[j]) {
                    luckyNumbers.add(rowMin[i]);
                }
            }
        }

        return luckyNumbers;
    }
}
