public class LeetCode_1255_MinimumtimeVisitingAllPoints {
    public int minTimeToVisitAllPoints(int[][] points) {

        int totalTime = 0;

        for (int i = 1; i < points.length; i++) {

            totalTime += Math.max(Math.abs(points[i][0] - points[i - 1][0]), Math.abs(points[i][1] - points[i - 1][1]));
        }

        return totalTime;
    }
}
