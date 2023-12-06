import java.util.LinkedHashMap;
import java.util.Map;

public class LeetCode_146_LRUCache {
    
}

class LRUCache {

    private LinkedHashMap<Integer, Integer> map;
    private final int CAPACITY;


    public LRUCache(int capacity) {
        CAPACITY = capacity;
        map = new   LinkedHashMap<>(capacity, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest)
            {
                return size() > CAPACITY;
            }
        };  
    }
    
    public int get(int key) {
            if (map.containsKey(key)) {
                return key;
            }
           return -1;
    }
    
    public void put(int key, int value) {
        map.put(key, value);
    }
}
