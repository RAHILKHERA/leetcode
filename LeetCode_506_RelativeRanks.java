import static org.junit.Assert.assertArrayEquals;

import java.util.PriorityQueue;

import org.junit.Test;

public class LeetCode_506_RelativeRanks {

    @Test
    public void test1() {
        assertArrayEquals(new String[] { "Gold Medal", "5", "Bronze Medal", "Silver Medal", "4" },
                findRelativeRanks(new int[] { 10, 3, 8, 9, 4 }));
    }

    public String[] findRelativeRanks(int[] score) {

        int max = -1;
        String ranks[] = new String[score.length];

        for (int i : score) {
            max = max < i ? i : max;
        }

        int[] scroeIndex = new int[max + 1];
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        for (int i = 0; i < score.length; i++) {
            scroeIndex[score[i]] = i;
            queue.offer(score[i]);
        }

        int count = 0;

        while (!queue.isEmpty()) {

            int currentScore = queue.poll();
            if (count == 0) {
                ranks[scroeIndex[currentScore]] = "Gold Medal";
            } else if (count == 1) {
                ranks[scroeIndex[currentScore]] = "Silver Medal";
            } else if (count == 2) {
                ranks[scroeIndex[currentScore]] = "Bronze Medal";
            } else {
                ranks[scroeIndex[currentScore]] = Integer.toString(count + 1);
            }
            count++;
        }

        return ranks;
    }

}