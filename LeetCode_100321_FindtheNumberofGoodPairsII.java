import java.util.HashMap;
import java.util.Map;

public class LeetCode_100321_FindtheNumberofGoodPairsII {
    public long numberOfPairs(int[] nums1, int[] nums2, int k) {

        long count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> map1 = new HashMap<>();

        for (int num : nums1) {
            map1.put(num, map1.getOrDefault(num, 0) + 1);
        }

        for (int i = 0; i < nums2.length; i++) {

            nums2[i] *= k;
            map.put(nums2[i], map.getOrDefault(nums2[i], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry1 : map1.entrySet()) {
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry1.getKey() % entry.getKey() == 0) {
                    count += (entry1.getValue() *
                            entry.getValue());
                }
            }
        }

        return count;
    }
}
