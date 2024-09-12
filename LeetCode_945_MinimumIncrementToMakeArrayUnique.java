import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LeetCode_945_MinimumIncrementToMakeArrayUnique {

    @Test
    public void test1() {
        assertEquals(1, minIncrementForUnique(new int[] { 1, 2, 2 }));
    }

    public int minIncrementForUnique(int[] nums) {

        int moves = 0;

        int max = -1;

        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i]) {
                max = nums[i];
            }
        }

        int count[] = new int[nums.length + max];

        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }

        for (int left = 0; left < count.length; left++) {

            if (count[left] <= 1) {
                continue;
            }

            int duplicates = count[left] - 1;
            count[left + 1] += duplicates;
            count[left] = 1;
            moves += duplicates;

        }

        return moves;
    }
}
