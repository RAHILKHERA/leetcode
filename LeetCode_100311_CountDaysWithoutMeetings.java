import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class LeetCode_100311_CountDaysWithoutMeetings {

    @Test
    public void test1() {
        assertEquals(1, countDays(5, new int[][] { { 2, 4 }, { 1, 3 } }));
    }

    @Test
    public void test2() {
        assertEquals(1, countDays(14, new int[][] { { 6, 11 }, { 7, 13 }, { 8, 9 }, { 5, 8 }, { 3, 13 }, { 11, 13 },
                { 1, 3 }, { 5, 10 }, { 8, 13 }, { 3, 9 } }));
    }

    public int countDays(int days, int[][] meetings) {

        if (meetings.length == 1) {
            return days - meetings[0][1] + meetings[0][0] - 1;
        }

        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        int i = 0, j = 1;

        while (j < meetings.length) {

            int start = meetings[i][0];
            int end = meetings[i][1];

            while (j < meetings.length && meetings[j][0] <= end) {

                end = Math.max(end, meetings[j][1]);
                j++;
            }
            days = days - end + start - 1;
            i = j;
        }

        return days;
    }
}
