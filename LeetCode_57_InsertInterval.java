import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class LeetCode_57_InsertInterval {

    @Test
    public void test1() {
        assertArrayEquals(new int[][] { { 1, 5 }, { 6, 9 } },
                insert(new int[][] { { 1, 3 }, { 6, 9 } }, new int[] { 2, 5 }));
    }

    @Test
    public void test2() {
        assertArrayEquals(new int[][] { { 1, 2 }, { 3, 10 }, { 12, 16 } },
                insert(new int[][] { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 } }, new int[] { 4, 8 }));
    }

    @Test
    public void test3() {
        assertArrayEquals(new int[][] { { 1, 2 }, { 3, 5 }, { 6, 7 } },
                insert(new int[][] { { 1, 2 }, { 6, 7 } }, new int[] { 3, 5 }));
    }

    @Test
    public void test4() {
        assertArrayEquals(new int[][] { { 1, 2 }, { 3, 5 }, { 6, 7 } },
                insert(new int[][] { { 3, 5 }, { 6, 7 } }, new int[] { 1, 2 }));
    }

    @Test
    public void test5() {
        assertArrayEquals(new int[][] { { 1, 5 }, { 6, 8 } },
                insert(new int[][] { { 1, 5 } }, new int[] { 6, 8 }));
    }

    @Test
    public void test6() {
        assertArrayEquals(new int[][] { { 0, 5 } },
                insert(new int[][] { { 1, 5 } }, new int[] { 0, 3 }));
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {

        if (intervals.length == 0) {
            return new int[][] { newInterval };
        }

        List<int[]> result = new ArrayList<>();
        int insertPoisiton = -1;
        boolean merged = false;

        // either merge the new interval or find the position to insert the new interval

        for (int i = 0; i < intervals.length; i++) {

            int iStart = intervals[i][0];
            int iEnd = intervals[i][1];
            if (newInterval[0] <= iEnd && newInterval[0] >= iStart) {

                if (iEnd < newInterval[1]) {
                    intervals[i][1] = newInterval[1];
                }
                merged = true;
                break;
            } else if (newInterval[0] <= iStart && iStart <= newInterval[1]) {

                intervals[i][0] = newInterval[0];

                if (iEnd < newInterval[1]) {
                    intervals[i][1] = newInterval[1];
                }
                merged = true;
                break;

            } else if (newInterval[1] < iStart) {
                insertPoisiton = i;
                break;
            }
        }

        // If insert position is still -1, means the new interval is merged in one of
        // the intervals. Check if there are anymore overlapped intervals. If any merge
        // it. Else if the position is set, then new interval is not merged to any
        // existing interval, just insert it at its appropriate position.
        if (merged) {
            int i = 0;
            while (i < intervals.length) {

                int j = i + 1;
                int iEnd = intervals[i][1];

                while (j < intervals.length) {

                    int jStart = intervals[j][0];
                    int jEnd = intervals[j][1];

                    if (iEnd >= jStart) {
                        if (jEnd > iEnd) {
                            intervals[i][1] = jEnd;
                        }
                        j++;
                        ;
                    } else {
                        break;
                    }

                }
                result.add(intervals[i]);
                i = j;

            }
        } else {

            for (int i = 0; i < intervals.length; i++) {
                if (i == insertPoisiton) {
                    result.add(newInterval);
                }
                result.add(intervals[i]);
            }

            if (insertPoisiton == -1) {
                result.add(newInterval);
            }
        }

        int[][] res = new int[result.size()][2];

        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }

        return res;
    }
}
