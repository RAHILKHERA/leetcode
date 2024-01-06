import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

public class LeetCode_332_ReconstructItinerary {
    public static void main(String[] args) {
        List<List<String>> tickets = new ArrayList<List<String>>();
        List<String> ticket0 = Arrays.asList("JFK", "SFO");
        List<String> ticket1 = Arrays.asList("JFK", "ATL");
        List<String> ticket2 = Arrays.asList("SFO", "ATL");
        List<String> ticket3 = Arrays.asList("ATL", "JFK");
        List<String> ticket4 = Arrays.asList("ATL", "SFO");

        tickets.add(ticket0);
        tickets.add(ticket1);
        tickets.add(ticket2);
        tickets.add(ticket3);
        tickets.add(ticket4);

        // List<String> ticket0 = Arrays.asList("MUC", "LHR");
        // List<String> ticket1 = Arrays.asList("JFK", "MUC");
        // List<String> ticket2 = Arrays.asList("SFO", "SJC");
        // List<String> ticket3 = Arrays.asList("LHR", "SFO");

        // tickets.add(ticket0);
        // tickets.add(ticket1);
        // tickets.add(ticket2);
        // tickets.add(ticket3);

        // List<String> ticket0 = Arrays.asList("JFK", "KUL");
        // List<String> ticket1 = Arrays.asList("JFK", "NRT");
        // List<String> ticket2 = Arrays.asList("NRT", "JFK");

        // tickets.add(ticket0);
        // tickets.add(ticket1);
        // tickets.add(ticket2);

        new Solution_LeetCode_332_ReconstructItinerary().findItinerary(tickets);
    }
}

class Solution_LeetCode_332_ReconstructItinerary {
    public List<String> findItinerary(List<List<String>> tickets) {

        HashMap<String, List<String>> destinationMap = new HashMap<String, List<String>>();

        for (List<String> ticket : tickets) {
            destinationMap.computeIfAbsent(ticket.get(0), key -> new ArrayList<>())
                    .add(ticket.get(1));
        }

        for (Map.Entry<String, List<String>> entry : destinationMap.entrySet()) {
            entry.getValue().sort(String::compareTo);
        }

        List<String> itinerary = new ArrayList<String>();
        dfs("JFK", destinationMap, itinerary);
        return itinerary;
    }

    private void dfs(String source, Map<String, List<String>> destinationMap, List<String> itinerary) {

        List<String> neighbors = destinationMap.get(source);

        if (neighbors != null) {
            while (!neighbors.isEmpty()) {
                String nextDestination = neighbors.remove(0);
                dfs(nextDestination, destinationMap, itinerary);
            }
        }

        // Add the current source to the beginning of the itinerary
        itinerary.add(0, source);
    }
}
