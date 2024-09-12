import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode_834_SumOfDistancesInTree {

    int root_result = 0;
    int[] count;
    int N;

    public int[] sumOfDistancesInTree(int n, int[][] edges) {

        Map<Integer, List<Integer>> adj = new HashMap<>();
        N = n;
        count = new int[n];

        if (edges.length == 0) {
            return new int[n];
        }

        for (int[] is : edges) {

            int u = is[0];
            int v = is[1];

            adj.computeIfAbsent(u, (key) -> new ArrayList<>()).add(v);
            adj.computeIfAbsent(v, (key) -> new ArrayList<>()).add(u);
        }

        dfsRoot(adj, 0, -1, 0);

        int[] result = new int[n];
        result[0] = root_result;

        dfs(adj, 0, -1, result);

        return result;

    }

    private void dfs(Map<Integer, List<Integer>> adj, int parentNode, int prevNode, int[] result) {

        for (int child : adj.get(parentNode)) {

            if (child == prevNode) {
                continue;
            }

            result[child] = result[parentNode] - count[child] + (N - count[child]);

            dfs(adj, child, parentNode, result);
        }
    }

    private int dfsRoot(Map<Integer, List<Integer>> adj, int currNode, int prevNode, int currentDepth) {

        int totalCount = 1;

        root_result += currentDepth;

        for (int child : adj.get(currNode)) {

            if (child == prevNode) {
                continue;
            }

            totalCount += dfsRoot(adj, child, currNode, currentDepth + 1);
        }

        count[currNode] = totalCount;
        return totalCount;

    }
}
