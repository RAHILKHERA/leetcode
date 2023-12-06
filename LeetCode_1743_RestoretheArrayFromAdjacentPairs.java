import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LeetCode_1743_RestoretheArrayFromAdjacentPairs {

    public static void main(String[] args) {
        new Solution_LeetCode_1743_RestoretheArrayFromAdjacentPairs()
                .restoreArray(new int[][] { { 2, 1 }, { 3, 4 }, { 3, 2 } });
    }
}

class Solution_LeetCode_1743_RestoretheArrayFromAdjacentPairs {

    public int[] restoreArray(int[][] adjacentPairs) {

        HashMap<Integer, LinkedList<Integer>> adj = new HashMap<>();

        for (int i = 0; i < adjacentPairs.length; i++) {

            adj.computeIfAbsent(adjacentPairs[i][0], (key) -> new LinkedList<Integer>())
               .add(adjacentPairs[i][1]);
            adj.computeIfAbsent(adjacentPairs[i][1], (key) -> new LinkedList<Integer>())
               .add(adjacentPairs[i][0]);
        }

        Integer next = null;

        next = adj.entrySet()
            .stream()
            .filter(entry -> entry.getValue().size() == 1)
            .map(Map.Entry::getKey)
            .findFirst()
            .get();

        int[] result = new int[adjacentPairs.length + 1];

        for (int i = 0; i < result.length; i++) {
            result[i] = next;
            LinkedList<Integer> neighbours = adj.get(next);
            for (Integer neighbour : neighbours) {
                if (adj.containsKey(neighbour)) {
                    adj.remove(next);
                    next = neighbour;
                }
            }

        }

        return result;
    }
}