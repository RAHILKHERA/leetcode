import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class LeetCode_380_InsertDeleteGetRandomO_1 {

}

class RandomizedSet {

    private Map<Integer, Integer> map;
    private List<Integer> list;

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();

    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }

        map.put(val, list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }

        int index = map.get(val);
        int lastIndexVal = list.get(list.size() - 1);
        list.set(index, lastIndexVal);
        list.remove(list.size() - 1);
        map.put(lastIndexVal, index);
        map.remove(val);
        return true;
    }

    public int getRandom() {
        Random random = new Random();
        return list.get(random.nextInt(list.size()));
    }
}