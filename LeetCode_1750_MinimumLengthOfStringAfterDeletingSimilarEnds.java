import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LeetCode_1750_MinimumLengthOfStringAfterDeletingSimilarEnds {

    @Test
    public void test1() {
        assertEquals(2, minimumLength("ca"));
    }

    @Test
    public void test2() {
        assertEquals(0, minimumLength("cabaabac"));
    }

    @Test
    public void test3() {
        assertEquals(3, minimumLength("aabccabba"));
    }

    public int minimumLength(String s) {

        StringBuilder builder = new StringBuilder(s);

        int left = 0, right = builder.length() - 1;

        while (left < right) {

            if (builder.charAt(left) == builder.charAt(right)) {

                char ch = builder.charAt(left);
                int prefixWindowEnd = left, suffixWindowStart = right;

                // find prefix
                while (builder.charAt(prefixWindowEnd) == ch && prefixWindowEnd < suffixWindowStart) {
                    prefixWindowEnd++;
                }

                // find suffix
                while (builder.charAt(suffixWindowStart) == ch && suffixWindowStart > prefixWindowEnd) {
                    suffixWindowStart--;
                }

                builder.delete(left, prefixWindowEnd);
                if (builder.length() > 1) {
                    builder.delete(suffixWindowStart - prefixWindowEnd + left + 1, right - prefixWindowEnd + left + 1);
                } else {
                    builder.delete(suffixWindowStart - prefixWindowEnd + left, right - prefixWindowEnd + left + 1);
                }

                left = 0;
                right = builder.length() - 1;

            } else {
                break;
            }
        }

        return builder.length();
    }
}
