import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LeetCode_815_BusRoutes {
    
}

class Solution_LeetCode_815_BusRoutes {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        
        Map <Integer, LinkedList<Integer>> adj = new HashMap<>();
    
        generateAdjMatrix(routes, adj);
       
        if (!adj.containsKey(source) || !adj.containsKey(target)) {
            return -1;
        }

        Queue<Integer> queue = new LinkedList<>();
        
        queue.offer(source);
        
        int buses = 0;
        
        
        while (!queue.isEmpty()) {

            Integer vertex = queue.poll();

            LinkedList<Integer> adjList = adj.get(vertex);
            
            for (Integer node : adjList) {
                
                if (node.equals(target)) {

                    break;

                } else {
                    queue.offer(node);
                }
            }

        }


        return 0;
    }

    private void generateAdjMatrix(int [][] routes, Map<Integer, LinkedList<Integer>> adj) {
         
        for (int i =0; i < routes.length; i++) {

            for (int j = 0; j < routes[i].length; j++) {
                
                for (int k = 0; k < routes[i].length; k++) {

                    if (routes[i][j] != routes[i][k]) {

                      adj.computeIfAbsent(routes[i][j], (key) -> new LinkedList<Integer>())
                        .add(routes[i][k]);
                    }
                }
            }
        }
    }
}
