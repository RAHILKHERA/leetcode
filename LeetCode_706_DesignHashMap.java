
import java.util.LinkedList;

class KeyValuePair {
    int key;
    int value;

    public KeyValuePair(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class MyHashMap {

    private LinkedList<KeyValuePair> map[];
    private int CAPACITY = 16;

    public MyHashMap() {
        map =  new LinkedList[CAPACITY];
        // for (int i = 0; i < CAPACITY; i++) {
        //     map.add(new ArrayList<KeyValuePair>());
        // }
    }

    public void put(int key, int value) {
        int index = key % CAPACITY;

        // ArrayList<KeyValuePair> kvlist = map.get(index);

        // for (KeyValuePair pair : kvlist) {
        //     if (pair.key == key) {
        //         pair.value = value;
        //         return;
        //     }
        // }

        // kvlist.add(new KeyValuePair(key, value));

        if (map[index] == null) {
            map[index] = new LinkedList<>(null);
        }

        for (KeyValuePair pair : map[index]) {
            if (pair.key == key) {
                pair.value = value;
                return;
            }
        }

        map[index].add(new KeyValuePair(key, value)); 
        return;

    }

    public int get(int key) {

        int index = key % CAPACITY;

        // KeyValuePair pair = map.get(index)
        //     .parallelStream()
        //     .filter(node -> node.key == key)
        //     .findAny()
        //     .orElse(new KeyValuePair(key, -1));
          
        // return pair.value;

        if (map[index] == null) {
            return -1;
        }

        for (KeyValuePair pair : map[index]) {
            if (pair.key == key) {
                return pair.value;
            }
        }

        return -1;
    }

    public void remove(int key) {
        
        int index = key % CAPACITY;

        if (map[index] == null) {
            return;
        }

        map[index].removeIf(node -> node.key ==key);

        return;

    }
}

public class LeetCode_706_DesignHashMap {

    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        map.put(1, 1);
        map.put(2,2);
        System.out.println(map.get(1));
        System.out.println(map.get(3));
        map.put(2,1);
        System.out.println(map.get(2));
        map.remove(2);
        System.out.println(map.get(2));
    }
}
