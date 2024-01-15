import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode_2225_FindPlayerWithZeroOrOneLosses {
    public List<List<Integer>> findWinners(int[][] matches) {

        // Map<Integer, Integer> countMap = new HashMap<>();
        // for (int i = 0; i < matches.length; i++) {
        // countMap.computeIfAbsent(matches[i][0], player -> 0);
        // countMap.compute(matches[i][1], (player, losses) -> (losses == null) ? 1 :
        // losses + 1);
        // }

        // List<Integer> zeroLossList = new ArrayList<>();
        // List<Integer> oneLossList = new ArrayList<>();
        // for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {

        // if (entry.getValue() == 0) {
        // zeroLossList.add(entry.getKey());
        // } else if (entry.getValue() == 1) {
        // oneLossList.add(entry.getKey());
        // }
        // }

        // Collections.sort(zeroLossList);
        // Collections.sort(oneLossList);

        int[] losses = new int[100001];

        for (int i = 0; i < matches.length; i++) {

            int win = matches[i][0];
            int loss = matches[i][1];

            if (losses[win] == 0) {
                losses[win] = -1;
            }

            if (losses[loss] == -1) {
                losses[loss] = 1;
            } else {
                losses[loss]++;
            }
        }

        List<Integer> zeroLossList = new ArrayList<>();
        List<Integer> oneLossList = new ArrayList<>();

        for (int i = 0; i < losses.length; i++) {

            if (losses[i] == -1) {
                zeroLossList.add(i);
            } else if (losses[i] == 1) {
                oneLossList.add(i);
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        result.add(zeroLossList);
        result.add(oneLossList);
        return result;
    }
}
