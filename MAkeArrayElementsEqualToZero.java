import java.util.List;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

public class MAkeArrayElementsEqualToZero {

    @Test
    public void test1() {
        assertEquals(2, countValidSelections(new int[] { 1, 0, 2, 0, 3 }));
    }

    @Test
    public void test2() {
        assertEquals(3, countValidSelections(new int[] { 16, 13, 10, 0, 0, 0, 10, 6, 7, 8, 7 }));
    }

    public int countValidSelections(int[] nums) {

        int n = nums.length;
        int[] prefixSum = new int[n];
        int[] suffixSum = new int[n];
        List<Integer> zeros = new ArrayList<>();

        if (nums[0] == 0) {
            zeros.add(0);
        }

        prefixSum[0] = nums[0];
        suffixSum[n - 1] = nums[n - 1];

        for (int i = 1; i < n; i++) {
            prefixSum[i] = nums[i] + prefixSum[i - 1];
            if (nums[i] == 0) {
                zeros.add(i);
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] = nums[i] + suffixSum[i + 1];
        }

        int ans = 0;

        for (int index : zeros) {

            if (prefixSum[index] == suffixSum[index]) {
                ans += 2;
            } else if (prefixSum[index] == suffixSum[index] + 1) {
                ans++;
            } else if (prefixSum[index] + 1 == suffixSum[index]) {
                ans++;
            }
        }

        return ans;
    }
}
