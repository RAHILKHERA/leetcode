import java.util.Arrays;

public class LeetCode_2037_MinimumNumberofMovestoSeatEveryone {
    public int minMovesToSeat(int[] seats, int[] students) {

        int diff = 0;

        Arrays.sort(seats);
        Arrays.sort(students);
        for (int i = 0; i < students.length; i++) {
            diff += Math.abs(seats[i] - students[i]);
        }

        return diff;
    }
}
