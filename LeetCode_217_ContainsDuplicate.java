import java.util.HashMap;
import java.util.Map;

public class LeetCode_217_ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {

        // Arrays.sort(nums);

        // int i = 1;

        // while (i < nums.length) {
        // if (nums[i - 1] == nums[i]) {
        // return true;
        // }
        // i++;
        // }

        // return false;

        // Set<Integer> set = new HashSet<>();

        // for (int i = 0; i < nums.length; i++) {
        // if (set.contains(nums[i])) {
        // return true;
        // }
        // set.add(nums[i]);
        // }

        // return false;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i : nums) {
            if (map.containsKey(i)) {
                return true;
            }
            map.put(i, i);
        }

        return false;
    }
}
