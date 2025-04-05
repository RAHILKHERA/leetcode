import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class LengthOfLongestSubSequenceFibo {
    int maxLength = 0;
    Map<Integer, Integer> map = new HashMap<>();

    @Test
    public void test1() {
        assertEquals(5, lenLongestFibSubseq(new int[] { 1, 2, 3, 4, 5, 6, 7, 8 }));
    }

    public int lenLongestFibSubseq(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }

        solve(arr, 0, new ArrayList<Integer>());
        return maxLength;
    }

    private void solve(int[] arr, int pos, List<Integer> subSequence) {

        int size = subSequence.size();
        if (pos >= arr.length) {

            if (size > 2)
                maxLength = Math.max(maxLength, size);
            return;
        }

        // Take
        if (size < 2) {
            subSequence.add(arr[pos]);
        } else {
            int x = subSequence.get(size - 1);
            int y = subSequence.get(size - 2);
            int nextElement = x + y;
            if (map.containsKey(nextElement)) {
                subSequence.add(nextElement);
                pos = map.get(nextElement);
            }
        }

        // Skip
        solve(arr, pos + 1, subSequence);

    }
}
