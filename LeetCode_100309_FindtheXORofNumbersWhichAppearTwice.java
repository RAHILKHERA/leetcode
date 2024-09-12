import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LeetCode_100309_FindtheXORofNumbersWhichAppearTwice {
    @Test
    public void test1() {
        assertEquals(3, duplicateNumbersXOR(new int[] { 1, 2, 2, 1 }));
    }

    public int duplicateNumbersXOR(int[] nums) {
        int result = 0;
        int[] count = new int[51];

        for (int num : nums) {
            count[num]++;

            if (count[num] == 2) {
                result ^= num;
            }
        }

        return result;
    }
}
