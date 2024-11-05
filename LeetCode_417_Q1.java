import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LeetCode_417_Q1 {

    @Test
    public void test1() {

        assertEquals('b', kthCharacter(5));
    }

    public char kthCharacter(int k) {

        int count = 0;
        int saveK = k;
        while (k > 0) {
            count++;
            k >>= 1;
        }

        StringBuilder builder = new StringBuilder("a");

        while (count > 0) {
            int length = builder.length();

            for (int i = 0; i < length; i++) {

                char ch = builder.charAt(i);
                ch = ch == 'z' ? 'a' : (char) (ch + 1);
                builder.append(ch);
            }
            count--;
        }

        return builder.charAt(saveK - 1);
    }
}
