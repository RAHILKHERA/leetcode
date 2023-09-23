import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class LeetCode_1282_GroupthePeopleGiventheGroupSizeTheyBelongTo {
    public static void main(String[] args) {
        int[] groupSizes = { 2, 1, 3, 3, 3, 2 };
        new Solution_LeetCode_1282_GroupthePeopleGiventheGroupSizeTheyBelongTo().groupThePeople(groupSizes);
    }
}

class Solution_LeetCode_1282_GroupthePeopleGiventheGroupSizeTheyBelongTo {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {

        List<List<Integer>> results = new ArrayList<List<Integer>>();
        HashMap<Integer, List<List<Integer>>> bucket = new HashMap<Integer, List<List<Integer>>>();
        List<List<Integer>> groups = null;
        List<Integer> group = null;

        for (int i = 0; i < groupSizes.length; i++) {
            if (bucket.containsKey(groupSizes[i])) {
                groups = bucket.get(groupSizes[i]);
                boolean emptyGroupFound = false;
                for (List<Integer> currentGroup : groups) {
                    if (currentGroup.size() < groupSizes[i]) {
                        group = currentGroup;
                        emptyGroupFound = true;
                        break;
                    }
                }
                if (emptyGroupFound) {
                    group.add(i);
                    // bucket.put(groupSizes[i],groups);
                } else {
                    group = new ArrayList<Integer>();
                    group.add(i);
                    groups.add(group);
                    bucket.put(groupSizes[i], groups);
                }
            } else {
                groups = new ArrayList<List<Integer>>();
                group = new ArrayList<Integer>();
                group.add(i);
                groups.add(group);
                bucket.put(groupSizes[i], groups);
            }
        }

        bucket.forEach((key, values) -> {
            for (List<Integer> value : values) {
                results.add(value);
            }
        });

        return results;
    }
}
