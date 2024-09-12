import java.util.ArrayDeque;
import java.util.Arrays;

public class LeetCode_950_RevelCardsInIncreasingOrder {
    public int[] deckRevealedIncreasing(int[] deck) {

        int n = deck.length;
        int[] result = new int[n];
        Arrays.sort(deck);
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.offer(deck[n - 1]);

        for (int i = n - 2; i >= 0; i--) {

            int last = queue.poll();
            queue.offer(last);
            queue.offer(deck[i]);
        }

        int index = n - 1;
        while (!queue.isEmpty() && index >= 0) {
            deck[index] = queue.poll();
            index--;
        }

        return result;
    }
}
