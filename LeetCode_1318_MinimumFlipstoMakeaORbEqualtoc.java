import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LeetCode_1318_MinimumFlipstoMakeaORbEqualtoc {

    @Test
    public void test1() {
        assertEquals(4, minFlips(5, 2, 8));
    }

    public int minFlips(int a, int b, int c) {

        if ((a | b) == c) {
            return 0;
        }

        int count = 0;

        while (a != 0 && b != 0) {
            boolean aSet = (a & 1) == 1;
            boolean bSet = (b & 1) == 1;
            boolean cSet = (c & 1) == 1;

            if (!cSet) { // c = 0,
                if (aSet)
                    count++;

                if (bSet)
                    count++;

            } else if (!aSet && !bSet) // c = 1 and a and b's bit both are not set, setting one of them is sufficient.
                count++;

            a >>= 1;
            b >>= 1;
            c >>= 1;
        }

        if (a == 0) {
            while (b != 0) {
                boolean bSet = (b & 1) == 1;
                boolean cSet = (c & 1) == 1;
                if (bSet != cSet)
                    count++;
                b >>= 1;
                c >>= 1;
            }
        }

        if (b == 0) {
            while (a != 0) {
                boolean aSet = (a & 1) == 1;
                boolean cSet = (c & 1) == 1;
                if (aSet != cSet)
                    count++;
                a >>= 1;
                c >>= 1;
            }
        }

        while (c != 0) {
            count += c & 1;
            c >>= 1;
        }

        return count;
    }

}
