import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LeetCode_42_TrappingRainWater {

    @Test
    public void test1() {
        assertEquals(6, trap(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }));
    }

    public int trap(int[] height) {

        int[] maxLeft = new int[height.length];
        int max = 0;

        for (int i = 0; i < height.length; i++) {
            maxLeft[i] = max;
            if (max < height[i]) {
                max = height[i];
            }
        }

        max = 0;
        int sum = 0;
        for (int i = height.length - 1; i >= 0; i--) {
            int temp = Math.min(maxLeft[i], max) - height[i];

            if (max < height[i]) {
                max = height[i];
            }

            temp = temp < 0 ? 0 : temp;
            sum += temp;
        }
        return sum;
    }
}
