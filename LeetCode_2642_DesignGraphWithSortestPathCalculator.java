import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class LeetCode_2642_DesignGraphWithSortestPathCalculator {
    
    public static void main(String[] args) {
        
        Graph graph = new Graph(4, new int [][] {{0,2,5}, {0,1,2}, {1,2,1}, {3,0,3}});

        System.out.println(graph.shortestPath(3, 2));
        System.out.println(graph.shortestPath(0, 3));
        graph.addEdge(new int [] {1,3,4});
        System.out.println(graph.shortestPath(0, 3));
    }
}

class Graph {

    private int V;
    private List<List<iPair>> adj;


    public Graph(int n, int[][] edges) {
        this.V = n;    
        this.adj = new ArrayList<>();
        init(edges);
    }
    

    public void init(int [][] edges) {

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            addEdge(edges[i][0], edges[i][1], edges[i][2]);
        }
    }

    public void addEdge(int[] edge) {
        addEdge(edge[0], edge[1], edge[2]);
    }

    private void addEdge(int u, int v, int w) {
        adj.get(u).add(new iPair(w, v));
    }
    
    public int shortestPath(int node1, int node2) {
 
      PriorityQueue<iPair> queue = new PriorityQueue<>(V, Comparator.comparingInt(iPair -> iPair.weight));
      int [] dist = new int[V];
      Arrays.fill(dist, Integer.MAX_VALUE);
      dist[node1] = 0;  
      queue.add(new iPair(0, node1));

      while (!queue.isEmpty()) {

        iPair node = queue.poll();
        int vertex = node.getVertex();

        for (iPair adjNodes : adj.get(vertex)) {

            if (dist[adjNodes.getVertex()] > dist[vertex] + adjNodes.getWeight()) {
               dist[adjNodes.getVertex()] =  dist[vertex] + adjNodes.getWeight();
               queue.add(new iPair(dist[adjNodes.getVertex()], adjNodes.getVertex()));
            }

        }

        if (vertex == node2) {
            return dist[vertex];
        }

      }

      if (dist[node2] == Integer.MAX_VALUE) {
        return -1;
      } else {
        return dist[node2]; 
      }
    }

    private static class iPair {
      
        private int weight, vertex;

        public int getWeight() {
            return weight;
        }

        public int getVertex() {
            return vertex;
        }

        public iPair(int weight, int vertex) {
            this.weight = weight;
            this.vertex = vertex;
        }

        public String toString() {
            return "( " + weight + " : " + vertex + " )";
        } 
    
    }
}
