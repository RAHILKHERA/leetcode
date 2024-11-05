import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class LIS_BinarySearch {

    @Test
    public void test1() {
        assertEquals(5, getLIS(new int[] { 10, 22, 9, 33, 21, 50, 41, 60 }));
    }

    public int getLIS(int[] nums) {

        int n = nums.length;
        List<Integer> ans = new ArrayList<>();

        ans.add(nums[0]);

        for (int i = 1; i < n; i++) {

            if (nums[i] > ans.get(ans.size() - 1)) {
                ans.add(nums[i]);
            } else {

                int low = Collections.binarySearch(ans, nums[i]);
                if (low < 0) {
                    low = -(low + 1);
                }
                ans.set(low, nums[i]);
            }

        }
        return ans.size();
    }
}
