import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeetCode_1508_RangeSumofSortedSubarraySums {
    public int rangeSum(int[] nums, int n, int left, int right) {

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                list.add(sum);
            }
        }

        Collections.sort(list);

        int result = 0, mod = (int) 1e9 + 7;

        for (int i = left - 1; i < right; i++) {
            result = (result + list.get(i)) % mod;
        }

        return result;
    }
}
