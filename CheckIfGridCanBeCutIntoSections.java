import static org.junit.Assert.assertFalse;

import java.util.Arrays;

import org.junit.Test;

public class CheckIfGridCanBeCutIntoSections {

    @Test
    public void test1() {
        assertFalse(checkValidCuts(4,
                new int[][] { { 0, 2, 2, 4 }, { 1, 0, 3, 2 }, { 2, 2, 3, 4 }, { 3, 0, 4, 2 }, { 3, 2, 4, 4 } }));
    }

    public boolean checkValidCuts(int n, int[][] rectangles) {

        return mergeRectangles(rectangles, 0) || mergeRectangles(rectangles, 1);
    }

    private boolean mergeRectangles(int[][] intervals, int dim) {
        // 1. Sort it by start and if start is same then by end.
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[dim], b[dim]));

        // 2. Merge overlapping intervals. If the size of mergedIntervals >= 3 => two
        // cuts can be made.

        int maxEnd = intervals[0][dim + 2];
        int i = 0;
        int j = 1;
        int count = 0;
        while (j < intervals.length) {

            while (j < intervals.length && maxEnd > intervals[j][dim]) {
                maxEnd = Math.max(maxEnd, intervals[j][dim + 2]);
                j++;
            }

            count++;
            i = j;
            if (i < intervals.length) {
                maxEnd = intervals[i][dim + 2];
            }

            j++;
        }

        return count >= 2;
    }
}
