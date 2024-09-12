import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class LeetCode_1514_PathwithMaximumProbability {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {

        Map<Integer, List<Pair<Double, Integer>>> graph = new HashMap<>();

        for (int i = 0; i < edges.length; i++) {

            int u = edges[i][0];
            int v = edges[i][1];
            double cost = succProb[i];
            graph.computeIfAbsent(u, key -> new ArrayList<>()).add(new Pair<Double, Integer>(cost, v));
            graph.computeIfAbsent(v, key -> new ArrayList<>()).add(new Pair<Double, Integer>(cost, u));
        }

        double[] costs = new double[n];
        PriorityQueue<Pair<Double, Integer>> priorityQueue = new PriorityQueue<>(
                (a, b) -> Double.compare(b.getKey(), a.getKey()));

        priorityQueue.offer(new Pair<Double, Integer>(1d, start_node));
        costs[start_node] = 1d;
        while (!priorityQueue.isEmpty()) {
            Pair<Double, Integer> currentNode = priorityQueue.poll();

            if (currentNode.getValue() == end_node) {
                return costs[end_node];
            }

            List<Pair<Double, Integer>> neighbours = graph.getOrDefault(currentNode.getValue(), new ArrayList<>());

            for (Pair<Double, Integer> neighbour : neighbours) {

                double edgeWeight = neighbour.getKey();
                int node = neighbour.getValue();
                double currentCosts = costs[node];
                double newCosts = costs[currentNode.getValue()] * edgeWeight;
                if (currentCosts < newCosts) {
                    costs[node] = newCosts;
                    priorityQueue.offer(new Pair<Double, Integer>(newCosts, node));
                }

            }
        }

        return costs[end_node];
    }

    class Pair<T, U> {

        private T key;
        private U value;

        Pair(T key, U value) {
            this.key = key;
            this.value = value;
        }

        public T getKey() {
            return key;
        }

        public U getValue() {
            return value;
        }

    }

}
