import java.util.ArrayList;
import java.util.List;

public class LeetCode_350_IntersectionofTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {

        int[] count = new int[1001];

        for (int num : nums1) {
            count[num]++;
        }

        List<Integer> result = new ArrayList<>();

        for (int num : nums2) {

            if (count[num] > 0) {
                result.add(num);
                count[num]--;
            }
        }

        int[] res = new int[result.size()];
        int index = 0;
        for (int num : result) {
            res[index++] = num;
        }

        return res;

        // return result.stream().mapToInt(Integer::intValue).toArray();

    }
}
