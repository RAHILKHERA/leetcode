import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class LeetCode_452_MinimumNumberofArrowstoBurstBalloons {

    @Test
    public void test1() {
        assertEquals(2, findMinArrowShots(new int[][] { { 10, 16 }, { 2, 8 }, { 1, 6 }, { 7, 12 } }));
    }

    @Test
    public void test2() {
        assertEquals(4, findMinArrowShots(new int[][] { { 1, 2 }, { 3, 4 }, { 5, 6 }, { 7, 8 } }));
    }

    @Test
    public void test3() {
        assertEquals(2, findMinArrowShots(new int[][] { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 5 } }));
    }

    @Test
    public void test4() {
        assertEquals(2, findMinArrowShots(new int[][] { { 3, 9 }, { 7, 12 }, { 3, 8 }, { 6, 8 }, { 9, 10 }, { 2, 9 },
                { 0, 9 }, { 3, 9 }, { 0, 6 }, { 2, 8 } }));
    }

    @Test
    public void test5() {
        assertEquals(2, findMinArrowShots(new int[][] { { -2147483646, -2147483645 }, { 2147483646, 2147483647 } }));
    }

    public int findMinArrowShots(int[][] points) {

        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int idx = 0, j = 0, count = 0;

        while (idx < points.length) {

            count++;

            while (j < points.length && points[j][0] <= points[idx][1]) {
                j++;
            }

            idx = j;

        }

        return count;
    }
}
