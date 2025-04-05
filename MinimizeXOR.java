import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MinimizeXOR {

    @Test
    public void test1() {
        assertEquals(24, minimizeXor(25, 72));
    }

    @Test
    public void test2() {
        assertEquals(67, minimizeXor(65, 84));
    }

    public int minimizeXor(int num1, int num2) {
        int available = Integer.bitCount(num2);
        StringBuilder builder = new StringBuilder();
        int msbPosition = 31;
        while ((num1 & (1 << msbPosition)) == 0) {
            msbPosition--;
        }
        for (int i = msbPosition; i >= 0; i--) {
            if ((num1 & (1 << i)) != 0 && available > 0) {
                builder.append(1);
                available--;
            } else {
                builder.append(0);
            }
        }

        while (available > 0) {
            builder.append(1);
            available--;
        }

        int ans = Integer.parseInt(builder.toString(), 2);
        return ans;
    }
}
