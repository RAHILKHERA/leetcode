import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.Test;

public class LeetCode_791_CustomSortString {

    @Test
    public void test1() {
        assertEquals("cbad", customSortString("cba", "abcd"));
    }

    public String customSortString(String order, String s) {

        int[] count = new int[26];
        char[] sArray = s.toCharArray();
        StringBuilder builder = new StringBuilder();

        for (char ch : sArray) {
            count[ch - 'a']++;
        }

        char[] orderArray = order.toCharArray();

        for (int i = 0; i < order.length(); i++) {
            int charCount = count[orderArray[i] - 'a'];
            while (charCount > 0) {
                builder.append(orderArray[i]);
                charCount--;
            }
            count[orderArray[i] - 'a'] = 0;
        }

        for (int i = 0; i < 26; i++) {
            while (count[i] > 0) {
                builder.append((char) (i + 'a'));
                count[i]--;
            }
        }

        return builder.toString();
    }

    public String customSortString0(String order, String s) {

        int[] indexMap = new int[26];
        Arrays.fill(indexMap, Integer.MAX_VALUE);

        char[] orderArray = order.toCharArray();

        for (int i = 0; i < orderArray.length; i++) {
            indexMap[orderArray[i] - 'a'] = i;
        }

        Character[] sArray = new Character[s.length()];

        for (int i = 0; i < s.length(); i++) {
            sArray[i] = s.charAt(i);
        }

        Arrays.sort(sArray, Comparator.comparingInt(c -> indexMap[c - 'a']));

        StringBuilder builder = new StringBuilder();

        for (Character ch : sArray) {
            builder.append(ch);
        }

        return builder.toString();
    }
}
