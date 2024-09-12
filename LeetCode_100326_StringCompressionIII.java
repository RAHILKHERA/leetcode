import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LeetCode_100326_StringCompressionIII {

    @Test
    public void test1() {
        assertEquals("1a1b1c1d1e", compressedString("abcde"));
    }

    @Test
    public void test2() {
        assertEquals("9a5a2b", compressedString("aaaaaaaaaaaaaabb"));
    }

    @Test
    public void test3() {
        assertEquals("9m9m9z9z9y2y1f1v1s", compressedString("mmmmmmmmmmmmmmmmmmzzzzzzzzzzzzzzzzzzyyyyyyyyyyyfvs"));
    }

    public String compressedString(String word) {

        StringBuilder result = new StringBuilder();

        char[] wordArray = word.toCharArray();

        int i = 0, j = 0;

        while (j < wordArray.length) {

            while (j < wordArray.length && wordArray[i] == wordArray[j]) {
                j++;
            }

            int count = j - i;

            if (count > 9) {

                int div = count / 9;
                int rem = count % 9;

                while (div > 0) {
                    result.append(9);
                    result.append(wordArray[i]);
                    div--;
                }

                if (rem > 0) {
                    result.append(rem);
                    result.append(wordArray[i]);
                }

            } else {
                result.append(count);
                result.append(wordArray[i]);
            }

            i = j;

        }

        return result.toString();
    }
}
