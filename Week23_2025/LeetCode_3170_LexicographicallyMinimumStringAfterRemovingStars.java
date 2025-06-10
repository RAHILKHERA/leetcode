package Week23_2025;

import java.util.PriorityQueue;

public class LeetCode_3170_LexicographicallyMinimumStringAfterRemovingStars {
    public String clearStars(String s) {
        char[] ch = s.toCharArray();
        PriorityQueue<Pair> queue = new PriorityQueue<>((p1, p2) -> {
            if (p1.ch() == p2.ch()) {
                return p2.position() - p1.position();
            }
            return p1.ch() - p2.ch();
        });

        for (int pos = 0; pos < ch.length; pos++) {
            if (ch[pos] == '*') {
                Pair nonStar = queue.poll();
                ch[nonStar.position()] = '#';
                ch[pos] = '#';
            } else {
                queue.offer(new Pair(ch[pos], pos));
            }
        }

        StringBuilder builder = new StringBuilder();
        
        for (int pos = 0; pos < ch.length; pos++) {
            if (ch[pos] == '#') {
                continue;
            }
            builder.append(ch[pos]);
        }

        return builder.toString();
    }

    private record Pair(char ch, int position) {
    }

}
