import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class ApplyOperationsToArray {

    @Test
    public void test1() {
        assertArrayEquals(new int[] { 1, 4, 2, 0, 0, 0 }, applyOperations(new int[] { 1, 2, 2, 1, 1, 0 }));
    }

    public int[] applyOperations(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                int j = i + 1;
                while (j < n && nums[j] == 0) {
                    j++;
                }

                if (j < n) { // non zero element found to be swapped.
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
            }
        }

        return nums;
    }
}
