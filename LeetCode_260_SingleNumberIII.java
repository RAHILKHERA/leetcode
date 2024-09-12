import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class LeetCode_260_SingleNumberIII {

    @Test
    public void test1() {
        assertArrayEquals(new int[] { 3, 5 }, singleNumber(new int[] { 1, 2, 1, 3, 2, 5 }));
    }

    public int[] singleNumber(int[] nums) {

        int XOR = 0;

        for (int num : nums) {
            XOR ^= num;
        }

        int mask = XOR & -XOR;
        int a = 0, b = 0;

        for (int num : nums) {

            if ((num & mask) == mask) {
                a ^= num;
            } else {
                b ^= num;
            }
        }

        return new int[] { a, b };
    }
}
