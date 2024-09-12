import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class LeetCode_1249_MinimumRemoveToMakeValidParentheses {

    @Test
    public void test1() {
        assertEquals("", minRemoveToMakeValid("))(("));
    }

    public String minRemoveToMakeValid(String s) {

        StringBuilder builder = new StringBuilder(s);
        int i = 0, count = 0;

        while (i < builder.length()) {

            char ch = builder.charAt(i);
            if (ch == '(') {
                count++;
                i++;
            } else if (ch == ')') {
                if (count == 0) {
                    builder.deleteCharAt(i);
                } else {
                    count--;
                    i++;
                }

            } else {
                i++;
            }
        }

        if (count > 0) {

            count = 0;
            System.out.println("Length after first loop: " + builder.length());

            i = builder.length() - 1;

            while (i >= 0) {

                char ch = builder.charAt(i);

                if (ch == ')') {
                    count++;
                    i--;
                } else if (ch == '(') {
                    if (count == 0) {
                        builder.deleteCharAt(i);
                        i--;
                    } else {
                        count--;
                        i--;
                    }
                } else {
                    i--;
                }
            }

        }

        return builder.toString();
    }
}
