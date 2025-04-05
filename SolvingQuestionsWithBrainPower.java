import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SolvingQuestionsWithBrainPower {
    private int n;

    @Test
    public void test1() {
        assertEquals(5, mostPoints(new int[][] { { 3, 2 }, { 4, 3 }, { 4, 4 }, { 2, 5 } }));
    }

    public long mostPoints(int[][] questions) {
        n = questions.length;
        return solve(questions, 0);
    }

    private long solve(int[][] questions, int index) {

        if (index >= n) {
            return 0;
        }

        int points = questions[index][0];
        int brainPower = questions[index][1];
        long take = points + solve(questions, index + brainPower + 1);
        long skip = solve(questions, index + 1);
        return Math.max(take, skip);
    }
}
