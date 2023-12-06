import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class LeetCode_128_LongestConsecutiveSequence {
    public static void main(String[] args) {
        new Solution_LeetCode_128_LongestConsecutiveSequence().longestConsecutive(new int[] { 0,0 });
    }
}

class Solution_LeetCode_128_LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {

        if (nums.length < 2) {
            return nums.length;
        }

        

        
        HashMap<Integer, boolean []> map = new HashMap<>(nums.length);
        for (int num : nums) {

            if (!map.containsKey(num)) {
                boolean[] neighbours = new boolean[] {false, false};

                if (map.containsKey(num - 1)) {
                    neighbours[0] = true;
                    // Update num -1 neighbours
                    map.get(num - 1)[1] = true;
                }

                if (map.containsKey(num + 1)) {
                    neighbours[1] = true;
                    // Update num +1 neighbours
                     map.get(num + 1)[0] = true;
                }
                map.put(num, neighbours);
            }
        }

        List<Integer> seqStart = new ArrayList<>();

        for (Map.Entry<Integer, boolean []> entry : map.entrySet()) {

            boolean [] neigh = entry.getValue();
            if (!neigh[0] && neigh[1]) {
                seqStart.add(entry.getKey());
            }
        }

        int max = 0;
        for (int start : seqStart) {
            int current = 0;
            boolean found = true;

            while (found) {
                current++;
                found = map.get(start)[1];
                start++;
            }

            if (current > max) {
                max = current;
            }
        }

        return max;
    }
}
