import java.util.HashMap;
import java.util.Map;

public class LeetCode_1074_NumberOfSubMatricsThatSumToTarget {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {

        int ROWS = matrix.length;
        int COLS = matrix[0].length;

        int[][] sub_sum = new int[ROWS][COLS];

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {

                int top = r > 0 ? sub_sum[r - 1][c] : 0;
                int left = c > 0 ? sub_sum[r][c - 1] : 0;
                int top_left = Math.min(r, c) > 0 ? sub_sum[r - 1][c - 1] : 0;
                sub_sum[r][c] = matrix[r][c] + top + left - top_left;
            }

        }

        int result = 0;

        for (int r1 = 0; r1 < ROWS; r1++) {

            for (int r2 = r1; r2 < ROWS; r2++) {

                Map<Integer, Integer> prefixFreq = new HashMap<>();
                prefixFreq.put(0, 1);

                for (int c = 0; c < COLS; c++) {

                    int curr_sum = sub_sum[r2][c] - (r1 > 0 ? sub_sum[r1 - 1][c] : 0);
                    int diff = curr_sum - target;
                    result += prefixFreq.getOrDefault(diff, 0);
                    prefixFreq.compute(curr_sum, (key, value) -> value == null ? 1 : value + 1);

                }

            }

        }

        return result;
    }
}
