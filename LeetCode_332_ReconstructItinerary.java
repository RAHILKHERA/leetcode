import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

public class LeetCode_332_ReconstructItinerary {
    public static void main(String[] args) {
        List<List<String>> tickets  =  new ArrayList<List<String>>() ;
        // List<String> ticket0 = Arrays.asList("JFK", "SFO");
        // List<String> ticket1 = Arrays.asList("JFK", "ATL");
        // List<String> ticket2 = Arrays.asList("SFO", "ATL");
        // List<String> ticket3 = Arrays.asList("ATL", "JFK");
        // List<String> ticket4 = Arrays.asList("ATL", "SFO");

        // tickets.add(ticket0);
        // tickets.add(ticket1);
        // tickets.add(ticket2);
        // tickets.add(ticket3);
        // tickets.add(ticket4);
           
        
        // List<String> ticket0 = Arrays.asList("MUC", "LHR");
        // List<String> ticket1 = Arrays.asList("JFK", "MUC");
        // List<String> ticket2 = Arrays.asList("SFO", "SJC");
        // List<String> ticket3 = Arrays.asList("LHR", "SFO");
        

        // tickets.add(ticket0);
        // tickets.add(ticket1);
        // tickets.add(ticket2);
        // tickets.add(ticket3);

        List<String> ticket0 = Arrays.asList("JFK", "KUL");
        List<String> ticket1 = Arrays.asList("JFK", "NRT");
        List<String> ticket2 = Arrays.asList("NRT", "JFK");

        

        tickets.add(ticket0);
        tickets.add(ticket1);
        tickets.add(ticket2);


        new Solution_LeetCode_332_ReconstructItinerary().findItinerary(tickets);
    }
}

class  Solution_LeetCode_332_ReconstructItinerary {
    public List<String> findItinerary(List<List<String>> tickets) {
        
        HashMap<String, List<String>> destinationMap  = new HashMap<String, List<String>>();

        for ( List<String> ticket : tickets) {

            String departure = ticket.get(0);
            String arrival = ticket.get(1);
            if (destinationMap.containsKey(departure)) {
                List<String> destinations = destinationMap.get(departure);
                destinations.add(arrival);

            } else {
                List<String> destinations = new ArrayList<String>(); 
                destinations.add(arrival);
                destinationMap.put(departure, destinations);
            }
        }

        for (Map.Entry<String, List<String>> entry : destinationMap.entrySet()) {
            entry.getValue().sort((a,b) -> { 
                if (destinationMap.containsKey(a) && destinationMap.containsKey(b)) {
                    return a.compareTo(b) ;
                } else {
                    if(destinationMap.containsKey(a)) {
                        return -1;
                    } else {
                        return 1;
                    }
                }
                
            });
        }

        List<String> itinerary = new ArrayList<String>();
        String nextStop = "JFK";
        String currentStop = "";
        itinerary.add(nextStop);
        while (destinationMap.size() > 0) {
            
            List<String> availableDestinations = destinationMap.get(nextStop);
            if (availableDestinations != null) {
                currentStop = nextStop;
                nextStop = availableDestinations.get(0);
            }
          
            itinerary.add(nextStop);
            if (availableDestinations != null) {
                availableDestinations.remove(0);
                if (availableDestinations.size() == 0) {
                    destinationMap.remove(currentStop);
                }
            }
            
        }        
        return itinerary;
    }
}
