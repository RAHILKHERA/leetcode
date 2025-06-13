package Week24_2025;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class LeetCode_2616_MinimizeTheMaximumDifferenceOfPairs {
    
    @Test
    public void test1() {
        assertEquals(0, minimizeMax(new int [] {4,2,1,2}, 1));
    }
    
    
    private int[] nums;
    private int p;
    private int n;

    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        this.nums = nums;
        this.p = p;
        this.n = nums.length;
        int left = 0, right = nums[n - 1] - nums[0];
        int ans = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isValid(mid)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    private boolean isValid(int threshold) {
        int count = 0;

        for (int i = 0; i < n - 1; i++) {
            if (nums[i + 1] - nums[i] <= threshold) {
                count++;
                i++;
                if (count == p) {
                    return true;
                }
            }
        }

        return false;
    }
}
