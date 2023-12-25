import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode_841_KeysAndRooms {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        Set<Integer> visited = new HashSet<>();
        dfs(rooms, 0, visited);
        return rooms.size() == visited.size();
    }

    private void dfs(List<List<Integer>> rooms, Integer source, Set<Integer> visited) {

        visited.add(source);

        List<Integer> nextKeys = rooms.get(source);

        for (Integer key : nextKeys) {
            if (!visited.contains(key)) {
                dfs(rooms, key, visited);
            }
        }
    }
}
