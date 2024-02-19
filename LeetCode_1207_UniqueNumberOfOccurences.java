import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCode_1207_UniqueNumberOfOccurences {
    public boolean uniqueOccurrences(int[] arr) {

        // int[] numberOfOccurrences = new int[2001];
        Map<Integer, Integer> map = new HashMap<>();
        // boolean[] countAvailable = new boolean[1001];
        Set<Integer> set = new HashSet<>();

        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
            // numberOfOccurrences[1000 + i]++;
        }

        // for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

        // if (countAvailable[entry.getValue()]) {
        // return false;
        // } else {
        // countAvailable[entry.getValue()] = true;
        // }
        // }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            // if (countAvailable[entry.getValue()]) {
            // return false;
            // } else {
            // countAvailable[entry.getValue()] = true;
            // }

            if (set.contains(entry.getValue())) {
                return false;
            } else {
                set.add(entry.getValue());
            }

        }
        // for (int i : numberOfOccurrences) {
        // if (i != 0 && countAvailable[i]) {
        // return false;
        // } else {
        // countAvailable[i] = true;
        // }
        // }

        return true;

    }
}
