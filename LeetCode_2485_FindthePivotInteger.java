import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LeetCode_2485_FindthePivotInteger {

    @Test
    public void test1() {
        assertEquals(6, pivotInteger(8));
    }

    @Test
    public void test2() {
        assertEquals(-1, pivotInteger(4));
    }

    public int pivotInteger(int n) {

        if (n == 1) {
            return 1;
        }

        int leftSum = n * (n + 1) / 2;
        int rightSum = n;

        for (int i = n - 1; i >= 1; i--) {
            leftSum -= (i + 1);
            rightSum += i;
            if (leftSum == rightSum) {
                return i;
            }
        }

        return -1;
    }
}
