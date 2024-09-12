import java.util.HashMap;
import java.util.Map;

public class LeetCode_992_SubarraysWithKDifferentIntegers {

    /**
     * Sliding Window with 3 pointers.
     * farLeft and Right pointers represents the largest valid window.
     * nearLeft and Right pointers represents the smallest valid window.
     * size of the map represents number of unique elements in the subarray.
     * 
     * If we have an element in abundance we will move the nearLeft to shrink the
     * window.
     * If we have more than required (k) number of distinct elements, we will move
     * farLeft and nearLeft till there are only required keys. As the moment there
     * are more than required, the subarray is not valid.
     * Hence shrink the window, neither current largest and smallest window are
     * valid.
     * 
     * 
     * !Important.
     * 
     * @param nums
     * @param k
     * @return
     */
    public int subarraysWithKDistinct(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        int farLeft = 0;
        int nearLeft = 0;
        int right = 0;

        while (right < nums.length) {

            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            while (map.size() > k) {
                int nearLeftCount = map.get(nums[nearLeft]);
                nearLeftCount--;
                if (nearLeftCount == 0) {
                    map.remove(nums[nearLeft]);
                } else {
                    map.put(nums[nearLeft], nearLeftCount);
                }
                nearLeft++;
                farLeft = nearLeft;
            }

            while (map.getOrDefault(nums[nearLeft], 0) > 1) {
                int nearLeftCount = map.get(nums[nearLeft]);
                nearLeftCount--;
                map.put(nums[nearLeft], nearLeftCount);
                nearLeft++;
            }

            if (map.size() == k) {
                res += nearLeft - farLeft + 1;
            }

            right++;
        }

        return res;

    }
}
