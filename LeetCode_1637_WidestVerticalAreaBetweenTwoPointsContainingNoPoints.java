import java.util.Arrays;

public class LeetCode_1637_WidestVerticalAreaBetweenTwoPointsContainingNoPoints {

    public static void main(String[] args) {
        new LeetCode_1637_WidestVerticalAreaBetweenTwoPointsContainingNoPoints().maxWidthOfVerticalArea(new int[][] {
                { 8, 7 },
                { 9, 9 },
                { 7, 4 },
                { 9, 7 }
        });
    }

    public int maxWidthOfVerticalArea(int[][] points) {

        int[] list = new int[points.length];

        for (int i = 0; i < points.length; i++) {
            list[i] = points[i][0];
        }

        Arrays.sort(list);

        int max = Integer.MIN_VALUE;

        for (int i = list.length - 1; i > 0; i--) {
            if ((list[i] - list[i - 1]) > max) {
                max = list[i] - list[i - 1];
            }
        }

        return max;

        // Arrays.sort(points, (pA, pB) -> pA[0] - pB[0]);
        // int maxDiff = 0;
        // for (int idx = 1; idx < points.length; idx++) {
        // maxDiff = Math.max(points[idx][0] - points[idx - 1][0], maxDiff);
        // }
        // return maxDiff;

    }
}
