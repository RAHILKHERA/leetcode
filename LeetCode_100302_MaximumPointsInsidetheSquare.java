import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

public class LeetCode_100302_MaximumPointsInsidetheSquare {
    @Test
    public void test1() {

        assertEquals(2, maxPointsInsideSquare(new int[][] { { 2, 2 }, { -1, -2 }, { -4, -4 }, { -3, -1 }, { 3, -3 } },
                "abdca"));
    }

    public int maxPointsInsideSquare(int[][] points, String s) {

        int pointsCovered = 0;

        int n = points.length;
        boolean[] inside = new boolean[26];

        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] row1, int[] row2) {
                // First, compare by the x-coordinates
                int cmp = Integer.compare(row1[0], row2[0]);
                // If the x-coordinate is same, compare y coordinated.
                if (cmp == 0) {
                    cmp = Integer.compare(row1[1], row2[1]);
                }
                return cmp;
            }
        });

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, Math.abs(points[i][0]));
            min = Math.min(min, Math.abs(points[i][1]));
        }

        while (pointsList.size() > 0) {

            // Check if all the remaining points are covered in the current square.
            boolean foundSameLabel = false;
            int newlyCovered = 0;
            Iterator<Points> iterator = pointsList.iterator();

            while (iterator.hasNext()) {

                // Check if label is already present if present break both the loops as no need
                // to expand the square.

                Points currentPoint = iterator.next();

                if (-min <= currentPoint.getX() &&
                        currentPoint.getX() <= min &&
                        -min <= currentPoint.getY() &&
                        currentPoint.getY() <= min) {
                    foundSameLabel = inside[currentPoint.getLabel() - 'a'];
                    if (foundSameLabel) {
                        break;
                    }
                    iterator.remove();
                    newlyCovered++;
                    inside[currentPoint.getLabel() - 'a'] = true;
                }
            }

            if (foundSameLabel) {
                break;
            }

            pointsCovered += newlyCovered;

            min++;
        }

        return pointsCovered;
    }

    private class Points {

        private int x;
        private int y;
        private char label;

        Points(int x, int y, char label) {
            this.x = x;
            this.y = y;
            this.label = label;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public char getLabel() {
            return label;
        }
    }
}
