import java.util.HashMap;
import java.util.Map;

public class LeetCode_100313_Find_the_Number_of_Distinct_Colors_Among_the_Balls {
    public int[] queryResults(int limit, int[][] queries) {

        int[] results = new int[queries.length];
        Map<Integer, Integer> ballColorMap = new HashMap<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < queries.length; i++) {

            int[] query = queries[i];
            int ball = query[0];
            int color = query[1];

            if (ballColorMap.containsKey(ball)) {
                int oldColor = ballColorMap.get(ball);
                int count = map.get(oldColor);
                count--;
                if (count == 0) {
                    map.remove(oldColor);
                } else {
                    map.put(oldColor, count);
                }

            }

            ballColorMap.put(ball, color);
            int newColorCount = map.getOrDefault(color, 0);
            newColorCount++;
            map.put(color, newColorCount);

            results[i] = map.size();

        }

        return results;
    }
}
