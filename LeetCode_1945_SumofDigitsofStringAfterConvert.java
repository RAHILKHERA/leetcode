import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class LeetCode_1945_SumofDigitsofStringAfterConvert {

    @Test
    public void test1() {
        assertEquals(8, getLucky("zbax", 2));
    }

    public int getLucky(String s, int k) {
        StringBuilder builder = new StringBuilder();
        char[] charArray = s.toCharArray();

        for (char ch : charArray) {
            int num = ch - 'a' + 1;
            builder.append(num);
        }

        String transformString = builder.toString();

        while (k > 0) {
            transformString = transform(transformString);
            k--;
        }

        return Integer.parseInt(transformString);
    }

    private String transform(String num) {

        char[] numArray = num.toCharArray();
        int sum = 0;

        for (char c : numArray) {
            sum += (c - '0');
        }

        return Integer.toString(sum);
    }
}
