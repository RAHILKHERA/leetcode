import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LeetCode_399_EvaluateDivision {

    public static void main(String[] args) {

        // List<List<String>> myList = new ArrayList<>();

        // List<String> innerList1 = new ArrayList<>();
        // innerList1.add("a");
        // innerList1.add("b");

        // List<String> innerList2 = new ArrayList<>();
        // innerList2.add("b");
        // innerList2.add("c");

        // myList.add(innerList1);
        // myList.add(innerList2);

        // List<List<String>> queries = new ArrayList<>();

        // queries.add(Arrays.asList("a", "c"));
        // queries.add(Arrays.asList("b", "a"));
        // queries.add(Arrays.asList("a", "e"));
        // queries.add(Arrays.asList("a", "a"));
        // queries.add(Arrays.asList("x", "x"));

        List<List<String>> equations = new ArrayList<>();
        List<List<String>> queries = new ArrayList<>();

        // Populate equations list
        // equations.add(Arrays.asList("a", "b"));
        // equations.add(Arrays.asList("b", "c"));
        // equations.add(Arrays.asList("bc", "cd"));

        // // Populate queries list
        // queries.add(Arrays.asList("a", "c"));
        // queries.add(Arrays.asList("c", "b"));
        // queries.add(Arrays.asList("bc", "cd"));
        // queries.add(Arrays.asList("cd", "bc"));
        equations.add(Arrays.asList("a", "b"));
        queries.add(Arrays.asList("a", "b"));
        queries.add(Arrays.asList("b", "a"));
        queries.add(Arrays.asList("a", "c"));
        queries.add(Arrays.asList("x", "y"));

        new LeetCode_399_EvaluateDivision().calcEquation(equations, new double[] { 0.5 }, queries);
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        Map<String, Map<String, Double>> adjacencyList = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {

            List<String> equation = equations.get(i);
            double value = values[i];
            double reverseValue = 1 / value;

            adjacencyList.computeIfAbsent(equation.get(0), key -> new HashMap<>()).computeIfAbsent(equation.get(1),
                    key -> value);

            adjacencyList.computeIfAbsent(equation.get(1), key -> new HashMap<>()).computeIfAbsent(equation.get(0),
                    key -> reverseValue);

        }

        int index = 0;
        double[] result = new double[queries.size()];
        for (List<String> query : queries) {

            String source = query.get(0);
            String target = query.get(1);

            if (!adjacencyList.containsKey(source) || !adjacencyList.containsKey(target)) {
                result[index] = -1.0;
            } else if (source.equals(target)) {
                result[index] = 1.0;
            } else if (adjacencyList.get(source).get(target) != null) {
                result[index] = adjacencyList.get(source).get(target);
            } else {
                List<Double> distances = new ArrayList<>();
                if (dfs(source, target, adjacencyList, new HashSet<>(), distances)) {
                    double answer = 1.0;
                    for (Double distance : distances) {
                        answer *= distance;
                    }
                    result[index] = answer;
                } else {
                    result[index] = -1.0;
                }
            }
            index++;
        }

        return result;
    }

    private boolean dfs(String source, String target, Map<String, Map<String, Double>> adjacencyList,
            Set<String> visited, List<Double> distances) {

        if (source.equals(target)) {
            visited.add(target);
            return true;
        }

        visited.add(source);
        Map<String, Double> negibhor = adjacencyList.get(source);

        for (Map.Entry<String, Double> entry : negibhor.entrySet()) {

            if (!visited.contains(entry.getKey())) {
                distances.add(entry.getValue());
                if (dfs(entry.getKey(), target, adjacencyList, visited, distances)) {
                    return true;
                }
                distances.remove(distances.size() - 1);
            }
        }

        return false;
    }

}
