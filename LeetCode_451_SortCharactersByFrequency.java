import java.util.PriorityQueue;

public class LeetCode_451_SortCharactersByFrequency {
    public String frequencySort(String s) {

        int[] freq = new int[123];
        char[] charArray = s.toCharArray();

        for (char c : charArray) {
            freq[c]++;
        }

        PriorityQueue<Pair> queue = new PriorityQueue<>();
        for (int i = 0; i < 123; i++) {
            if (freq[i] > 0) {
                queue.offer(new Pair((char) i, freq[i]));
            }
        }

        StringBuilder builder = new StringBuilder();
        while (!queue.isEmpty()) {
            Pair currentPair = queue.poll();
            for (int i = 0; i < currentPair.getCount(); i++) {
                builder.append(currentPair.getChar());
            }
        }

        return builder.toString();
    }

    private class Pair implements Comparable<Pair> {

        private char ch;
        private int count;

        Pair(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }

        public char getChar() {
            return ch;
        }

        public int getCount() {
            return count;
        }

        @Override
        public int compareTo(Pair o) {
            return -1 * Integer.compare(count, o.count);
        }

    }
}
