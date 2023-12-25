import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LeetCode_2101_DetonateTheMaximumBombs {

    public int maximumDetonation(int[][] bombs) {

        /**
         * Bomb (vertex i) can denonate all the bombs mentioned in the list.
         * This is equivalent to creation of the adjacency list.
         */

        Map<Integer, List<Integer>> adjacencyMap = new HashMap<>();

        for (int i = 0; i < bombs.length; i++) {

            long radiusSquare = (long) bombs[i][2] * bombs[i][2];
            adjacencyMap.put(i, new ArrayList<>());
            for (int j = 0; j < bombs.length; j++) {

                if (i != j) {

                    long diffx = bombs[i][0] - bombs[j][0];
                    long diffy = bombs[i][1] - bombs[j][1];
                    if ((diffx * diffx + diffy * diffy) <= radiusSquare) {
                        adjacencyMap.get(i).add(j);
                    }
                }
            }

        }

        /**
         * Executing DFS for every node (bomb), to search all the vertices can be
         * reached (bombs detonated) through a given node (bomb).
         * 
         * Set visited size will be number of bombs detonated from given bomb.
         */

        int max = 0;

        for (int i = 0; i < bombs.length; i++) {

            Set<Integer> visited = new HashSet<>();
            dfs(adjacencyMap, i, visited);
            max = Math.max(max, visited.size());
        }

        return max;
    }

    private void dfs(Map<Integer, List<Integer>> map, Integer source, Set<Integer> visited) {

        visited.add(source);

        List<Integer> nextKeys = map.get(source);

        for (Integer key : nextKeys) {
            if (!visited.contains(key)) {
                dfs(map, key, visited);
            }
        }
    }

}
