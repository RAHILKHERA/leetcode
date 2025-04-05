import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.PriorityQueue;

import org.junit.Test;

public class ConstructStringWithRepeatLimit {

    @Test
    public void test1() {

        assertTrue(repeatLimitedString("cczazcc", 3).equals("zzcccac"));
    }

    @Test
    public void test2() {

        assertTrue(repeatLimitedString("aababab", 2).equals("bbabaa"));
    }

    public String repeatLimitedString(String s, int repeatLimit) {
        StringBuilder builder = new StringBuilder();
        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> Character.compare(b, a));
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                pq.offer((char) (i + 'a'));
            }
        }

        int count = 0;
        char lastChar = '\0';

        while (!pq.isEmpty()) {

            char top = pq.poll();
            char save = '\0';
            // Can use char available at the top.
            if (top != lastChar || count < repeatLimit) {
                if (top != lastChar)
                    count = 0;
                builder.append(top);
                lastChar = top;
                count++;
                freq[top - 'a']--;
                if (freq[top - 'a'] > 0) {
                    pq.offer(top);
                }
            } else if (!pq.isEmpty()) { // Cannot use the char as the max limit is reached.
                save = top;
                top = pq.poll();
                builder.append(top);
                lastChar = top;
                count = 1;
                freq[top - 'a']--;
                if (freq[top - 'a'] > 0) {
                    pq.offer(top);
                }
                pq.offer(save);
            } else {
                break;
            }
        }

        return builder.toString();
    }
}
