public class LeetCode_661_ImageSmoother {
    public int[][] imageSmoother(int[][] img) {

        int m = img.length;
        int n = img[0].length;
        int[][] result = new int[m][n];

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                int count = 0, sum = 0;

                // Top Row in 3 x 3
                if (i > 0) {

                    // Left Column
                    if (j > 0) {
                        count++;
                        sum += img[i - 1][j - 1];
                    }

                    // Middle Column
                    count++;
                    sum += img[i - 1][j];

                    // Right Column
                    if (j < n - 1) {
                        count++;
                        sum += img[i - 1][j + 1];
                    }
                }

                // Middle Row, Left Column
                if (j > 0) {
                    count++;
                    sum += img[i][j - 1];
                }

                // Middle Row, Middle Column
                count++;
                sum += img[i][j];

                // Middle Row, Right Column
                if (j < n - 1) {
                    count++;
                    sum += img[i][j + 1];
                }

                // Bottom Row

                if (i < m - 1) {

                    // Left Column
                    if (j > 0) {
                        count++;
                        sum += img[i + 1][j - 1];
                    }

                    // Middle Column
                    count++;
                    sum += img[i + 1][j];

                    // Right Column

                    if (j < n - 1) {
                        count++;
                        sum += img[i + 1][j + 1];
                    }

                }

                result[i][j] = (int) Math.floor(sum / count);

            }
        }
        return result;
    }
}
