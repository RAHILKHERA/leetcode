
import static org.junit.Assert.assertEquals;

import java.util.PriorityQueue;

import org.junit.Test;

public class LeetCode_3170_LexicographicallyMinimumStringAfterRemovingStars {

    @Test
    public void test1() {
        assertEquals("aab", clearStars("aaba*"));
    }

    public String clearStars(String s) {

        PriorityQueue<Pair> queue = new PriorityQueue<>((Pair p1, Pair p2) -> {
            if (p1.ch == p2.ch) {
                return Integer.compare(p2.index, p1.index);
            }
            return Character.compare(p1.ch, p2.ch);
        });
        StringBuilder builder = new StringBuilder(s);

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch != '*') {
                queue.offer(new Pair(ch, i));
            } else {
                builder.setCharAt(queue.poll().index, '*');
            }
        }

        for (int i = builder.length() - 1; i >= 0; i--) {
            char ch = builder.charAt(i);
            if (ch == '*') {
                builder.deleteCharAt(i);
            }
        }

        return builder.toString();
    }

    class Pair {
        char ch;
        int index;

        Pair(char ch, int index) {

            this.ch = ch;
            this.index = index;
        }

    }
}
