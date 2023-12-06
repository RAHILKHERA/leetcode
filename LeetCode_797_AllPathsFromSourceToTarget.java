import java.util.List;
import java.util.ArrayList;

public class LeetCode_797_AllPathsFromSourceToTarget {
    public static void main(String[] args) {
        new Solution_LeetCode_797_AllPathsFromSourceToTarget().allPathsSourceTarget(new int [][] {
            {4,3,1}, 
            {3,2,4}, 
            {3}, 
            {4},
            {}});
    }
}

class Solution_LeetCode_797_AllPathsFromSourceToTarget {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
     
        List<List<Integer>> allPaths = new ArrayList<>();
        
        List<Integer> currentPath = new ArrayList<>();
        currentPath.add(0);
        dfs(graph, 0, graph.length - 1, allPaths, currentPath);

        return allPaths;
    }

    private void dfs(int [][] graph, int node, int target, List<List<Integer>> allPaths, List<Integer> currentPath) {

        if (currentPath.get(currentPath.size() - 1) == target) {
            allPaths.add(new ArrayList<>(currentPath));
            return;
        } 

        for (int aNode : graph[node]) {
            currentPath.add(aNode);
            dfs(graph, aNode, target, allPaths, currentPath);
            currentPath.remove(currentPath.size() -1);
        }

    }
}