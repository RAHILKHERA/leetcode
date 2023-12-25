import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode_133_CloneGraph {

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);

        node2.neighbors.add(node1);
        node2.neighbors.add(node3);

        node3.neighbors.add(node2);
        node3.neighbors.add(node4);

        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        Node cloneNode1 = new LeetCode_133_CloneGraph().cloneGraph(node1);
        System.out.println("Clone Node 1 cloning done " + cloneNode1.toString());

    }

    public Node cloneGraph(Node node) {

        if (node == null) {
            return null;
        }

        Map<Node, Node> map = new HashMap<>();

        map.put(node, new Node(node.val));

        dfs(node, map);

        return map.get(node);
    }

    private Node dfs(Node node, Map<Node, Node> map) {

        for (Node neighbor : node.neighbors) {

            if (!map.containsKey(neighbor)) {
                map.put(neighbor, new Node(neighbor.val));
            }
            map.get(node).neighbors.add(map.get(neighbor));
        }

        for (Node neighbor : node.neighbors) {

            if (map.get(neighbor).neighbors.size() == 0) {
                dfs(neighbor, map);
            }
        }

        return node;
    }

    private static class Node {
        public int val;
        public List<Node> neighbors;

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        @Override
        public String toString() {

            List<Integer> adj = new ArrayList<>();
            for (Node neighbor : neighbors) {
                adj.add(neighbor.val);
            }

            String value = "[{val : " + val + ", neighbors : " + adj.toString() + "}]";
            return value;
        }
    }
}
