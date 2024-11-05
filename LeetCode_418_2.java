import static org.junit.Assert.assertArrayEquals;

import java.util.*;

import org.junit.Test;

public class LeetCode_418_2 {

    @Test
    public void test1() {
        remainingMethods(4, 1, new int[][] { { 1, 2 }, { 0, 1 }, { 3, 2 } });
    }

    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {

        Map<Integer, List<Integer>> adj = new HashMap<>();
        Map<Integer, List<Integer>> in = new HashMap<>();

        for (int[] invocation : invocations) {
            adj.computeIfAbsent(invocation[0], key -> new ArrayList<>()).add(invocation[1]);
            in.computeIfAbsent(invocation[1], key -> new ArrayList<>()).add(invocation[0]);
        }

        // List of suspicious nodes
        Set<Integer> visited = new HashSet<>();

        // BFS to search all suspicious nodes
        Queue<Integer> queue = new LinkedList<>();
        queue.add(k);
        visited.add(k);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neigh : adj.getOrDefault(node, new ArrayList<>())) {
                if (!visited.contains(neigh)) {
                    queue.offer(neigh);
                    visited.add(neigh);
                }
            }
        }

        boolean canRemove = true;
        for (int node : visited) {
            for (int inNode : in.getOrDefault(node, new ArrayList<>())) {
                if (!visited.contains(inNode)) {
                    canRemove = false;
                    break;
                }
            }

            if (!canRemove) {
                break;
            }
        }

        List<Integer> result = new ArrayList<>();

        if (canRemove) {
            for (int i = 0; i < n; i++) {
                if (!visited.contains(i)) {
                    result.add(i);
                }
            }

        } else {
            for (int i = 0; i < n; i++) {
                result.add(i);
            }
        }

        String a = "abc";
        String b = "def";
        a.compareTo(b);
        return result;
    }
}
