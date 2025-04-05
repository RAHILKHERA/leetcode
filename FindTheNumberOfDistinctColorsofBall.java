import static org.junit.Assert.assertArrayEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class FindTheNumberOfDistinctColorsofBall {

    @Test
    public void test1() {
        assertArrayEquals(new int[] { 1, 2, 2, 3 },
                queryResults(4, new int[][] { { 1, 4 }, { 2, 5 }, { 1, 3 }, { 3, 4 } }));
    }

    public int[] queryResults(int limit, int[][] queries) {
        // Ball vs Color
        int[] colorMap = new int[limit + 1];
        // Color vs Count Map
        Map<Integer, Integer> map = new HashMap<>();
        int q = queries.length;
        int[] result = new int[q];
        for (int idx = 0; idx < q; idx++) {
            int ball = queries[idx][0];
            int newColor = queries[idx][1];
            if (colorMap[ball] > 0) {// Already colored
                int oldColor = colorMap[ball];
                int count = map.get(oldColor);
                count--;
                if (count == 0) {
                    map.remove(oldColor);
                } else {
                    map.put(oldColor, count);
                }
            }
            colorMap[ball] = newColor;
            map.merge(newColor, 1, Integer::sum);
            result[idx] = map.size();
        }
        return result;
    }
}
