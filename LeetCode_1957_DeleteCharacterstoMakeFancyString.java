import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LeetCode_1957_DeleteCharacterstoMakeFancyString {

    @Test
    public void test1() {
        assertEquals("leetcode", makeFancyString("leeetcode"));
    }

    public String makeFancyString(String s) {

        int n = s.length();
        int left = 0;
        int right = 0;
        char[] ch = s.toCharArray();
        StringBuilder builder = new StringBuilder();
        while (left < n && right < n) {

            while (right < n && ch[left] == ch[right]) {
                right++;
            }

            if (right - left >= 2) {
                builder.append(ch[left]);
            }
            builder.append(ch[left]);
            left = right;
        }
        return builder.toString();
    }
}