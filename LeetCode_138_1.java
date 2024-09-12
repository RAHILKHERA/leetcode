public class LeetCode_138_1 {

    private int row = 3;
    private int col = 4;

    public int generateKey(int num1, int num2, int num3) {

        int result = 0;
        int[][] matrix = new int[row][col];

        generateMatrix(matrix, 0, num1);
        generateMatrix(matrix, 1, num2);
        generateMatrix(matrix, 2, num3);

        int multiplier = 1;

        for (int i = col - 1; i >= 0; i--) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < row; j++) {
                min = Math.min(min, matrix[j][i]);
            }

            result += multiplier * min;
            multiplier *= 10;
        }

        return result;

    }

    private void generateMatrix(int[][] matrix, int row, int num) {

        int colIndex = col - 1;

        while (num > 0) {
            matrix[row][colIndex] = num % 10;
            num /= 10;
            colIndex--;
        }

    }
}
