import java.util.PriorityQueue;

public class LeetCode_1845_SeatReservationManager {
    
}

class Solution_LeetCode_1845_SeatReservationManager {

}

class SeatManager {

    int pointer = 0;
    PriorityQueue<Integer> queue;
    
    public SeatManager(int n) {
        
        queue = new PriorityQueue<Integer>(n);
    }
    
    public int reserve() {
        if (queue.isEmpty()) {
            pointer++;
            return pointer;
        }
       return queue.poll();       
    }
    
    public void unreserve(int seatNumber) {
        queue.add(seatNumber);
    }
}