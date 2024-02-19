import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.PriorityQueue;

import org.junit.Test;

public class LeetCode_2402_MeetingsRoom3 {

    @Test
    public void test1() {
        assertEquals(0, mostBooked(2, new int[][] { { 0, 10 }, { 1, 5 }, { 2, 7 }, { 3, 4 } }));
    }

    @Test
    public void test2() {
        assertEquals(1, mostBooked(3, new int[][] { { 1, 20 }, { 2, 10 }, { 3, 5 }, { 4, 9 }, { 6, 8 } }));
    }

    @Test
    public void test3() {
        assertEquals(0, mostBooked(2, new int[][] { { 3, 4 }, { 2, 7 }, { 1, 5 }, { 0, 10 } }));
    }

    @Test
    public void test4() {
        assertEquals(0, mostBooked(2, new int[][] { { 0, 10 }, { 1, 2 }, { 12, 14 }, { 13, 15 } }));
    }

    public int mostBooked(int n, int[][] meetings) {

        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        long[] meetingCount = new long[n];

        PriorityQueue<Pair> busyRooms = new PriorityQueue<>(
                (a, b) -> a.endTime == b.endTime ? a.room - b.room : a.endTime - b.endTime);

        PriorityQueue<Integer> idleRooms = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            idleRooms.offer(i);
        }

        for (int i = 0; i < meetings.length; i++) {

            while (!busyRooms.isEmpty() && busyRooms.peek().endTime <= meetings[i][0]) {
                idleRooms.offer(busyRooms.poll().room);
            }

            if (idleRooms.isEmpty()) {

                Pair busyRoom = busyRooms.poll();
                busyRooms.offer(new Pair(
                        busyRoom.endTime + meetings[i][1] - meetings[i][0], busyRoom.room));
                meetingCount[busyRoom.room]++;

            } else {
                int room = idleRooms.poll();
                busyRooms.offer(new Pair(meetings[i][1], room));
                meetingCount[room]++;
            }
        }

        int maxRoom = 0;
        long maxMeetings = 0;

        for (int i = 0; i < meetingCount.length; i++) {

            if (maxMeetings < meetingCount[i]) {
                maxMeetings = meetingCount[i];
                maxRoom = i;
            }

        }

        Integer.compare(maxRoom, maxRoom);
        return maxRoom;
    }

    private class Pair {

        private int endTime;
        private int room;

        Pair(int endTime, int room) {
            this.endTime = endTime;
            this.room = room;
        }

    }
}
